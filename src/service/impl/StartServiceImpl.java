package service.impl;

import model.dto.*;
import model.entity.Player;
import model.entity.Spaceships;
import service.StartService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class StartServiceImpl implements StartService {

    InvestigationsImpl investigations = new InvestigationsImpl();

    public int armorStatusDEF = -1;
    public int defenseStatusDEF = -1;

    int armorStatusATK = -1;
    int defenseStatusATK = -1;

    List<Spaceships> listATKupdated = new ArrayList<>();
    List<Spaceships> listDEFupdated = new ArrayList<>();

    /**
     * Function that generates the users for the battle
     * @return list players ( attack & defense )
     */
    @Override
    public List<Player> CreatePlayersBattle() {

        List<Spaceships> listSpaceshipsATK = new ArrayList<>();
        listSpaceshipsATK.add(new DronDTO(1000));


        List<Spaceships> listSpaceshipsDEF = new ArrayList<>();
        listSpaceshipsDEF.add(new DronDTO(1000));


        Player playerAtack = new Player("PLAYER 1 ATK", listSpaceshipsATK,10000,10000,500,
                500,false,5,0);
        Player playerDef = new Player("PLAYER 2 DEF", listSpaceshipsDEF,102000,100300,5010,
                5010,false,5,0);

        List<Player> playersBattle = new ArrayList<Player>();
        playersBattle.add(playerAtack);
        playersBattle.add(playerDef);
        return playersBattle;
    }


    /**
     * battle logic
     * @param player1 Player 1
     * @param player2 Player 2
     * @return List players with result battle
     */
    @Override
    public List<Player> ResultBattle(Player player1, Player player2) {

        listATKupdated.clear();
        listDEFupdated.clear();
        Player pATK;
        Player pDEF;

        if(player1.getUserName().contains("ATK")) {
            pATK = player1;
            pDEF = player2;
        }else {
            pATK = player2;
            pDEF = player1;
        }
        List<Player> playersBattle = new ArrayList<>();

        playersBattle.add(pATK);
        playersBattle.add(pDEF);
        GetBonifInv(pATK,pDEF);

        Iterator<Spaceships> iterator = pATK.getListSpaceships().iterator();
        while(iterator.hasNext()){
            listATKupdated.add(iterator.next().clone());
        }

        iterator = pDEF.getListSpaceships().iterator();
        while(iterator.hasNext()){
            listDEFupdated.add(iterator.next().clone());
        }



        // 5 round battle system
        int round = 0;
        do {
            round++;

            if(listATKupdated.size()>0 || listDEFupdated.size() >0) {

                // SHOOT ATTACK PLAYER
                shootRound(pATK.getListSpaceships(),listDEFupdated,armorStatusDEF,defenseStatusDEF,false);

                // SHOOT DEFENSE PLAYER
                shootRound(pDEF.getListSpaceships(),listATKupdated,armorStatusATK,defenseStatusATK,true);

                // UPDATE RESULT
                updateResultList(pATK,pDEF);

                // After the first round, check if the attacker has tactical retreat.
                if(pATK.isTacticalRetreat() && round == 1) {
                    // if defense attack have more 20% power that attacker power, the attacker he retired
                    // ACTION -- COMMAND THURIM --
                    break;
                }
            }
            else {
                round = 5; // If one of the players runs out of ships, if the battle ends
            }


        } while (round < 5);

        pATK.setListSpaceships(listATKupdated);
        pDEF.setListSpaceships(listDEFupdated);

        return playersBattle;
    }


    private void updateResultList(Player pATK, Player pDEF) {
        pATK.getListSpaceships().clear();
        Iterator<Spaceships> iterator = listATKupdated.iterator();
        while(iterator.hasNext()){
            pATK.getListSpaceships().add(iterator.next().clone());
        }
        pDEF.getListSpaceships().clear();
        iterator =listDEFupdated.iterator();
        while(iterator.hasNext()){
            pDEF.getListSpaceships().add(iterator.next().clone());
        }
    }

    private void shootRound(List<Spaceships> listShipShooting, List<Spaceships> listShipGetDamage, int armorPrevius, int defensePrevius, boolean isAttack) {

        int extraDamage = 0;
        int armorDEF = listShipGetDamage.get(0).getArmor();
        int defenseDEF = listShipGetDamage.get(0).getDefense();

        for ( Spaceships shipsAction : listShipShooting) {  // we go class by class of ships

            for(int i = 0 ; i< shipsAction.getUnits(); i ++) { //action for the entire Units

                do {
                    if(listShipGetDamage.size() > 0) {  // Check if enemy have spaceships

                        if (armorPrevius > -1) {  // if the armor has been damaged before
                            armorDEF = armorPrevius;
                            armorPrevius = -1;
                        }
                        if (defensePrevius > -1) { // if the defense has been damaged before
                            defenseDEF = defensePrevius;
                            defensePrevius = -1;
                        }

                        int nRandom = (int) (Math.random() * 100);
                        // check if the shield is activated ( damage to armor )
                        if (listShipGetDamage.get(0).getResistance() > nRandom) {

                            // It checks if there is damage left over from the previous attack
                            if (extraDamage == 0) {  // No damage extra
                                armorDEF = armorDEF - shipsAction.getAttack();
                            } else { // Yes damage extra, then, that damage is subtracted from the ARMOR
                                armorDEF = armorDEF + (extraDamage);
                                extraDamage = 0;
                            }


                            if (armorDEF < 1) { // if armor its broken, extra damage go to defenseShip
                                defenseDEF = defenseDEF + armorDEF;  // subtract the excess damage to the defense
                                armorDEF = 0;
                                armorPrevius = 0; // we keep that the ARMOR is broken

                                if (defenseDEF < 0) { // if defense its broken, this starship its eliminated
                                    extraDamage = extraDamage + defenseDEF;// get extra no applied damage
                                    listShipGetDamage.get(0).setUnits(listShipGetDamage.get(0).getUnits() - 1); // the ship has died, and we subtract that unit from the total

                                    if (listShipGetDamage.get(0).getUnits() < 1) { // we check if there are units of that type
                                        listShipGetDamage.remove(0);
                                    }
                                    if (listShipGetDamage.size() > 0) {
                                        // NEXT SPACESHIP -> RESTART DATA
                                        armorDEF = listShipGetDamage.get(0).getArmor();
                                        defenseDEF = listShipGetDamage.get(0).getDefense();
                                        defensePrevius = -1;
                                        armorPrevius = -1;
                                    }
                                } else { // ship not destroyed
                                    defensePrevius = defenseDEF; //Save actually defense
                                }
                            } else {
                                armorPrevius = armorDEF;
                            }

                        } else { // direct damage to defense

                            // It checks if there is damage left over from the previous attack
                            if (extraDamage == 0) {  // No damage extra
                                armorDEF = armorDEF - shipsAction.getAttack();
                            } else { // Yes damage extra, then, that damage is subtracted from the ARMOR
                                armorDEF = armorDEF + (extraDamage);
                                extraDamage = 0;
                            }

                            if (defenseDEF < 0) { // if defense its broken, this starship its eliminated
                                extraDamage = extraDamage + defenseDEF;// get extra no applied damage
                                listShipGetDamage.get(0).setUnits(listShipGetDamage.get(0).getUnits() - 1); // the ship has died, and we subtract that unit from the total


                                if (listShipGetDamage.get(0).getUnits() < 1) { // we check if there are units of that type
                                    listShipGetDamage.remove(0);
                                }
                                if (listShipGetDamage.size() > 0) {
                                    // NEXT SPACESHIP -> RESTART DATA
                                    armorDEF = listShipGetDamage.get(0).getArmor();
                                    defenseDEF = listShipGetDamage.get(0).getDefense();
                                    defensePrevius = -1;
                                    armorPrevius = -1;
                                }
                            } else {
                                defensePrevius = defenseDEF;
                            }
                        }
                    }
                    else {
                        extraDamage = 0;
                    }
                }while (extraDamage != 0);

            }
        }

        if(isAttack){
            armorStatusATK = armorPrevius  ;
            defenseStatusATK = defensePrevius  ;
        }
        else {
            armorStatusDEF = armorPrevius ;
            defenseStatusDEF = defensePrevius ;
        }

    }


    private void GetBonifInv(Player pATK, Player pDEF) {

        pATK.getListSpaceships().forEach(s -> s.setAttack(investigations.incrementInv(s.getAttack(),pDEF.getInvestAttack())));
        pATK.getListSpaceships().forEach(s -> s.setDefense(investigations.incrementInv(s.getDefense(),pDEF.getInvestDefense())));
        Collections.sort(pATK.getListSpaceships());

        pDEF.getListSpaceships().forEach(s -> s.setAttack(investigations.incrementInv(s.getAttack(),pDEF.getInvestAttack())));
        pDEF.getListSpaceships().forEach(s -> s.setDefense(investigations.incrementInv(s.getDefense(),pDEF.getInvestDefense())));
        Collections.sort(pDEF.getListSpaceships());
    }


}
