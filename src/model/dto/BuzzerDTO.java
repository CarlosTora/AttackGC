package model.dto;

import model.entity.Spaceships;

public class BuzzerDTO extends Spaceships {

    private int units = 0;
    private int priorityBattle = 5;
    private String name = "Buzzer";
    private int attack = 9250;
    private int defense = 2950;
    private int capacity = 15000;
    private int armor = 5900;
    private int resistance = 50;

    public BuzzerDTO(int units) {
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
