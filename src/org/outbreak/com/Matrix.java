package org.outbreak.com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Matrix {
	

	  // Horizontal and vertical dimensions of the maze.
	 protected int horiz;
	 protected int vert;
	 protected boolean[][] hWalls;
	 protected boolean[][] vWalls;
	 
	 protected  static String pattern;
	 private  static Boolean  isTranspose = false;
	 private static  List<Integer> horizontal = new ArrayList<>();
	 private Room[][] tableRm;
	 
	
	
	//private Room[][] tableRm = Consts.MATRIX.noInfection;
	// private Room[][] tableRm = Consts.MATRIX.horizontalTrue;
	//private Room[][] tableRm = Consts.MATRIX.verticalTrue;

    public Matrix(int horizontalSize, int verticalSize, String in_pattern) {
    	

        this.horiz = tableRm.length;
        this.vert = tableRm[1].length;
        Matrix.pattern = in_pattern;
        //System.out.println("horiz : " + horiz + "vert :" + vert );
        if ((horiz < 1) || (vert < 1) || ((horiz == 1) && (vert == 1))) {
          return;  
        }// There are no interior walls
        }
        
     @SuppressWarnings("unused") Matrix(Room[][] tableRm,String in_pattern) {
		this.tableRm = tableRm;
		this.horiz = tableRm.length;
        this.vert = tableRm[1].length;
        Matrix.pattern = in_pattern;
	}

			/**
    	   * horizontalWall() determines whether the horizontal wall on the bottom
    	   * edge of cell (x, y) exists.  If the coordinates (x, y) do not correspond
    	   * to an interior wall, true is returned.
    	   */
    public boolean horizontalWall(int x, int y) {
    	    if ((x < 0) || (y < 0) || (x > horiz - 1) || (y > vert - 2)) {
    	      return true;
    	    }
    	    return hWalls[x][y];
    	  }
    	  
    	  /**
    	   * verticalWall() determines whether the vertical wall on the right edge of
    	   * cell (x, y) exists. If the coordinates (x, y) do not correspond to an
    	   * interior wall, true is returned.
    	   */
    public boolean verticalWall(int x, int y) {
    	    if ((x < 0) || (y < 0) || (x > horiz - 2) || (y > vert - 1)) {
    	      return true;
    	    }
    	    return vWalls[x][y];
    	  }
    	  
    	  
    
    
    protected void diagnose(Object matrix) {
    	if ((horiz < 1) || (vert < 1) || ((horiz == 1) && (vert == 1))) {
    	      return;                                    // There are no interior walls
    	    }	
    		
    	System.out.print("\n\n Table as following: \n \n") ;
    	
    	for(int j = 0; j < tableRm.length ; j++) {    //j is less than the # of ROWS (wat.length)
              for(int i = 0; i < tableRm[j].length; i++) {//i is less than the # of COLUMNS (wat[j].length)
                    //note that because this is an irregular array
                    //the number of columns changes depending on the row
                    System.out.print(tableRm[j][i].getPattern()); //print, unlike println, does not add a new line when run
                    System.out.print(" "); //adds a space between columns
              }
                System.out.println(" \n");  //adds a new line between rows
           }
    		isInfected(checkPattern(tableRm, isTranspose));	// check if 5 or more matches 
    		Room[][] transpose=new Room[vert][horiz];  //switch row and column
    	  
    		//Code to transpose a matrix  
    		for(int i=0;i<vert ;i++){    
    		for(int j=0;j<horiz;j++){    
    		transpose[i][j]=tableRm[j][i];  
    		}    
    		}  
    		
    		
    		isTranspose=true;
    		isInfected(checkPattern(transpose, isTranspose)); //check if 5 or more matches after  transpose    
              
    	
    	
    	
    	
    	}
       
    	    
    	    

    private static List<Integer> checkPattern(Room[][] tableRm, boolean isTranspose){
    	
    	int j;
    
     for (int i = 0; i < tableRm.length; i++)   //row
      {
    	 horizontal= new ArrayList<>(); 
    	 
    	
    	for ( j = 0; j < tableRm[i].length; j++)  //column
    	{
    		 
    		if(tableRm[i][j].getPattern()==pattern)
    		{	
    			
    			horizontal.add(j+1);
    			
    		}
    		
    	}
    	
		if(horizontal.size()>4)
    	{
				
			System.out.println("Floors and rooms as below is Infected \n");
			if(isTranspose)
			{
				i=i+1;
				
				System.out.println("Floors: ");
				horizontal.forEach(horizontal ->{
		            System.out.println(horizontal);
		        });
				System.out.println("Rooms: " + i);
			}
			else
			{	
				i=i+1;
				System.out.println("Floor: " + i);
				System.out.println("Rooms : ");
				horizontal.forEach(horizontal ->{
		            System.out.println(" " + horizontal);
		        });
				
			}	
		
    	}
		
    		
    }
     
	return horizontal;
   
    
	
    			
   }
    	  
   
    
	private static boolean isInfected (List<Integer> list)
    {
		
		int[] array = new int[list.size()];
	      for(int i=0;i<array.length;i++) {
	         array[i] = list.get(i);
	         System.out.println(array[i]);
	      }
		Arrays.sort(array);
		for (int i = 0; i < array.length - 1; i++) {
		  if (array[i] + 1 != array[i + 1]) {
		    return false;
		  }
		}
		
		return true;
	}
    }
   



	
    	  

           
            

    

    
  