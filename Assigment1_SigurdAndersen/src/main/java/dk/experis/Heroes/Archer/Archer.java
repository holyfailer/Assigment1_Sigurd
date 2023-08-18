package dk.experis.Heroes.Archer;

import dk.experis.Heroes.Hero;
import dk.experis.Heroes.HeroAttribute;

public class Archer extends Hero {

    //Constructor. Sets starting attributes to the fixed values.

    public Archer(String name) {
        super(name, new HeroAttribute(1,7,1));
    }

    //overridden that gives the specific hero its appropriate stats on level up.
    @Override
    public HeroAttribute getLevelUpAttribute() {
        return new HeroAttribute(1, 5, 1);
    }


}
