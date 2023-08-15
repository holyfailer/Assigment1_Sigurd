package dk.experis.Heroes;

import dk.experis.Equipment.Item;
import dk.experis.Equipment.Slot;

import java.util.HashMap;
import java.util.Map;

public abstract class Hero {
    private String name;
    private int level=1;
    private HeroAttribute levelAttribute;

    private Map<Slot, Item> equippedItems = new HashMap<>();


    public Hero(String name, HeroAttribute levelAttribute) {
        this.name = name;
        int level = 1;
        this.levelAttribute = levelAttribute;
    }

   //protected abstract HeroAttribute getLevelUpAttribute();
    public void LevelUp() {
        level++;
        levelAttribute=levelAttribute.add(getLevelUpAttribute());

    }

    public HeroAttribute totalAttributes() {
        return levelAttribute;
    }


    public int getLevel() {
        return level;
    }

    public HeroAttribute getLevelUpAttribute() {
        return levelAttribute;
    }
}

