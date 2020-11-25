import java.util.*;

public class Converter {

    private List<String> document;
    private Set<String> NGrams;

    public Converter(String document) {
        this(new Scanner(document));
    }

    public Converter(Scanner document) {
        this.document = new ArrayList<>();
        this.NGrams = new HashSet<>();
        while (document.hasNext()) {
            this.document.add(cleanToken(document.next()));
        }
        convert("", 0);
    }

    public Set<String> getNGrams() {
        return NGrams;
    }

    //n-gram lengths of four
    private void convert(String nGram, int indexIntoDocument) {
        if (indexIntoDocument < document.size()) {
            StringTokenizer nGramTokenizer = new StringTokenizer(nGram);
            if (nGramTokenizer.countTokens() == 4) {
                NGrams.add(nGram);
                convert("", indexIntoDocument - 3);
            } else {
                nGram = nGram + " " + document.get(indexIntoDocument);
                convert(nGram, indexIntoDocument + 1);
            }
        } else {
            NGrams.add(nGram);
        }
    }

    private String cleanToken(String token) {
        return token.toLowerCase().replaceAll("[.,<>()!@#$%^&*{}~`]", "");
    }

    public static void main(String[] args) {
        Converter c = new Converter("i love dOGs so, much. dude YEA");
        System.out.println(c.getNGrams());
    }
}