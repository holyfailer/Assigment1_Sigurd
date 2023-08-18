package dk.experis.Heroes;

import dk.experis.Equipment.Armor;
import dk.experis.Equipment.ArmorType;
import dk.experis.Equipment.Slot;
import dk.experis.Heroes.Wizard.Wizard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroAttributeTest {

    @Test
    void add_addTwoArmorsAttributesTogether_TestOnIntelligenceAttribute_shouldReturn2() {
        Armor plate = new Armor("plate",1, Slot.HEAD, ArmorType.PLATE,new HeroAttribute(1,1,1));
        Armor plate2 = new Armor("plate2",1, Slot.LEGS, ArmorType.PLATE,new HeroAttribute(1,1,1));

        HeroAttribute actual = plate.getArmorAttribute().add(plate2.getArmorAttribute());

        HeroAttribute expected = new HeroAttribute(2,2,2);

       assertEquals( expected.getIntelligence(),actual.getIntelligence());

    }

    @Test
    void add_addTwoArmorsAttributesTogether_TestOnStrengthAttribute_shouldReturn2() {
        Armor plate = new Armor("plate",1, Slot.HEAD, ArmorType.PLATE,new HeroAttribute(1,1,1));
        Armor plate2 = new Armor("plate2",1, Slot.LEGS, ArmorType.PLATE,new HeroAttribute(1,1,1));

        HeroAttribute actual = plate.getArmorAttribute().add(plate2.getArmorAttribute());

        HeroAttribute expected = new HeroAttribute(2,2,2);

        assertEquals( expected.getIntelligence(),actual.getStrength());

    }

    @Test
    void add_addTwoArmorsAttributesTogether_TestOnDexterityAttribute_shouldReturn2() {
        Armor plate = new Armor("plate",1, Slot.HEAD, ArmorType.PLATE,new HeroAttribute(1,1,1));
        Armor plate2 = new Armor("plate2",1, Slot.LEGS, ArmorType.PLATE,new HeroAttribute(1,1,1));

        HeroAttribute actual = plate.getArmorAttribute().add(plate2.getArmorAttribute());

        HeroAttribute expected = new HeroAttribute(2,2,2);

        assertEquals( expected.getIntelligence(),actual.getDexterity());

    }
}