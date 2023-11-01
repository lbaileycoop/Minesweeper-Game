/** 
Lucas Bailey
CS110
7 December 2022
Final Project - This program will work in conjuction with Grid.java, Square.java, 
                MineSquare.java, NumberSquare.java, and Driver.java to prompt  
                a user for the desired output, then run the program based on the users input
*/ 
import java.util.ArrayList;
import java.util.Scanner;
public class Minesweeper
{
   // a method to run the program using user input
   public void runGame()
   {
      // creating Grid object 
      Grid g = new Grid(12, 10, 10);
      
      // initializing variables
      String choice;
      int status;
      int gameFlow = g.OK;
      
      // re-printing grid for user
      while (gameFlow == g.OK)
      {
         // printing grid to start
         System.out.println(g.toString());
      
         // asking users choice
         System.out.println("What's next?");
      
         // Prompting user for choice
         Scanner keyboard = new Scanner(System.in);
         System.out.println("Options: (U)ncover r c, (F)lag r c, (Q)uit");
         choice = keyboard.nextLine();
      
         // exception checking
         while (choice.charAt(0) != 'U' && choice.charAt(0) == 'u' && choice.charAt(0) == 'F' 
            && choice.charAt(0) == 'f' && choice.charAt(0) == 'Q' && choice.charAt(0) == 'q')
         {
            System.out.println("Please choose from the given options!");
         
            // asking users choice
            System.out.println("What's next?");
      
            // Prompting user for choice
            System.out.println("Options: (U)ncover r c, (F)lag r c, (Q)uit");
            choice = keyboard.nextLine();
         }
      
         // initializing string array
         String coordinates[];
      
         // uncovering the cooridnates given by the user
         if (choice.charAt(0) == 'U' || choice.charAt(0) == 'u')
         {
                   
            // splitting string srray
            coordinates = choice.split("\\s+");
            int row = Integer.parseInt(coordinates[1]);
            int column  = Integer.parseInt(coordinates[2]);
            
            try
            {
               // uncovering the sqaure
               status = g.uncoverSquare(row, column); 
   
               // if user wins 
               if (status == g.WIN) 
               {
                  gameFlow = g.WIN;
                  System.out.println("Congradulations! You have found all the mines");         
                  
               }
               
               // if user loses
               if (status == g.MINE)
               {
                  gameFlow = g.MINE; 
                  g.exposeMines();
                  System.out.println(g);
                  System.out.println("Better luck next time!");         
               }
            }
            
            catch (Exception e)
            {
               System.out.println("Cannot uncover a flagged square");
            }
              
         }
         
         // flagging the cooridnates given by the user        
         else if (choice.charAt(0) == 'F' || choice.charAt(0) == 'f')
         {
            // splitting string srray
            coordinates = choice.split("\\s+");
            int row = Integer.parseInt(coordinates[1]);
            int column = Integer.parseInt(coordinates[2]);
            
            // flagging the sqaure
            g.flagSquare(row, column); 
              
         }
         
         // quitting program
         else
         {
            // displaying all mines
            gameFlow = g.MINE;
            System.out.println("You have chosen to quit the game. Goodbye now!");
         }
         
     } 
     
   }
   
}