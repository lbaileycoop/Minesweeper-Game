/** 
Lucas Bailey
CS110
7 December 2022
Final Project - This program will work in conjuction with Grid.java, Square.java, 
                MineSquare.java, Minesweeper.java, and Driver.java to uncover 
                squares and neighboring squares in the grid and set those squares 
                and neighboring squares to empty squares.       
*/ 
public class NumberSquare extends Square
{
   // instance vairiables
   public int neighborMines;
   public int myRow;
   public int myCol;
   
   /** main constructor takes in three integer values representing
       neighborMines, myRow, and myCol
  
       @param neighborMines to neighborMines
       @param myRow to myRow
       @param myCol to myCol
   */
   public NumberSquare(int neighborMines, int myRow, int myCol)
   {
   
      this.neighborMines = neighborMines;
      this.myRow = myRow;
      this.myCol = myCol;
   }
   
   // method to reveal neighboring mines to empty
   public void uncover()
   {
      // checking to see if square is already flagged
      if (!isFlagged())
      {
         setUncovered();
         
         // if neighborMines is 0 set element to _
         if (neighborMines == 0)
            setElement("_");
         
         // otherwise neighborMines is empty    
         else 
            setElement("" + neighborMines); 
      }
      
   } 
   
   // getter for neighborMines
   /** getNeighborMines -- get int value of neighborMines
   
       @return int value of neighborMines
   */ 
   public int getNeighborMines()
   {
      return neighborMines;
   }
   
   /** detecting when mine is found
  
       @return boolean value when mine is found
   */
   public boolean isMine()
   {
      return false;
   }
    
}