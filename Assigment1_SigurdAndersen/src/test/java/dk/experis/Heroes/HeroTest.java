package dk.experis.Heroes;

import dk.experis.Equipment.*;
import dk.experis.Exceptions.InvalidArmorException;
import dk.experis.Exceptions.InvalidWeaponException;
import dk.experis.Heroes.Wizard.Wizard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {

    @Test
    public void equipItem_shouldEquipValidStaffOnWizard() {

        Wizard wizard = new Wizard("Steve");
        Weapons staff = new Weapons("staff",1, WeaponsType.STAFF,10);
        //act
        try{
        wizard.equipItem(staff);
        }catch (InvalidWeaponException  | InvalidArmorException e) {
            fail("Shouldn't happen: "+e.getMessage());
        }
        //assert
        assertTrue(wizard.isItemEquipped(staff));
    }

    @Test
    public void equipItem_ShouldThrowInvalidWeaponExceptionForTooLowLevel(){
        //arrange
        Wizard wizard = new Wizard("Steve");
        Weapons staff = new Weapons("staff",2, WeaponsType.STAFF,10);
        //act
        try{
            wizard.equipItem(staff);
            fail("Should have thrown exception InvalidWeapon");
        }catch (InvalidWeaponException  | InvalidArmorException e) {
            assertEquals("Too low level for that weapon",e.getMessage());
        }
        //assert

    }

    @Test
    public void levelUp_ShouldMakeBasicWizardLevel2(){
        Wizard wizard = new Wizard("Steve");
        wizard.levelUp();

        int expectedLevel = 2;
        int actual= wizard.getLevel() ;

        assertEquals(expectedLevel,actual);
    }

    @Test
    public void damage_shouldReturn1point08_BasicWizard() {
        Wizard wizard = new Wizard("Steve");

        double weaponDamageWithOutWeapon = 1;
        double intAttribute = 8;
        //damage formula
        double expected= weaponDamageWithOutWeapon*(1+ (intAttribute/100));
        double actual = wizard.damage();

        assertEquals(expected,actual);

    }

    @Test
    public void damage_shouldReturn108_EquippedWizard() {
        Wizard wizard = new Wizard("Steve");
        Weapons staff = new Weapons("staff",1, WeaponsType.STAFF,100);
        Armor clothBody = new Armor("Cloth",1,Slot.BODY, ArmorType.CLOTH, new HeroAttribute(1,1,100));
        try {
            wizard.equipItem(staff);
            wizard.equipItem(clothBody);
        }catch (Exception e) {
            fail("Shouldn't happen:" + e.getMessage());
        }

        double intAttributeWithEquipment= 108;
        double weaponDamage= 100;
        double expected= weaponDamage*(1+ (intAttributeWithEquipment/100));
        double actual = wizard.damage();

        assertEquals(expected,actual);

    }

    @Test
    public void totalAttributes_TestsIfWizardGetAttributes_shouldReturn8_BasicWizard() {
        Wizard wizard = new Wizard("Steve");

        int expected = 8;

        int actual = wizard.totalAttributes().getIntelligence();

        assertEquals(expected,actual);

    }

    @Test
    public void totalAttributes_TestsIfWizardGetAttributes_shouldReturn8_EquippedWizard() {
        Wizard wizard = new Wizard("Steve");
        Armor clothBody = new Armor("Cloth",1,Slot.BODY, ArmorType.CLOTH, new HeroAttribute(1,1,5));

        try {
            wizard.equipItem(clothBody);
        }catch (Exception e) {
            fail("Shouldn't happen:" + e.getMessage());
        }
        int startingAttribute = 8;
        int equipmentAttribute = 5;
        int expected = startingAttribute+ equipmentAttribute;

        int actual = wizard.totalAttributes().getIntelligence();

        assertEquals(expected,actual);

    }



}