import java.util.*;

public class Converter {

    private List<String> document;
    private Set<String> ngrams;

    public Converter(String document) {
        this(new Scanner(document));
    }

    public Converter(Scanner document) {
        this.document = new ArrayList<>();
        this.ngrams = new HashSet<>();
        while (document.hasNext()) {
            this.document.add(cleanToken(document.next()));
        }
        convert("", 0);
    }

    public Set<String> getNGrams() {
        return ngrams;
    }

    //n-gram lengths of four
    private void convert(String nGram, int indexIntoDocument) {
        if (indexIntoDocument < document.size()) {
            StringTokenizer nGramTokenizer = new StringTokenizer(nGram);
            if (nGramTokenizer.countTokens() == 4) {
                ngrams.add(nGram.substring(1));
                convert("", indexIntoDocument - 3);
            } else {
                nGram += " " + document.get(indexIntoDocument);
                convert(nGram, indexIntoDocument + 1);
            }
        } else {
            ngrams.add(nGram.substring(1));
        }
    }

    private String cleanToken(String token) {
        return token.toLowerCase().replaceAll("[.,<>()!?@#$%^&*{}~:;|/`]", "");
    }
    
}
