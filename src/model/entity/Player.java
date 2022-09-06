package model.entity;

import java.util.List;

public class Player {

    private String userName;
    private List<Spaceships> listSpaceships;
    private int titanium;
    private int aluminium;
    private int bunkerTitanium;
    private int bunkerAluminium;
    private boolean tacticalRetreat;

    // investigation
    private int investAttack;
    private int investDefense;


    public Player(String userName, List<Spaceships> listSpaceships, int titanium, int aluminium, int bunkerTitanium,
                  int bunkerAluminium, boolean tacticalRetreat, int investAttack, int investDefense) {
        this.userName = userName;
        this.listSpaceships = listSpaceships;
        this.titanium = titanium;
        this.aluminium = aluminium;
        this.bunkerTitanium = bunkerTitanium;
        this.bunkerAluminium = bunkerAluminium;
        this.tacticalRetreat = tacticalRetreat;
        this.investAttack = investAttack;
        this.investDefense = investDefense;
    }

    public boolean isTacticalRetreat() {
        return tacticalRetreat;
    }

    public void setTacticalRetreat(boolean tacticalRetreat) {
        this.tacticalRetreat = tacticalRetreat;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Spaceships> getListSpaceships() {
        return listSpaceships;
    }

    public void setListSpaceships(List<Spaceships> listSpaceships) {
        this.listSpaceships = listSpaceships;
    }

    public int getTitanium() {
        return titanium;
    }

    public void setTitanium(int titanium) {
        this.titanium = titanium;
    }

    public int getAluminium() {
        return aluminium;
    }

    public void setAluminium(int aluminium) {
        this.aluminium = aluminium;
    }

    public int getBunkerTitanium() {
        return bunkerTitanium;
    }

    public void setBunkerTitanium(int bunkerTitanium) {
        this.bunkerTitanium = bunkerTitanium;
    }

    public int getBunkerAluminium() {
        return bunkerAluminium;
    }

    public void setBunkerAluminium(int bunkerAluminium) {
        this.bunkerAluminium = bunkerAluminium;
    }

    public int getInvestAttack() {
        return investAttack;
    }

    public void setInvestAttack(int investAttack) {
        this.investAttack = investAttack;
    }

    public int getInvestDefense() {
        return investDefense;
    }

    public void setInvestDefense(int investDefense) {
        this.investDefense = investDefense;
    }


    @Override
    public String toString() {
        return  userName+"{" +
                "listSpaceships=" + listSpaceships +
                '}';
    }
}
