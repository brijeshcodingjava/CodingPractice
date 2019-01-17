
public class TestClass {

	public int[] sort( int[] array, int start, int end )
	{
		int middle = 0;
		
		if( start < end )
		{
			middle = (start+end) / 2; //i.e 3
			
			sort( array, start, middle);
			sort( array, middle+1, end );
			
			merge( array, start, middle, end );
		}
		
		return array;
	}
	
	public int[] merge( int array[], int start, int middle, int end )
	{
		int len1 = middle-start+1;
		int len2 = end - middle;
		
		if( end == 1) len1=len2=1;
		
		int index = 0;
		int left[] = new int[len1];
		int right[] = new int[len2];
		
		for( int i = start; i <= middle; i++ )
		{
			left[index] = array[i];
			index++;
		}
		
		index = 0;
		
		for( int i = middle+1; i <= end; i++ )
		{
			right[index] = array[i];
			index++;
		}
		
		int i = 0;
		int j = 0;
		
		System.out.println("\n");
		System.out.println("LEFT>>");
		for( int num : left ) System.out.print( num + " " );
		System.out.println("\n");
		System.out.println("RIGHT>>");
		
		for( int num : right ) System.out.print( num + " " );
		
		for( int k = 0; k <= end; k++ )
		{
			if( i == left.length )
			{
				array[k] = right[j];
			}
			else if( j == right.length )
			{
				array[k] = left[i];
			}
			else if( left[i] <= right[j])
			{
				array[k] = left[i];
				i++;
			}
			else
			{
				array[k] = right[j];
				j++;
			}
		}
		
		return array;
	}
	
	public int[] doMergeSort( int[] array )
	{
		sort( array, 0, array.length-1 );
		
		for( int num : array ) System.out.print( num + " ");
		
		return array;
	}
	
	public static void main( String ...args )
	{
		TestClass obj = new TestClass();
		obj.doMergeSort( new int[] {5, 7, 2, 9, 1, 3, 8, 4} );
	}
}
