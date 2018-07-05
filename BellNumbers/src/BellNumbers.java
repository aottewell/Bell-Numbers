/**
 * 
 * @author Alexander Ottewell
 *
 *Purpose: Write a program to determine the number of partitions of a set with size "n".
 *         This can be achieved by using the Bell's Numbers Triangular calculation method.
 *         
 *Description: In the Bell Triangle, the last column of the i'th row in the triangle
 *		       is the number of partitions of the set size i. The triangle is constructed
 *		       in the following manner: For each row, the number of columns equals to the 
 *             number of the row (5th row had 5 columns, 6th row has 7 columns and etc.).
 *             The first row has 1 column and the entry is "1". Every new row begins 
 *             with the last entry of the previous row. The second element of the new row 
 *             is the sum of the previous element in the row with the element right above it.
 *             For example, here are the first 4 rows of the Bell Triangle:
 *             
 *             row 1: 1
 *             row 2: 1 2
 *             row 3: 2 3 5
 *             row 4: 5 7 10 15
 *           
 *Algorithm:   The user will be prompted for the size of the set in order to calculate
 *             the number of partitions. The program will output the number of partitions
 *             and the Bell Triangle to the screen.
 *             Some future additions to the program: 1.Outputting the result to a file.
 *             										 2.Showing the actual partitions
 *             										 3.Accepting a custom set to partition
 *             										 4....
 *             
 *             The size of the set will be used as a target size for the triangle.
 *             The last entry of the target row (last row of triangle) is the number of partitions
 *             in the user's set. The "root" of the triangle is '1.'
 *             
 *             Trial Plan: 
 *             1.Use a 2D array for the data structure.
 *             2.Set root to 1 and assign to array at [0][0] index.
 *             3.Define a static method to accept the targetRow
 *             4.This method will generate the desired Bell Triangle 
 *             	 by populating the 2D array until the target. 
 *           
 */

import java.util.Scanner;

public class BellNumbers
{
	public static void main(String[] args)
	{
		//declaration
		int[][] array; 
		int setSize = 0;
		Scanner keyboard = new Scanner(System.in);
		
		//input 
		System.out.print("Enter the number of elements in the set: ");
		setSize = keyboard.nextInt();
		
		keyboard.close();
		
		//assign constructed triangle with target size to array variable
		array = bellTriangle(setSize);
		//print triangle to screen 
		printTriangle(array);
		
	}//end of main
	
	/*******************************************
	 * 
	 * @param target
	 * @return
	 */
	public static int[][] bellTriangle(int target)
	{
		//make array
		int[][] triangleArray = new int[target][target];
		
		//root
		triangleArray[0][0] = 1;
		
		//populate Bell Triangle
		for(int row = 1; row < target; row++)
		{
			for(int col = 0; col <= row; col++)
			{
				//conditions
				if(col == 0) //1st element of a new row is the last element of the previous row
				{
					triangleArray[row][col] = triangleArray[row-1][row-1];
				}
				else //next element in the row is a sum of its previous and one above the previous in the row
				{
					triangleArray[row][col] = ( triangleArray[row][col-1] + triangleArray[row-1][col-1] );
				}
			}
		}
		
		return triangleArray;
	}//end of bellTriangle()
	
	/*******************************************
	 * 
	 * @param triangle
	 */
	public static void printTriangle(int[][] triangle)
	{
		//print Bell Triangle
		for(int row = 0; row < triangle.length; row=row+1)
		{
			for(int col = 0; col <= row; col=col+1)
			{
				System.out.print(triangle[row][col] + " ");
			}
			System.out.println();
		}
		
		System.out.println("Number of partitions: " + triangle[triangle.length-1][triangle.length-1]);
		
	}//end of printTriangle
	
}//end of class

