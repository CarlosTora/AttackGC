package model.dto;

import model.entity.Spaceships;

public class SupernovaDTO extends Spaceships {

    private int units = 0;
    private String name = "Supernova";
    private int attack = 368000;
    private int priorityBattle = 8;
    private int defense = 370000;
    private int capacity = 6500000;
    private int armor = 740000;
    private int resistance = 70;

    public SupernovaDTO(int units) {
        this.units = units;
    }

    public String getName() {
        return name;
    }

    public int getPriorityBattle() {
        return priorityBattle;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getResistance() {
        return resistance;
    }

    public void setResistance(int resistance) {
        this.resistance = resistance;
    }

}
