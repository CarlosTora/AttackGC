package service;

import model.entity.Player;

import java.util.List;

public interface StartService {

    List<Player> CreatePlayersBattle ();

    List<Player> ResultBattle(Player playerAT, Player playerDF);
}
