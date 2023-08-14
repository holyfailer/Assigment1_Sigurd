package dk.experis.Heroes.Archer;

import dk.experis.Heroes.Hero;
import dk.experis.Heroes.HeroAttribute;

public class Archer extends Hero {

    public Archer(String name) {
        super(name, new HeroAttribute(1,5,1));
    }


    @Override
    public void LevelUp() {

    }
}
