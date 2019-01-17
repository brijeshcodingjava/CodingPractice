package codefights.arrays;

/**
 * Easy
 * Initially first element store as max and prevMax as 0
 * Swap the max with next element if any
 * or Swap the prevMax with next element if any
 * 
 * After loop check max/2 >= prevMax
 * 
 **/

public class LargestIntTwice {

	public int dominantIndex(int[] nums) {
        
        if( nums == null ) return -1;
        if( nums.length == 1 ) return 0;
        
        int max = nums[0];
        int maxIndex = 0;
        
        int prevMax = 0;
        int prevMaxIndex = 0;
        
        for( int i=1; i < nums.length; i++ )
        {
            if( nums[i] >= max )
            {
                prevMax = max;
                
                max = nums[i];
                maxIndex = i;
            }
            else if( nums.length == 2 ) return 0;
            else if( nums[i] >= prevMax ) prevMax = nums[i];
            
        }
        
        //System.out.println( "Max : " + max + " Max Index : " + maxIndex + " , Min : " + prevMax );
        
        if( Math.round( max/2 ) >= prevMax ) return maxIndex;
        else return -1;
    }
	
	public static void main( String ...args)
	{
		LargestIntTwice obj = new LargestIntTwice();
		
		System.out.println( obj.dominantIndex( new int[]{1,2,3,4} ));
		
		
	}
}
