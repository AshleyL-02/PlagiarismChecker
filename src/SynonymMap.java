import java.util.*;
import java.io.*;

// !!! static methods to prevent re-parsing of file (ask TA about this)
public class SynonymMap {
    private static final String SYNONYM_FILE_NAME = "src/synonyms.txt";
    
    // stores the thesaurus.
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
    
    // post: returns true if at least one word from each of the provided Strings are synonyms
    public static boolean synonymInSet(String nGram, String nGramOther) {
        List<String> nGramSplitted = new ArrayList<String>(Arrays.asList(nGram.split(" ")));
        List<String> nGramOtherSplitted = new ArrayList<String>(Arrays.asList(nGramOther.split(" ")));
        for (int i = 0; i < nGramOtherSplitted.size(); i++) {
            if (areSynonyms(nGramOtherSplitted.get(i), nGramSplitted.get(i))) {
                return true;
            }
        }
        return false;
    }

    // post: constructor helper method
    //      adds one line of the synonyms.txt document to the thesaurus.
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
