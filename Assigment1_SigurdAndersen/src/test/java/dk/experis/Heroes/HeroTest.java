package dk.experis.Heroes;

import dk.experis.Equipment.*;
import dk.experis.Exceptions.InvalidArmorException;
import dk.experis.Exceptions.InvalidWeaponException;
import dk.experis.Heroes.Wizard.Wizard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {
    //arrange

    //act


    //assert
    @Test
    public void equipItem_shouldEquipValidStaffOnWizard() {
        //arrange
        Wizard wizard = new Wizard("Steve");
        Weapons staff = new Weapons("staff",2, WeaponsType.STAFF,10);
        Armor clothBody = new Armor("Cloth",2, Slot.BODY, ArmorType.CLOTH, new HeroAttribute(1,1,5));
        try{
        wizard.equipItem(staff);



        }catch (InvalidWeaponException  | InvalidArmorException e) {
            fail("Exception shouldn't be thrown");
        }

        //act

        //assert

    }

    @Test
    public void canEquipWeapon_ShouldGiveTrueWhenWizardEquipStaff() {
        Wizard wizard = new Wizard("Steve");
        Weapons staff = new Weapons("staff",2, WeaponsType.STAFF,10);



    }

    @Test
    public void levelUp_ShouldMakeBasicWizardLevel2(){
        Wizard wizard = new Wizard("Steve");
        wizard.LevelUp();

        int expectedLevel = 2;
        int actual= wizard.getLevel() ;

        assertEquals(expectedLevel,actual);
    }

    @Test
    public void damage_shouldReturn1point08ForBasicWizard() {
        Wizard wizard = new Wizard("Steve");
        double expected= 1.08;
        double actual = wizard.damage();

        assertEquals(expected,actual);

    }

    @Test
    public void damage_shouldReturn108ForEquippdWizard() {
        Wizard wizard = new Wizard("Steve");
        Weapons staff = new Weapons("staff",2, WeaponsType.STAFF,100);
        try {
            wizard.equipItem(staff);
        }catch (Exception e) {
            fail("Shouldnt happen");
        }


        double expected= 108;
        double actual = wizard.damage();

        assertEquals(expected,actual);

    }

}