package collection;

import java.util.HashMap;

public class Hash_Put_All1 {

    public static void main(String[] args) 
    { 
  
        // Creating an empty HashMap 
        HashMap<String, Integer> hash_map = new HashMap<String, Integer>(); 
  
        // Mapping int values to string keys 
        hash_map.put("Geeks", 10); 
        hash_map.put("4", 15); 
        hash_map.put("Geeks", 20); 
        hash_map.put("Welcomes", 25); 
        hash_map.put("You", 30); 
  
        // Displaying the HashMap 
        System.out.println("Initial Mappings are: " + hash_map); 
  
        // Creating a new hash map and copying 
        HashMap<String, Integer> new_hash_map = new HashMap<String, Integer>(); 
        new_hash_map.putAll(hash_map); 
  
        // Displaying the final HashMap 
        System.out.println("The new map looks like this: " + new_hash_map); 
    } 
} 