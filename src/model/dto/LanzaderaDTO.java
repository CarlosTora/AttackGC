package model.dto;

import model.entity.Spaceships;

public class LanzaderaDTO extends Spaceships {

    private int units = 0;
    private String name = "Lanzadera";
    private int priorityBattle = 7;
    private int attack = 129000;
    private int defense = 110400;
    private int capacity = 2300000;
    private int armor = 220800;
    private int resistance = 60;

    public LanzaderaDTO(int units) {
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
