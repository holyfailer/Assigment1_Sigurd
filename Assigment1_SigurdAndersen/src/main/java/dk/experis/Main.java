package dk.experis;

import dk.experis.Equipment.*;
import dk.experis.Exceptions.InvalidArmorException;
import dk.experis.Exceptions.InvalidWeaponException;
import dk.experis.Heroes.Archer.Archer;
import dk.experis.Heroes.Barbarian.Barbarian;
import dk.experis.Heroes.HeroAttribute;
import dk.experis.Heroes.Wizard.Wizard;

public class Main {
    public static void main(String[] args) {

        Wizard wizard = new Wizard("Steve");
        Barbarian barbarian= new Barbarian("Bob");
        Archer archer = new Archer("Legless Legolas");

        Weapons staff = new Weapons("staff",2,WeaponsType.STAFF,10);
        Weapons sword = new Weapons("Sword", 2, WeaponsType.SWORD, 5);
        Weapons bow = new Weapons("Bow of Legless Legolas",5,WeaponsType.BOW, 20);

        Armor clothBody = new Armor("Cloth",2,Slot.BODY, ArmorType.CLOTH, new HeroAttribute(1,1,5));
        Armor clothLegs = new Armor("Cloth",2,Slot.LEGS, ArmorType.CLOTH, new HeroAttribute(1,1,5));
        Armor clothHead = new Armor("Cloth",2,Slot.HEAD, ArmorType.CLOTH, new HeroAttribute(1,1,5));

        wizard.levelUp();

        barbarian.levelUp();

        archer.levelUp();
        archer.levelUp();
        archer.levelUp();
        archer.levelUp();

        try{
            wizard.equipItem(staff);
            wizard.equipItem(clothBody);
            wizard.equipItem(clothHead);
            wizard.equipItem(clothLegs);

            archer.equipItem(bow);

            barbarian.equipItem(sword);
        }catch (InvalidWeaponException | InvalidArmorException e) {
            System.out.println("Error: " + e.getMessage());
        }

        wizard.display();
            System.out.println();
        barbarian.display();
            System.out.println();
        archer.display();




    }
}