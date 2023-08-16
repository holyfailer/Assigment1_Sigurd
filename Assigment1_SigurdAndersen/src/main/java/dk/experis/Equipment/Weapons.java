package dk.experis.Equipment;

public class Weapons extends Item{

    private WeaponsType weaponsType;
    private int damage;


    public Weapons(String name, int requiredLevel, WeaponsType weaponsType, int damage) {
        super(name, requiredLevel, Slot.WEAPON);
        this.weaponsType = weaponsType;
        this.damage = damage;
    }

    public WeaponsType getWeaponsType() {
        return weaponsType;
    }

    public int getDamage() {
        return damage;
    }
}
