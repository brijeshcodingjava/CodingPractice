package codefights.arrays;

public class AddBinaryArray {

	public int[] sum( int[] a, int b[] )
	{
		int c[] = null;
		
		if( b.length > a.length )
		{
			int temp[] = a;
			a = b;
			b = temp;
		}
		
		c = new int[ a.length + 1 ];
		
		boolean vadi = false;
		int bsize = b.length - 1;
		int csize = c.length - 1;
		
		for( int i = a.length -1; i >= 0; i-- )
		{
			if( bsize >= 0 )
			{
				if( a[i] + b[bsize] == 2 )
				{
					if( vadi )
					{
						vadi = true;
						c[csize] = 1;
						csize--; bsize--;
					}
					else
					{
						vadi = true;
						c[csize] = 0;
						csize--; bsize--;
					}
				}
				else if( a[i] + b[bsize] == 1 )
				{
					if( vadi )
					{
						c[csize] = 0;
						csize--; bsize--;
					}
					else
					{
						c[csize] = 1;
						csize--; bsize--;
					}
				}
				else
				{
					if( vadi )
					{
						c[csize] = 1;
						csize--; bsize--;
						vadi = false;
					}
					else
					{
						c[csize] = 0;
						csize--; bsize--;
					}
				}
				
			}
			else
			{
				if( vadi )
				{
					if( a[i] == 1 )
					{
						c[csize] = 0;
						csize--; 
					}
					else if( a[i] == 0 )
					{
						c[csize] = 1;
						csize--;
						vadi = false;
					}
				}
				else
				{
					c[csize] = a[i];
				}
				
			}
		}
		
		if( vadi ) c[0] = 1;
		
		for( int num : c ) System.out.print( num + " " );
		return c;
	}
	
	public static void main( String ...args )
	{
		AddBinaryArray obj = new AddBinaryArray();
		obj.sum( new int[] {  1, 1, 1}, new int[] {1, 1, 1, 1} );
		
	}
}
