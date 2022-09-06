package model.dto;

import model.entity.Spaceships;

public class OvertankDTO extends Spaceships {
    private int units = 0;
    private String name = "Overtank";
    private int priorityBattle = 6;
    private int attack = 24000;
    private int defense = 17920;
    private int capacity = 440000;
    private int armor = 35840;
    private int resistance = 80;

    public OvertankDTO(int units) {
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
