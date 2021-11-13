import org.w3c.dom.ranges.Range;

import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.IntStream;


public class Main {
    // Create a Hashmap for board
    HashMap<Integer,String> Numbers = new HashMap<Integer, String>();
    public Main() {
        
        // Insert all the numbers with their values
        Numbers.put(1, "1");
        Numbers.put(2, "2");
        Numbers.put(3, "3");
        Numbers.put(4, "4");
        Numbers.put(5, "5");
        Numbers.put(6, "6");
        Numbers.put(7, "7");
        Numbers.put(8, "8");
        Numbers.put(9, "9");
    }

    public static void main(String[] args) {
        // Initialize Board
        Main game = new Main();
        String player = "";


        while(!(game.winner())) {
            game.myBoard();
            player = game.playerTurn(player);
            game.makeMove(player);
        }

        System.out.println("----------------");
        System.out.println(player + " won the game!!");
        game.myBoard();

    }

    // Print out board with dictionary values
    public void myBoard() {
        System.out.println(Numbers.get(1) + " | " + Numbers.get(2) + " | " + Numbers.get(3));
        System.out.println("- + - + -");
        System.out.println(Numbers.get(4) + " | " + Numbers.get(5) + " | " + Numbers.get(6));
        System.out.println("- + - + -");
        System.out.println(Numbers.get(7) + " | " + Numbers.get(8) + " | " + Numbers.get(9));

    }

    public String playerTurn(String player) {
        if (player == "" | player == "O") {
            player = "X";
        }
        else if (player == "X" ) {
            player =  "O";
        };
        return player;
    }
    public void makeMove(String player) {
        boolean works = false;

        // if the square is taken, then you can't use it.
        while(!works) {
            Scanner myObj = new Scanner(System.in);
            System.out.println("\n" + player + "'s turn to choose available square(1-9)");

            Integer move = myObj.nextInt();

            if (!(Numbers.get(move) == "X" | Numbers.get(move) == "O")) {
                Numbers.replace(move, player);
                works = true;
            } else {
                System.out.print("That square is already taken");
                works = false;
            }
        }
    }

    public boolean winner() {
        boolean gameOver = false;
// Test to see if there is a winner

        if (Numbers.get(1) == Numbers.get(2) && Numbers.get(2) == Numbers.get(3) ||
                Numbers.get(4) == Numbers.get(5) && Numbers.get(5) == Numbers.get(6) ||
                Numbers.get(7) == Numbers.get(8) && Numbers.get(8) == Numbers.get(9) ||
                Numbers.get(1) == Numbers.get(4) && Numbers.get(4) == Numbers.get(7) ||
                Numbers.get(2) == Numbers.get(5) && Numbers.get(5) == Numbers.get(8) ||
                Numbers.get(3) == Numbers.get(6) && Numbers.get(6) == Numbers.get(9) ||
                Numbers.get(1) == Numbers.get(5) && Numbers.get(5) == Numbers.get(9) ||
                Numbers.get(3) == Numbers.get(5) && Numbers.get(5) == Numbers.get(7)) {
            gameOver = true;
        }

        return gameOver;
    }

    public boolean draw() {
       boolean isDraw = false;

       for(Integer i = 0;i < 10; i++) {
            if (!(Numbers.get(i) != "X" | Numbers.get(i) != "O")) {
                isDraw = false;
            }
            else {
                isDraw = true;
            }
       }
       return isDraw;

    }


}
