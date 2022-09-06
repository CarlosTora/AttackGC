package model.dto;

import model.entity.Spaceships;

public class RyderDTO extends Spaceships {
    private int units = 0;
    private int priorityBattle = 2;
    private String name = "Ryder";
    private int attack = 336;
    private int defense = 180;
    private int capacity = 8000;
    private int armor = 360;
    private int resistance = 40;

    public RyderDTO(int units) {
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
