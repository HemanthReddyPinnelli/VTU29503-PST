import java.util.*;

// Player class is given in the problem
class Player{
    String name;
    int score;

    Player(String name, int score){
        this.name = name;
        this.score = score;
    }
}

// Implement Comparator interface
class Checker implements Comparator<Player> {

    public int compare(Player a, Player b) {
        // 1. Sort by score descending
        if (a.score!= b.score) {
            return b.score - a.score; // higher score first
        }
        // 2. If score equal, sort by name ascending
        return a.name.compareTo(b.name);
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();

        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        // Sort using our custom comparator
        Arrays.sort(player, checker);

        // Print sorted players
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}
