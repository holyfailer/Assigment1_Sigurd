package dk.experis.Heroes.Swashbuckler;

import dk.experis.Heroes.Hero;
import dk.experis.Heroes.HeroAttribute;

public class Swashbuckler extends Hero {
    public Swashbuckler(String name) {
        super(name, new HeroAttribute(2,6,1));
    }

    @Override
    public HeroAttribute getLevelUpAttribute() {
        return new HeroAttribute(2, 6, 1);
    }
}
