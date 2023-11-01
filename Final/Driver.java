/** 
Lucas Bailey
CS110
7 December 2022
Final Project - This program will work in conjuction with Grid.java, Square.java, 
                MineSquare.java, NumberSquare.java, and Minesweeper.java to run the game Mine Sweeper
*/ 
import java.util.Scanner;
public class Driver
{
   public static void main(String [] args)
   {
      // initializing variables
      boolean repeat = true;
      String choice;
      
      // creating Minesweeper object
      Minesweeper play = new Minesweeper();
      
      // creating scanner to retrieve users information
      Scanner keyboard = new Scanner(System.in);
      
      // repeating the game if selected
      while (repeat)
      {
         play.runGame();
         
         // Prompting user for choice
         System.out.println("Do you want to play again (y/n)?");
         choice = keyboard.nextLine();
         
         // exception checking
         while (!choice.equals("n") && !choice.equals("y"))
         {
            
            System.out.println("Invalid choice! Please choose either y or n");
           
            // Prompting user for choice
            System.out.println("Do you want to play again (y/n)?");
            choice = keyboard.nextLine();
         }
         
         // if choice is n, end the game
         if (choice.equals("n"))
         {
            repeat = false;
         }
      
      }
   }
   
}