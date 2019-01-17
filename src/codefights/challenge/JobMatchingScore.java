package codefights.challenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JobMatchingScore {

	
	int jobMatchingScore(String[] locations, String criteria) {

		if( locations == null ) return 0;
		if( criteria == null || criteria.trim().equals("") ) return 0;
		if( locations.length >= 10000 || locations.length <= 0 ) return 0;
		
		Map<String, Map<String, Set<String>>> countries = new HashMap<>();
		
		for( String location: locations )
		{
			String[] strArray = location.split( "," );
			
			Set<String> tempList = new HashSet();
			tempList.add( strArray[0].trim() );
			
			Map<String, Set<String>> temp = new HashMap<>();
			temp.put( strArray[1].trim(), tempList );
			
			if( !countries.containsKey( strArray[2].trim() ) ) 
			{
				countries.put( strArray[2].trim(), temp );
			}
			else
			{
				Map<String, Set<String>> existingStates =  countries.get( strArray[2].trim() );
				
				if( !existingStates.containsKey( strArray[1].trim() ) )
				{
					existingStates.put( strArray[1].trim() , tempList );
				}
				else
				{
					existingStates.get( strArray[1].trim() ).add( strArray[0].trim() );
				}
			}
			
		}
		
		String input[] = criteria.split( "," );
		
		System.out.println( countries );
		System.out.println( "Input == " + input[0] );
		
		if( input.length == 3 )
		{
			if( countries.containsKey( input[2].trim() ) )
			{
				if( countries.get( input[2].trim() ).containsKey( input[1].trim() ) )
				{
					if( countries.get( input[2].trim() ).get( input[1].trim() ).contains( input[0].trim() ) ) return 1;
					else return 0;
				}
				else return 0;
			}
			else
			{
				return 0;
			}
		}
		
		else if( input.length == 2 )
		{
			if( countries.containsKey( input[1].trim() ) )
			{
				if( countries.get( input[1].trim() ).containsKey( input[0].trim() ) )
				{
					return countries.get( input[1].trim() ).get( input[0].trim() ).size();
				}
				else return 0;
			}
			else
			{
				return 0;
			}
		}
		
		else if ( input.length == 1)
		{
			if( countries.containsKey( input[0].trim()  ) )
			{
				int count = 0;
				Map<String, Set<String>> tempmap = countries.get( input[0].trim() );
				
				Set<String> keys = tempmap.keySet();
				
				for( String key : keys )
				{
					count = count + tempmap.get(key).size();
				}
				
				return count;
			}
			else return 0;
		}
		
		return 0;
	}
	
	public static void main( String ...args)
	{
		JobMatchingScore obj = new JobMatchingScore();
		
		String[] locations = {"San Francisco, California, United States",
		                      "San Mateo, California, United States",
		                      "Columbia, South Carolina, United States",
		                      "Columbia, California, United States"};
		String criteria = "United States";
		
		System.out.println( "Answer >> " +  obj.jobMatchingScore(  locations, criteria) );
	}
	
}
