package dk.experis.Equipment;

import dk.experis.Heroes.HeroAttribute;

public class Armor extends Item{
    private ArmorType armorType;
    private HeroAttribute armorAttribute;

    public Armor(String name, int requiredLevel, Slot slot, ArmorType armorType, HeroAttribute armorAttribute) {
        super(name, requiredLevel, slot);
        this.armorType = armorType;
        this.armorAttribute = armorAttribute;
    }
}
