package model.entity;

public class Spaceships implements Comparable<Spaceships>,Cloneable{

    private int units;
    private String name;
    private int priorityBattle;
    private int attack;
    private int defense;
    private int capacity;
    private int armor;
    private int resistance;

    public int getUnits() {
        return units;
    }

    public int getPriorityBattle() {
        return priorityBattle;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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


    @Override
    public String toString() {
        return getName()+"{"+
                "units=" + getUnits() +
                '}';
    }

    @Override
    public int compareTo(Spaceships o) {
        return Integer.compare(this.getPriorityBattle(), o.getPriorityBattle());
    }

    @Override
    public Spaceships clone() {
        try {
            Spaceships clone = (Spaceships) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
