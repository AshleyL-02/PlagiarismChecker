import java.util.*;
import java.io.*;

public class SynonymMap {

    // stores the thesaurus.
    private Map<String, Set<String>> synonyms;

    // post: constructs a new SynonymMap object.
    public SynonymMap() throws FileNotFoundException {
        File f = new File("synonyms.txt");
        Scanner scanner = new Scanner(f);
        synonyms = new HashMap<String, Set<String>>();
        while (scanner.hasNextLine()) {
            addLine(new Scanner(scanner.nextLine()));
        }
    }

    // post: adds one line of the synonyms.txt document to the thesaurus.
    private void addLine(Scanner scanner) {
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
    public boolean areSynonyms(String s1, String s2) {
        return synonyms.containsKey(s1) && synonyms.get(s1).contains(s2);
    }

    // post: returns true if at least one word from each of the provided Strings are synonyms
    public boolean synonymInSet(String nGram, String nGramOther) {
        List<String> nGramSplitted = new ArrayList<String>(Arrays.asList(nGram.split(" ")));
        List<String> nGramOtherSplitted = new ArrayList<String>(Arrays.asList(nGramOther.split(" ")));
        for (String token: nGramSplitted) {
            if (nGramOtherSplitted.contains(token)) {
                return true;
            }
        }
        return false;
    }

}