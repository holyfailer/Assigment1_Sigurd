package dk.experis.Heroes.Barbarian;

import dk.experis.Heroes.Hero;
import dk.experis.Heroes.HeroAttribute;

public class Barbarian extends Hero {
    public Barbarian(String name) {
        super(name, new HeroAttribute(5,2,1));
    }

    @Override
    public HeroAttribute getLevelUpAttribute() {
        return new HeroAttribute(3, 2, 1);
    }
}
