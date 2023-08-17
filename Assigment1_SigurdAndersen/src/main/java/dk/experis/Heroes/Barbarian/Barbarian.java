package dk.experis.Heroes.Barbarian;

import dk.experis.Heroes.Hero;
import dk.experis.Heroes.HeroAttribute;

public class Barbarian extends Hero {
    //Constructor. Sets starting attributes to the fixed values.

    public Barbarian(String name) {
        super(name, new HeroAttribute(5,2,1));
    }
    //overridden that gives the specific hero its appropriate stats on level up.
    @Override
    public HeroAttribute getLevelUpAttribute() {
        return new HeroAttribute(3, 2, 1);
    }
}
