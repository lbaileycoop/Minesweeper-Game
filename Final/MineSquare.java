/** 
Lucas Bailey
CS110
7 December 2022
Final Project - This program will work in conjuction with Grid.java, Square.java,
                NumberSquare.java, Minesweeper.java, and Driver.java to evaluate 
                whether a square is uncovered and reveals a mine, or to decide 
                whether there a mine in the grid.
*/ 
public class MineSquare extends Square
{
   // method to reveal neighboring mines
   public void uncover()
   { 
      // if not already flagged, uncover
      if (!isFlagged())
      {
         setElement("*");
      }
   }  
   
   /** detecting when mine is found
  
       @return boolean value when mine is found
   */
   public boolean isMine()
   {
      return true;
   }
   
}