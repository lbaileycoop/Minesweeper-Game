/** 
Lucas Bailey
CS110
7 December 2022
Final Project - This program will work in conjuction with Square.java, 
                MineSquare.java, NumberSquare.java, Minesweeper.java, and Driver.java to 
                create a grid. the specifications of this program will create a grid and 
                randomly place bombs in the grid, get the neighboring squares in the grid 
                and decide if they are mines, uncover each square that is not a mine, 
                expose all mines on the grid, and flag desired squares.
*/ 
import java.util.Random;
public class Grid
{
   // instance variables
   private Square grid[][];
   private int width = 12;
   private int height = 10;
   private int numMines = 10;
   private int numSquaresUncovered = 0;
   Random r = new Random(1);
   
   // class constants
   public static final int OK = 1;
   public static final int WIN = 2;
   public static final int MINE = 3;
   
   /** main constructor takes three int representing width, height, and numMines
       
       @param width to width
       @param height to height
       @param numMines to numMines
   */
   public Grid(int width, int height, int numMines)
   {
     
      this.width = width;
      this.height= height;
      this.numMines = numMines; 
      this.grid = new Square[height][width];     
    
      // randomly placing bombs throughout grid
      for (int m = 0; m < 10; m++)
      {
      
         int row2 = r.nextInt(height);
         int col = r.nextInt(width);
         if (grid[row2][col] == null)
         {
            grid[row2][col] = new MineSquare();
         }
         
      } 
      
      // creating grid of elements by using an array of arrays  
      for (int h = 0; h < width; h++)
      {        
         for (int w = 0; w < height; w++)
         {
           if (grid[w][h] == null)
           {
              grid[w][h] = new NumberSquare(getNeighbors(w, h), w, h);
           }
         }
         
      }     

   }
   
   /** checks the neighboring squares to see if they are mines
       
       @param rIndex the row of the square
       @param cIndex the column of the square
       @return integer value of neighbor mines
   */
   public int getNeighbors(int rIndex, int cIndex)
   {
      // initializing count variable
      int ct = 0;
      
      // getting neighbor mines
      for (int r = rIndex-1; r <= rIndex+1; r++)
      {
         for (int c = cIndex-1; c <= cIndex+1; c++)
         {
            if (r >= 0 && r < height && c >= 0 && c < width)
            {
               if (grid[r][c] == null)
               {
                  ;
               }
               else
               {
                  if (grid[r][c].isMine())
                  {
                     ct++;
                  }
               }
              
            }
         }                 
      }
      
      // returning the number of neighboring mines
      return ct;
   }
   
   /** Checks to see is surrounding squares isMine, if not, uncovers the rest of the surrounding squares
       
       @param rIndex is the row index 
       @param cIndex is the column index
       @return int value if user has uncovered all mines or not
   */
   public int uncoverSquare(int rIndex, int cIndex) throws Exception
   {
      // checking to see if grid at row rIndex column cIndex isMine
      if (grid[rIndex][cIndex].isMine())
      {
         return MINE;
      }
      else if (grid[rIndex][cIndex].isFlagged())
      {
         //System.out.println("can't uncover a flagged square");
         throw (new Exception());
      }
      // if not mine
      else
      {
         // creating NumberSquare object at row rIndex column cIndex
         NumberSquare temp = (NumberSquare)grid[rIndex][cIndex];
         
         // expose 5x5 neighborhood. Do not expose mines. Do not go off the end of the grid
         if (temp.getNeighborMines() == 0)
         {
            for (int r = rIndex-2; r <= rIndex+2; r++)
            {
               for (int c = cIndex-2; c <= cIndex+2; c++)
               {
                  if (r >= 0 && r < height && c >= 0 && c < width)
                  {
                     if (!grid[r][c].isMine() && !grid[r][c].isUncovered())
                     {
                        grid[r][c].uncover();
                        
                        // incrimenting integer vairable numSquaresUncovered
                        numSquaresUncovered++;  
                     }
                  }
               }
            }          
         }
         
         // expose 3x3 neighborhood. Do not expose mines. Do not go off the end of the grid
         else if (temp.getNeighborMines() == 1)
         {
            for (int r = rIndex-1; r <= rIndex+1; r++)
            {
               for (int c = cIndex-1; c <= cIndex+1; c++)
               {
                  if (r >= 0 && r < height && c >= 0 && c < width)
                  {
                     if (!grid[r][c].isMine() && !grid[r][c].isUncovered())
                     {
                        grid[r][c].uncover();
                                                
                        // incrimenting integer vairable numSquaresUncovered
                        numSquaresUncovered++;
                     }
                  }
               }
            }          
         }
         
         // expose on square at r,c
         else
         {
            if (!grid[rIndex][cIndex].isMine() && !grid[rIndex][cIndex].isUncovered())
            {
               grid[rIndex][cIndex].uncover();      
                        
               // incrimenting integer vairable numSquaresUncovered
               numSquaresUncovered++;  
            }
         }                  
      }

      // checking to see if user has won or not
      if ((height * width) - numSquaresUncovered == numMines) 
      {
         return WIN;
      }

      return OK;   
   }
   
   // exposing all mines on the grid
   public void exposeMines()
   {
      // looping through the grid and exposing all mines
      for (int r = 0; r < height; r++)
      {
         for (int c = 0; c < width; c++)
         {
            if (grid[r][c].isMine())
            {
               grid[r][c].uncover();
            }
         } 
      }       
   }
   
   /** flagging a square
       
       @param r is the row
       @param c is the column
   */
    public void flagSquare(int r, int c)
    {
      // flagging a square at row r column c
      grid[r][c].flagSquare();      

    }
   
   /** formatting output in correct way
  
      @return a formatted string
   */
   public String toString()
   {
      
      // creating String to add to
      String s;
      s = "";
      s += ("\t");
      
      // creating top of grid numbers
      for (int t = 0; t < width; t++)
      {
         s += (t + "\t");
      }
      
      s += ("\n");
      
      // creating side numbers of grid
      for (int row = 0; row < height; row++)
      {
         s += (row);
         
         // creating the grid of elements
         for (int col = 0; col < width; col++)
         {
            s += grid[row][col].toString();
         }
         
         s += ("\n");
      }
      
      return s;
   }
   
}