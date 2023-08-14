package dk.experis.Heroes;

public abstract class Hero {
    private String name;
    private int level;
    private HeroAttribute levelAttribute;



    public Hero(String name, HeroAttribute levelAttribute) {
        this.name = name;
        int level = 1;
        this.levelAttribute = levelAttribute;
    }

    public void LevelUp() {

    }

    void Equip(){

    }

    void Damage(){

    }

    void TotalAttributes() {

    }

    void Display(){

    }
}

