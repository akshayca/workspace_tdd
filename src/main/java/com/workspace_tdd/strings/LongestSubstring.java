package com.workspace_tdd.strings;

import java.util.HashSet;

import com.workspace_tdd.strings.custom_exceptions.EmptyStringException;

public class LongestSubstring {

    //Given a string str, find the length of the longest substring without repeating characters.
    
    public int lengthOfLongestSubstring(String str)  throws EmptyStringException{
        
        //Throw an exception for empty string 
        if (str.isEmpty()) {
            throw new EmptyStringException("You have passed an empty string");
          }
        
        int max = 0;

        //use 2 pointer to track the length
        int i = 0;
        int j =0;

        //To store the substring
        HashSet<Character> hash_set = new HashSet<>();

        //move the 2nd pointer until the end and update max
        while(j< str.length()){
            if(!hash_set.contains(str.charAt(j))){
                hash_set.add(str.charAt(j));
                j++;
                max = Math.max(hash_set.size(),max);
            }else{
                //remove and move the first character
                hash_set.remove(str.charAt(i));
                i++;
            }
        }
        return max;
    }
   
}
