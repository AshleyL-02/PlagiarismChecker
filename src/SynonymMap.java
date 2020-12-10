//Group 29
//Joshua Wang, Ashley Luty, Emma Chen
//A SynonymMap class represents a thesaurus of synonyms for some words, and can check if phrases
//  match based on shared synonyms

import java.util.*;
import java.io.*;

public class SynonymMap {
    
    // file used to create the synonym map 
    private static final String SYNONYM_FILE_NAME = "src/synonyms.txt";
    
    // maps word to its synonyms?
    private static Map<String, Set<String>> synonyms;
    
    // called once by main method to parse file
    public static void setupMap() throws FileNotFoundException{
        File f = new File(SYNONYM_FILE_NAME);
        Scanner scanner = new Scanner(f);
        synonyms = new HashMap<String, Set<String>>();
        while (scanner.hasNextLine()) {
            addLine(new Scanner(scanner.nextLine()));
        }
        scanner.close();
    }
    
    // pre: takes two n-grams of same token length, all lowercase
    // post: returns true if n-grams match word-by-word; words that are synonyms are matches
    public static boolean areSynonymNGrams(String nGram, String nGramOther) {
        String[] nGramSplitted = nGram.split(" ");
        String[] nGramOtherSplitted = nGramOther.split(" ");
        for (int i = 0; i < nGramOtherSplitted.length; i++) {
            String word = nGramSplitted[i];
            String wordOther = nGramOtherSplitted[i];
            if (!word.equals(wordOther) && !areSynonyms(wordOther, word)) {
                return false;
            }
        }
        return true;
    }

    // pre: constructor helper method; 
    //      takes Scanner of a synonym file, where each line in file is synonyms separated by a space
    // post: adds one line of the synonym document to the thesaurus
    private static void addLine(Scanner scanner) {
        Queue<String> words = new LinkedList<String>();
        while (scanner.hasNext()) {
            words.add(scanner.next().toLowerCase());
        }
        for (int i = 0; i < words.size(); i++) {
            String key = words.remove();
            for (int j = 0; j < words.size(); j++) {
                String value = words.remove();
                if (!synonyms.containsKey(key)) {
                    synonyms.put(key, new HashSet<String>());
                    synonyms.get(key).add(value);
                } else if (!synonyms.get(key).contains(value)) {
                    synonyms.get(key).add(value);
                }
                words.add(value);
            }
            words.add(key);
        }
    }

    // post: returns true if the strings are synonyms or if they are the same.
    private static boolean areSynonyms(String s1, String s2) {
        return synonyms.containsKey(s1) && synonyms.get(s1).contains(s2);
    }
}
