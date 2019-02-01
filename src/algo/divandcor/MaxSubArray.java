package algo.divandcor;

/* 
 * Maximum Sub Array Problem.
 * 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7
 * 
 * Trying to find the sequence of elements where we have maximum sum.
 * 
 * Consider example of stock price change on each day and you want to get maximum profit so 
 * we need to find trading days where there is -ve change means price dropped significantly and then raised high on preceding days.
 * 
 * First divide array in such a way that we end up with just one element which itself will be returned.
 * In divide step, we will do left division from 0 to middle and right division from middle+1 to length.
 * As we need to do sum of sequence we have to do cross divison as well taking highest sum from left and highest sum from right
 * and returning the total sum with start and end index.
 * 
 */

public class MaxSubArray {

	public int[] perform( int[] array )
	{
		int [] result = findMaxSubArray( array, 0, array.length -1);
		
		System.out.println( "Starting Index : " + result[0] );
		System.out.println( "Ending Index : " + result[1] );
		System.out.println( "Sum : " + result[2] );
		
		return result;
	}
	
	// Performing Divide operation using recursion 
	public int[] findMaxSubArray( int[] array, int low, int high )
	{
		int[] result = new int[3];
		
		if( low == high )
		{
			result[0] = low;
			result[1] = high;
			result[2] = array[low];
			
			return result;
		}
		else
		{
			int middle = (low+high) / 2;
			int leftLow = 0, leftHigh = 0, leftSum = 0;
			int rightLow = 0, rightHigh = 0, rightSum = 0;
			int crossLow = 0, crossHigh = 0, crossSum = 0;
			
			int[] leftResult = findMaxSubArray( array, low, middle );        // Recursive call for division from left side.
			int[] rightResult = findMaxSubArray( array, middle+1, high );    // Recursive call for division from right side.
			
			int[] crossResult = findMaxCrossingSubArray( array, low, middle, high ); // Conqure call to do sum of sequence
			
			
			leftLow = leftResult[0] ; leftHigh = leftResult[1] ; leftSum = leftResult[2];
			
			rightLow = rightResult[0] ; rightHigh = rightResult[1] ; rightSum = rightResult[2];
			
			crossLow = crossResult[0] ; crossHigh = crossResult[1] ; crossSum = crossResult[2];
			
			if( leftSum >= rightSum && leftSum >= crossSum )
			{
				result[0] = leftLow;
				result[1] = leftHigh;
				result[2] = leftSum;
			}
			else if( rightSum >= leftSum && rightSum >= crossSum )
			{
				result[0] = rightLow;
				result[1] = rightHigh;
				result[2] = rightSum;
			}
			else {
				result[0] = crossLow;
				result[1] = crossHigh;
				result[2] = crossSum;
			}
		}
		
		return result;
	}
	
	// Perform Conquer operation doing sum of left side and right side
	
	public int[] findMaxCrossingSubArray( int[] array, int low, int mid, int high )
	{
		int[] result = new int[3];
		
		int leftSum = -999999;
		int rightSum = -999999;
		
		int sum = 0;
		int leftIndex = 0;

		for( int i = mid; i >= 0; i-- )
		{
			sum = sum + array[i];
			if( sum > leftSum )
			{
				leftSum = sum;
				leftIndex = i;
			}
		}
		
		sum = 0;
		int rightIndex = 0;
		
		for( int i = mid +1; i <= high; i++ )
		{
			sum = sum + array[i];
			if( sum > rightSum )
			{
				rightSum = sum;
				rightIndex = i;
			}
		}
		
		result[0] = leftIndex;
		result[1] = rightIndex;
		result[2] = leftSum + rightSum;
		
		return result;
	}
	
	public static void main( String ...args )
	{
		MaxSubArray obj = new MaxSubArray();
		//obj.perform( new int[]{13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 } );
		//obj.perform( new int[]{-13, -3, 25, -29, -3, 16, -2, -18, 2, 2, -7, 12, -5, -22, 150, -4, 7 } );
		obj.perform( new int[]{ -3, -29, -3, -2, -18, -7, -5, -22, -4 } );
	}
}
