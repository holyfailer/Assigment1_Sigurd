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
        int level = 1;
        this.levelAttribute = levelAttribute;
    }

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
               throw new InvalidWeaponException("Cant equip that type of Armor");
           } else if (item.getRequiredLevel() > getLevel()) {
               throw  new InvalidArmorException("Too low level for that armor");
           }
       }

       equippedItems.put(item.getSlot(),item);

   }


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



    public void LevelUp() {
        level++;
        levelAttribute=levelAttribute.add(getLevelUpAttribute());

    }

    public HeroAttribute totalAttributes() {
        HeroAttribute total = levelAttribute;
        for (Item item : equippedItems.values()) {
            if (item instanceof Armor armor) {
                total = total.add(armor.getArmorAttribute());
            }
        }
        return total;
    }

    public double damage() {
        int weaponDamage = 1;
        double damagingAttribute=0;
        Item weapon=null;

        if (equippedItems.containsKey(Slot.WEAPON)) {
             weapon = equippedItems.get(Slot.WEAPON);
        }if (weapon instanceof Weapons ) {
            weaponDamage = ((Weapons) weapon).getDamage();
        }

        if (this instanceof Barbarian) {
            damagingAttribute= totalAttributes().getStrength();
        } else if (this instanceof Wizard) {
            damagingAttribute= totalAttributes().getIntelligence();
        } else if (this instanceof Archer || this instanceof Swashbuckler) {
            damagingAttribute= totalAttributes().getDexterity();
        }

        return (weaponDamage * (1 + (damagingAttribute/100) ));
    }

    public void display(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hero name: "+getName()+ System.getProperty("line.separator"));
        stringBuilder.append("Hero class: "+ getClass().getSimpleName() + System.getProperty("line.separator"));
        stringBuilder.append("Hero level: "+getLevel()+ System.getProperty("line.separator"));
        stringBuilder.append("Total Strength: "+ totalAttributes().getStrength()+ System.getProperty("line.separator"));
        stringBuilder.append("Total dexterity: "+ totalAttributes().getDexterity()+ System.getProperty("line.separator"));
        stringBuilder.append("Total Intelligence: "+ totalAttributes().getIntelligence()+ System.getProperty("line.separator"));
        stringBuilder.append("Hero damage: "+ damage()+ System.getProperty("line.separator"));



        System.out.println(stringBuilder);
    }

    public String getName() {
        return name;
    }



    public int getLevel() {
        return level;
    }

    public HeroAttribute getLevelUpAttribute() {
        return levelAttribute;
    }


}

