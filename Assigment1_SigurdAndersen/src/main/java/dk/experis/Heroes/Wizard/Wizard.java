package dk.experis.Heroes.Wizard;

import dk.experis.Heroes.Hero;
import dk.experis.Heroes.HeroAttribute;

public class Wizard extends Hero {
    //Constructor. Sets starting attributes to the fixed values.

    public Wizard(String name) {
        super(name, new HeroAttribute(1,1,8));
    }
    //overridden that gives the specific hero its appropriate stats on level up.
    @Override
    public HeroAttribute getLevelUpAttribute() {
        return new HeroAttribute(1, 1, 5);
    }
}
