/** 
Lucas Bailey
CS110
7 December 2022
Final Project - This program will work in conjuction with Grid.java, MineSquare,java,
                NumberSquare.java, Minesweeper.java, and Driver.java to create an String 
                element that allows for the alterations to a square, which is requested 
                in Grid.java to function.
*/ 
public abstract class Square
{

   // instance variables
   private String element;
   private boolean flagged;
   private boolean uncovered;
   
   // empty constructor setting element, uncovered, and falgged to default values
   public Square()
   {
      element = "x";  
      uncovered = flagged = false;        
   }
   
   /** constructor takes one String representing element, 
       and two boolean representing flagged and uncovered
       
       @param element to element
       @param flagged to flagged
       @param uncovered to uncovered
   */
   public Square(String element, boolean flagged, boolean uncovered)
   {
   
      this.element = element;
      this.flagged = flagged;
      this.uncovered = uncovered;
   }
   
   /** isFlagged to represent if spot is flagged
   
       @return boolean value true for flagged
   */
   public boolean isFlagged()
   {
      return flagged;
   }
   
   /** isUncovered to represent if spot is flagged
   
       @return boolean value true for uncovered
   */
   public boolean isUncovered()
   {
      return uncovered;
   }
   
   // method that checks of a square is already flagged. if not, that square is flagged
   public void flagSquare()
   {
      if (flagged)
      {
         setElement("x");
      }
      else
      {
         setElement("f");
      }
      
      flagged = !flagged;
   }
   
   // getters and setters for each instance variable
   /** getElement -- get String value of element
   
       @return String value of element
   */ 
   public String getElement()
   {
      return element;
   }
   
   /** getFlagged -- get boolea value of flagged
   
       @return boolean value of flagged
   */ 
   public boolean getFlagged()
   {
      return flagged;
   }
   
   /** getUncovered -- get boolean value of uncovered
   
       @return boolean value of uncovered
   */ 
   public boolean getUncovered()
   {
      return uncovered;
   }
   
   /** set element to new element
   
      @param newElement to element 
   */
   public void setElement(String newElement)
   {
      element = newElement;
   }
   
   /** set flagged to new flagged
   
      @param newFlagged to flagged 
   */
   public void setFlagged(boolean newFlagged)
   {
      flagged = newFlagged;
   }
   
   /** set uncovered to new uncovered
   
      @param newUncovered to uncovered 
   */
   public void setUncovered()
   {
      uncovered = true;
   }
   
   /** formatting output in correct way
  
      @return a formatted string
   */
   @Override
   public String toString()
   {
      return String.format("\t%s", element);
   }
   
   // abstract method 
   public abstract void uncover();

   // abstract method 
   public abstract boolean isMine();

}  