package codefights.arrays;

public class PlusOne {

	public int[] plusOne(int[] digits) {

		if( digits == null ) return digits;
		
		int lastElement = digits[ digits.length - 1 ];
		
		if( lastElement != 9 )
		{
			digits[ digits.length - 1 ] = ++lastElement;
		}
		else
		{
			int index = digits.length - 1;
			while( index != -1 && digits[index] == 9 )
			{
				digits[index] = 0;
				
				index = index -1;
			}
			
			if( index >= 0 ) digits[ index ] = digits[ index ] + 1;
			
			else if( index == -1 )
			{
				int[] temp = new int[ digits.length + 1 ];
				temp[0] = 1;
				digits = temp;
			}
		}
		
		print( digits );
		return digits;
    }
	
	public static void main( String ...args )
	{
		PlusOne obj = new PlusOne();
		obj.plusOne( new int[]{9,9,9,9} );
	}
	
	public void print( int array[] )
	{
		for( int num: array ) System.out.print( num + " " );
	}
}
