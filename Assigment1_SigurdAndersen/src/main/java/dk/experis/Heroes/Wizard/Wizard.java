package dk.experis.Heroes.Wizard;

import dk.experis.Heroes.Hero;
import dk.experis.Heroes.HeroAttribute;

public class Wizard extends Hero {
    public Wizard(String name) {
        super(name, new HeroAttribute(1,1,8));
    }
}
