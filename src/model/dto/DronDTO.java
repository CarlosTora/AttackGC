package model.dto;

import model.entity.Spaceships;

public class DronDTO extends Spaceships {

    private int units = 0;
    private int priorityBattle = 1;
    private String name = "Dron";
    private int attack = 87;
    private int defense = 72;
    private int capacity = 2650;
    private int armor = 144;
    private int resistance = 30;

    public DronDTO(int units) {
        this.units = units;
    }

    public int getUnits() {
        return units;
    }

    public String getName() {
        return name;
    }

    public int getPriorityBattle() {
        return priorityBattle;
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
