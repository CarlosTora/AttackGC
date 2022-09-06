import model.entity.Player;
import service.StartService;
import service.impl.StartServiceImpl;

import java.util.List;

public class Main {


    private static StartServiceImpl startServiceImp = new StartServiceImpl();

    public static void main(String[]args) {

        List<Player> listPlayerStart = startServiceImp.CreatePlayersBattle();
        System.out.println("          --->  Start battle data  <---");
        listPlayerStart.forEach(s-> System.out.println(s.toString()));
        System.out.println();
        System.out.println();


        int count = 1;
        while (count < 6) {
            listPlayerStart = startServiceImp.CreatePlayersBattle();
            List<Player> resultBattle = startServiceImp.ResultBattle(listPlayerStart.get(0), listPlayerStart.get(1) );
            System.out.println("  --->  battle example: "+count);
            resultBattle.forEach(s-> System.out.println(s.toString()));
            count++;
            System.out.println();
        }

    }
}
