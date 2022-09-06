package model.dto;

import model.entity.Spaceships;

public class CorsarioDTO extends Spaceships {

    private int units = 0;
    private int priorityBattle = 3;
    private String name = "Corsario";
    private int attack = 620;
    private int defense = 441;
    private int capacity = 14500;
    private int armor = 882;
    private int resistance = 50;

    public CorsarioDTO(int units) {
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
