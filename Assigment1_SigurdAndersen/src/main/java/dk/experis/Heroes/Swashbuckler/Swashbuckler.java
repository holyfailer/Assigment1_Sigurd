package dk.experis.Heroes.Swashbuckler;

import dk.experis.Heroes.Hero;
import dk.experis.Heroes.HeroAttribute;

public class Swashbuckler extends Hero {

    //Constructor. Sets starting attributes to the fixed values.
    public Swashbuckler(String name) {
        super(name, new HeroAttribute(2,6,1));
    }

    //overridden that gives the specific hero its appropriate stats on level up.
    @Override
    public HeroAttribute getLevelUpAttribute() {
        return new HeroAttribute(2, 6, 1);
    }
}
