package codefights.arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraverse {

	public List<Integer> spiralOrder(int[][] matrix) {
    
		if( matrix == null ) return new ArrayList<>();
        if( matrix.length == 0 ) return new ArrayList<>();
        if( matrix[0].length == 0 ) return new ArrayList<>();
		if( matrix[0] == null ) return new ArrayList<>();
		if( matrix.length == 1 && matrix[0].length == 1 ) { 
            List<Integer> temp = new ArrayList(); temp.add( matrix[0][0]); return temp; 
        }
		
		List<Integer> result = new ArrayList();
		int matrixLength = matrix.length * matrix[0].length;
		
		System.out.println( "Max Length : " + matrixLength );
		
		if( matrix[0].length == 1 )
		{
			for( int i = 0; i < matrix.length; i++ )
			{
				result.add( matrix[i][0] );
			}
			System.out.println( result );
			return result;
		}
		else if( matrix.length == 1 )
		{
			for( int i = 0; i < matrix[0].length; i++ )
			{
				result.add( matrix[0][i] );
			}
			System.out.println( result );
			return result;
		}
		
		int row = 0, col = 0;
		int rowStart = 1, colStart = 0;
		int rowEnd = matrix.length-1;
		int colEnd = matrix[0].length-1;
		boolean right = true, left = false, up = false, down = false;
		
		System.out.println( rowEnd + " " + colEnd );
		//if( matrix[0].length == 1 ) right = false; down = true;
		
		
		for( int i = 0; i < matrixLength; i++ )
		{
			
			if( right )
			{
				result.add( matrix[row][col] );
				
				if( col == colEnd )
				{
					row++; colEnd--;  i++;  
					right = false; down = true; 
				}
				else 
				{
					col++; //if( col == matrix[row].length ) col--;
				}
			}
			
			if( down )
			{
				System.out.println( row + " , " + col );
				result.add( matrix[row][col] );
				
				if( row == rowEnd )
				{
					rowEnd--; col--; i++;
					down = false; left = true;
				}
				else
				{
					row++;
				}
			}
			
			if( left )
			{
				result.add( matrix[row][col] );
				
				if( col == colStart )
				{
					colStart++; row--; i++;
					left = false;  up = true;
				}
				else
				{
					col--; if( col < colStart ) col--;
				}
			}
			
			if( up )
			{
				result.add( matrix[row][col] );
				
				if( row == rowStart )
				{
					rowStart++; col++;
					up = false; right = true;
				}
				else
				{
					row--;
				}
			}
		}
		
		//result.remove( matrixLength );
		int diff = result.size() - matrixLength;
		
		for( int i =0; i < diff; i++ )
		{
			result.remove( result.size() - 1 );
		}
		
		System.out.println( result );
		return result;
    }
	
	public static void main( String ...args )
	{
		SpiralTraverse obj = new SpiralTraverse();
		int[][] matrix3 = new int[][]{{3},{2},{4},{6}};
		int [][] matrix4 = new int[][] { {1,2,3,4} };
		
		int[][] matrix5 = new int[][] {
			
			{1,2, 3, 4},
			{5,6, 7, 8},
			{9,10,11,12}
		};
		
		int [][] matrix = new int[][]{
			{1,2,3},
			{4,5,6},
			{7,8,9}
		};
		
		int[][] matrix2 = new int[][]{
			{ 1,   2,   3,  4, 51 },
			{ 5,   6,   7,  8, 52 },
			{ 9,  10,  11, 12, 53 },
			{ 13, 14,  15, 16, 54 },
			{ 55, 56,  57, 58, 59 }
		};
		
		obj.spiralOrder(matrix);
	}
}
