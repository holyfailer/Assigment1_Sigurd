package dk.experis.Heroes;

import dk.experis.Equipment.*;
import dk.experis.Exceptions.InvalidArmorException;
import dk.experis.Exceptions.InvalidWeaponException;
import dk.experis.Heroes.Archer.Archer;
import dk.experis.Heroes.Barbarian.Barbarian;
import dk.experis.Heroes.Swashbuckler.Swashbuckler;
import dk.experis.Heroes.Wizard.Wizard;

import java.util.HashMap;
import java.util.Map;

public abstract class Hero {
    private String name;
    private int level=1;
    private HeroAttribute levelAttribute;
    private Map<Slot, Item> equippedItems = new HashMap<>();


    public Hero(String name, HeroAttribute levelAttribute) {
        this.name = name;
        this.levelAttribute = levelAttribute;
    }

    //Equip item method. Equips a given item to the class. Checks using the helper function canEquipWeapon and canEquipArmor,
    //if the class is able to equip a given item, otherwise throws an exception.
    //Similarly, if the hero is too low a level.
   public void equipItem(Item item) throws InvalidWeaponException, InvalidArmorException {

        if (item instanceof Weapons weapons) {
            if (!canEquipWeapon(weapons.getWeaponsType())) {
                throw new InvalidWeaponException("Cant equip that type of weapon");
            } else if (item.getRequiredLevel() > getLevel()) {
                throw new InvalidWeaponException("Too low level for that weapon");
            }
        }
       if (item instanceof Armor armor) {
           if (!canEquipArmor(armor.getArmorType())) {
               throw new InvalidArmorException("Cant equip that type of armor");
           } else if (item.getRequiredLevel() > getLevel()) {
               throw  new InvalidArmorException("Too low level for that armor");
           }
       }

       equippedItems.put(item.getSlot(),item);

   }


   //Private helper method. Checks if a given class can equip their given weapon types. This is not tested as it is a private function.
    private boolean canEquipWeapon(WeaponsType weaponType) {
        if (this instanceof Wizard) {
            return weaponType == WeaponsType.STAFF || weaponType == WeaponsType.WAND;
        } else if (this instanceof Archer) {
            return weaponType == WeaponsType.BOW;
        } else if (this instanceof Swashbuckler) {
            return weaponType == WeaponsType.DAGGER || weaponType == WeaponsType.SWORD;
        } else if (this instanceof Barbarian) {
            return weaponType == WeaponsType.HATCHET || weaponType == WeaponsType.MACE || weaponType == WeaponsType.SWORD  ;
        }
        return false;
    }
    //same as above but for armor.
    private boolean canEquipArmor(ArmorType armorType) {
        if (this instanceof Wizard) {
            return armorType == ArmorType.CLOTH ;
        } else if (this instanceof Archer) {
            return armorType == ArmorType.LEATHER || armorType == ArmorType.MAIL ;
        } else if (this instanceof Swashbuckler) {
            return armorType == ArmorType.LEATHER || armorType == ArmorType.MAIL ;
        } else if (this instanceof Barbarian) {
            return armorType == ArmorType.MAIL || armorType == ArmorType.PLATE ;
        }
        return false;
    }


    //Level function. Increments the level by 1 and add the getLevelAttributes,
    // which is an overridden method in each specific class that returns a new HeroAttribute with the level up attributes.
    public void levelUp() {
        level++;
        levelAttribute=levelAttribute.add(getLevelUpAttribute());

    }

    //Method that takes the totalAttributes of a hero. First it puts the heroes own basic and level Up attributes
    // and put it in a locale variable. It then checks all the equipped armor items and add their attribute value to the total.
    public HeroAttribute totalAttributes() {
        HeroAttribute total = levelAttribute;
        for (Item item : equippedItems.values()) {
            if (item instanceof Armor armor) {
                total = total.add(armor.getArmorAttribute());
            }
        }
        return total;
    }
    // calculate damage method. Create a locale weaponDamage set to 1 for the case when the hero isn't equipped and damagingAttribute.
    public double damage() {
        int weaponDamage = 1;
        double damagingAttribute=0;
        Item localWeapon;
        //it checks the weapon slot if a weapon is available and assigns the weapons damage to weaponDamage.
        if (equippedItems.containsKey(Slot.WEAPON)) {
             localWeapon = equippedItems.get(Slot.WEAPON);
            weaponDamage = ((Weapons) localWeapon).getDamage();
        }
//It then checks the heroes class and fetches the relevant damagingAttribute.
        if (this instanceof Barbarian) {
            damagingAttribute= totalAttributes().getStrength();
        } else if (this instanceof Wizard) {
            damagingAttribute= totalAttributes().getIntelligence();
        } else if (this instanceof Archer || this instanceof Swashbuckler) {
            damagingAttribute= totalAttributes().getDexterity();
        }
//return the damage based on the formula.
        return (weaponDamage * (1 + (damagingAttribute/100) ));
    }

    //Display function that displays the various fields. Uses a string builder.
    public void display(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hero name: "+getName()+ System.getProperty("line.separator"));
        stringBuilder.append("Hero class: "+ getClass().getSimpleName() + System.getProperty("line.separator"));
        stringBuilder.append("Hero level: "+getLevel()+ System.getProperty("line.separator"));
        stringBuilder.append("Total Strength: "+ totalAttributes().getStrength()+ System.getProperty("line.separator"));
        stringBuilder.append("Total dexterity: "+ totalAttributes().getDexterity()+ System.getProperty("line.separator"));
        stringBuilder.append("Total Intelligence: "+ totalAttributes().getIntelligence()+ System.getProperty("line.separator"));
        stringBuilder.append("Hero damage: "+ damage()+System.getProperty("line.separator"));

        System.out.print(stringBuilder);
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    //gets the attributes from leveling up. Overridden in specific hero classes
    public HeroAttribute getLevelUpAttribute() {
        return levelAttribute;
    }

    //simple method that checks if the item hashMap contains a given item. Used for testing.
    public boolean isItemEquipped(Item item) {
        return equippedItems.containsValue(item);
    }


}

