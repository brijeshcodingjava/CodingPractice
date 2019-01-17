package codefights.arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

	public List<List<Integer>> generate(int numRows) {
        
		if( numRows <= 0 ) return new ArrayList<List<Integer>>();
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		List<Integer> temp = null;
		List<Integer> last = null;
		
		for( int i =0; i < numRows; i++ )
		{
			temp = new ArrayList();
			temp.add( 1 );
			
			if( i == 0 )
			{
				result.add( temp );
				continue;
			}
			if( i == 1 )
			{
				temp.add( 1 );
				result.add( temp );
				continue;
			}
			
			last = result.get( i - 1 );
			
			for( int j = 0; j < last.size(); j++ )
			{
				if( (j+1) < last.size() )
				{
					temp.add( last.get( j ) + last.get( j+1 ) );
				}
			}
			
			temp.add( 1 );
			
			result.add( temp );
			
		}
		
		System.out.println( result );
		return result;
    }
	
	public static void main( String ...args )
	{
		PascalTriangle obj = new PascalTriangle();
		obj.generate( 5 );
	}
}
