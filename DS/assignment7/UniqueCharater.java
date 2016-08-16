package assignment7;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
/**
 * This program is used to count the unique charters in the given string
 * and to implements caching into it.  
 * @author Ajinkya pande
 *
 */
public class UniqueCharater {
	
	// This hash map is used for cache memory of occurrence of the word
	private HashMap<String, Integer> cache = new HashMap<String, Integer>();
	
	/**
	 * This function will count the unique charters in the given string
	 * @param string takes the parameter as String in which you have to find the unique charter
	 * @return the no of unique charter in the given string 
	 */
	public int countUniqueChar(String string) {
		int result = checkInCache(string);
		// Not found in cache
		if (result == -1) {
			char[] charOfString = string.toCharArray();
			// To keep track unique characters
			Set<Character> uniqueChar = new HashSet<Character>();
			for (int i = 0; i < charOfString.length; i++) {
				uniqueChar.add(charOfString[i]);
			}
			// put into the cache map
			cache.put(string, uniqueChar.size());
			return uniqueChar.size();
		}
		return result;
	}
	
	/**
	 * This function is used to check whether that string is present over that cache or not
	 * if yes then it will return the no of unique charter in the string
	 * else it will return -1 value
	 * @param string is parameter type String 
	 * @return unique charter in the string
	 */
	private int checkInCache(String string) {
		if (cache.containsKey(string)) {
			System.out.println("found in cache");
			return cache.get(string);
		}
		return -1;
	}
}
