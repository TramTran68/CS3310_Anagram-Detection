/******************************************************************/
 /* Tram Tran                                                     */
 /* Login ID: 017353518                                           */
 /* CS 3310, Spring 2025                                          */
 /* Programming Assignment 2                                      */    
 /* Prog2 class: all sets of anagrams of words in the file        */
/******************************************************************/

import java.io.*;
import java.util.*;

public class Prog2 {
    /***************************************************************/
    /* Method: main                                                */
    /* Purpose: Reads input file, processes each words,            */
    /*          and outputs all sets of anagrams.                  */
    /* Parameters:                                                 */
    /* String[] args - Command-line arguments (expects filename)   */
    /* Returns: None                                               */
    /***************************************************************/
    public static void main(String[] args) throws IOException {
        // handle command-line argument usage
        if (args.length != 1) {
            System.out.println("Usage: java Prog2 <filename>");
            System.exit(1);
        }
        
        // store the input file name provided by the user
        String inputFile = args[0];

        // find and store anagram groups from the file
        Map<String, List<String>> anagrams = findAnagrams(inputFile);

        // print the detected anagram groups
        printAnagrams(anagrams);
    }

    /***************************************************************/
    /* Method: findAnagrams                                        */
    /* Purpose: Reads words from a file, groups them into sets of  */
    /*          anagrams while ignoring case differences           */
    /* Parameters:                                                 */
    /* inputFile (String): The input file containing words.        */
    /* Returns:                                                    */
    /* (Map<String, List<String>>): A HashMap where each key is a  */ 
    /* sorted version of the word (lowercase), and the value is a  */
    /* value is a list of original words that form an anagram set  */
    /***************************************************************/
    public static Map<String, List<String>> findAnagrams(String inputFile) throws IOException {
        // HashMap to store sorted letter combinations as keys 
        // and lists of original words as values
        Map<String, List<String>> anagrams = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String word; // variable to store each word read from the file

            // read each word (line) from the file
            while ((word = reader.readLine()) != null) {
                word = word.trim(); // reomve any leading/trailing whitespace

                // convert word to lowercas and sort its letters to form the key
                String sortedWord = sortString(word.toLowerCase());
                
                // group words by their sorted key (ignoring case)
                anagrams.computeIfAbsent(sortedWord, k -> new ArrayList<>()).add(word);
            }
        } catch (IOException e) {
            // handle errors if the file cannot be read
            System.err.println("Error reading file: " + e.getMessage());
        }
        
        return anagrams;
    }

    /***************************************************************/
    /* Method: sortString                                          */
    /* Purpose: Sorts the characters of a given word alphabetically*/
    /* Parameters:                                                 */   
    /* word (String): The word whose characters need to be sorted. */
    /* Returns:                                                    */ 
    /* (String): A new string where the characters are sorted      */
    /*          alphabetically.                                    */
    /***************************************************************/
    public static String sortString(String word) {
        // convert word into a character array
        char[] chars = word.toCharArray();
        // sort character array alphabetically
        Arrays.sort(chars);
        // convert the sorted character array back to a string and return it
        return new String(chars);
    }
    
    /***************************************************************/
    /* Method: printAnagrams                                       */
    /* Purpose: Prints all sets of anagrams found in a readable    */
    /*          format.                                            */
    /* Parameters:                                                 */   
    /* anagramGroups (Map<String, List<String>>): A map of sorted  */
    /* keys to anagram word lists.                                 */
    /* Returns: None                                               */ 
    /***************************************************************/
    public static void printAnagrams(Map<String, List<String>> anagrams) {
        System.out.println("Anagram sets: ");
        boolean found = false; // flag to check if any anagrams were found

        for (List<String> anagramSet : anagrams.values()) {
            // only print groups with more than one word (actual anagrams)
            if (anagramSet.size() > 1) {
                found = true;
                System.out.println(anagramSet); // print the set of anagrams
            }
            
            // if no anagrams were found, print a message
            if (!found) {
                System.out.println("No anagrams found.");
            }
        }
    }
}
