package dk.experis.Equipment;

public class Weapons extends Item{

    private WeaponsType weaponsType;
    private int damage;


    public Weapons(String name, int requiredLevel, Slot slot, WeaponsType weaponsType, int damage) {
        super(name, requiredLevel, slot);
        this.weaponsType = weaponsType;
        this.damage = damage;
    }


}
