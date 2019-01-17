package codefights.arrays;

/**
 *  
 */

public class DiagonalTraverse {

	public int[] findDiagonalOrder(int[][] matrix) {
		
	if( matrix == null ) return new int[0];
    if( matrix.length <=0 ) return new int[0];
    if( matrix.length == 1 && matrix[0].length == 1 ) return new int[]{ matrix[0][0] };
    if( matrix.length == 1 ) return matrix[0];
    
    int[] result = new int[ matrix.length * matrix[0].length];
	
	int row = 0;
	int col = 0;
	boolean up = true;
	boolean down = true;
	
	row = 0; col = 0; down = false; up = true;
	
	for( int i=0; i < result.length; i++ )
	{
		if( down )
		{
			result[i] = matrix[row][col];
			
			if( col == 0 )
			{
				down = false; up = true; 
				if( i != result.length -1 ) i++;
				
				if( row == (matrix.length -1) )
				{
					col++; 
				}
				else
				{
					row++; 
				}
			}
			else if( row == (matrix.length -1) )
			{
				down = false; up = true; i++;
				col++;
			}
			else
			{
				row++; col--;
			}
		}
		
		
		if( up )
		{
			try{
				result[i] = matrix[row][col];
			}
			catch( Exception e )
			{
				System.out.println( " Error : " + row + " " + col + " " + i );
			}
			
			if( row == 0 )
			{
				up=false; down=true; 
				
				if( col == (matrix[0].length -1) )
				{
					row++; 
				}
				else
				{
					col++;
				}
			}
			else if( col == (matrix[row].length -1) )
			{
				up=false; down=true;
				row++;
			}
			else
			{
				row--; col++;
			}
		}
	}
	
		
	
	print( result);
	return result;

    
}

 
	
	public static void main( String ...args )
	{
		DiagonalTraverse obj = new DiagonalTraverse();
		int[][] matrix = new int[][]{{3},{2},{4},{6}};
		int[][] matrix2 = new int[][]{
			{ 1,   2,   3,  4, 51 },
			{ 5,   6,   7,  8, 52 },
			{ 9,  10,  11, 12, 53 },
			{ 13, 14,  15, 16, 54 },
			{ 55, 56,  57, 58, 59 }
		};
		
		obj.findDiagonalOrder(matrix);
	}
	
	public void print( int array[]){
		for( int num: array ) System.out.print( num + " ");
	}
	
	public void print2( int a[][] )
	{
		for( int i = 0; i < a.length; i++ )
		{
			for( int j = 0; j < a[i].length; j++ )
			{
				System.out.print( a[i][j] );
			}
			System.out.println("--");
		}
	}
}
