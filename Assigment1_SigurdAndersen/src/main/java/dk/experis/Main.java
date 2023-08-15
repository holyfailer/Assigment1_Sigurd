package dk.experis;

import dk.experis.Heroes.Archer.Archer;
import dk.experis.Heroes.HeroAttribute;
import dk.experis.Heroes.Wizard.Wizard;

public class Main {
    public static void main(String[] args) {

        Wizard wizard = new Wizard("steve");



        wizard.LevelUp();
        System.out.println("level is: "+ wizard.getLevel());
        System.out.println("Strength is: " + wizard.totalAttributes().getStrength());
        System.out.println("Dex is: " + wizard.totalAttributes().getDexterity());
        System.out.println("int is: " + wizard.totalAttributes().getIntelligence());
        System.out.println("");
        wizard.LevelUp();
        System.out.println("level is: "+ wizard.getLevel());
        System.out.println("Strength is: " + wizard.totalAttributes().getStrength());
        System.out.println("Dex is: " + wizard.totalAttributes().getDexterity());
        System.out.println("int is: " + wizard.totalAttributes().getIntelligence());
        System.out.println("");
        wizard.LevelUp();
        System.out.println("level is: "+ wizard.getLevel());
        System.out.println("Strength is: " + wizard.totalAttributes().getStrength());
        System.out.println("Dex is: " + wizard.totalAttributes().getDexterity());
        System.out.println("int is: " + wizard.totalAttributes().getIntelligence());

    }
}