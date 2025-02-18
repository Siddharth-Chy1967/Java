import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
    Random rndm = new Random();
    Scanner scnr = new Scanner(System.in);
    System.out.println("Welcome to Sid's rock paper scissors game, java edition: ");
    String[] options = {"rock", "paper", "scissors"};
    
    int userScore = 0;
    int computerScore = 0;

    while(true){
        System.out.println("Enter rock, paper or scissors (or q to quit): ");
        String userIn =  scnr.next().toLowerCase();
        if(userIn.equals("q")){
            break;
        }
        int randNum = rndm.nextInt(3);

        String computerMove = options[randNum];

        if(userIn.equals(computerMove)){
            System.out.println("It's a draw!");
        }

        if(userIn.equals("rock") && computerMove.equals("scissors") || 
        userIn.equals("paper") && computerMove.equals("rock") ||
        userIn.equals("scissors") && computerMove.equals("paper")){
            System.out.println("You won! Computer chose: " + computerMove);
            userScore += 1;
        }
        else{
            System.out.println("You lost! Computer chose: " + computerMove);
            computerScore += 1;
        }
        
    }

    System.out.println("Your Score: " + userScore);
    System.out.println("Computer Score: " + computerScore);
    }

    
}