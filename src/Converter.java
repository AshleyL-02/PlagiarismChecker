//Group 29
//Emma Chen, Ashley Luty, Joshua Wang
//The Converter class takes in a provided document (either a Scanner with a file or a String) and
//converts that document into all of its n-grams of four.

import java.util.*;

// rename to NGrams?
public class Converter {

    //List<String> document is the user-provided document split by its tokens
    private List<String> document;

    //Set<String> ngrams is the user-provided document split into all its n-grams of four
    private Set<String> ngrams;

    //pre: takes in a String version of the document
    //
    //post: splits the document into its tokens and stores it into the List<String> document field.
    //then calls the private helper method convert to convert the document into it's n-grams
    public Converter(String document) {
        this(new Scanner(document));
    }

    //pre: takes in a Scanner with a file name version of the document
    //
    //post: splits the document into its tokens and stores it into the List<String> document field.
    //then calls the private helper method convert to convert the document into it's n-grams
    // n-grams begin with a space character and are separated by spaces (e.g " hello world")
    public Converter(Scanner document) {
        this.document = new ArrayList<>();
        while (document.hasNext()) {
            this.document.add(cleanToken(document.next()));
        }
        if (this.document.size() < 4) {
            this.ngrams = new HashSet<String>();
        } else {
            this.ngrams = new HashSet<String>(this.document.size(), (float) 0.75);
            convert("", 0);
        }
        System.out.println(ngrams.toString());
    }

    //post: returns the Set<String> of n-grams for the document
    public Set<String> getNGrams() {
        return ngrams;
    }

    //private helper method that creates the Set<String> n-grams field for the document using recursion
    private void convert(String nGram, int indexIntoDocument) {
        if (indexIntoDocument < document.size()) {
            StringTokenizer nGramTokenizer = new StringTokenizer(nGram);
            if (nGramTokenizer.countTokens() == 4) {
                ngrams.add(nGram);
                convert("", indexIntoDocument - 3);
            } else {
                nGram += " " + document.get(indexIntoDocument);
                convert(nGram, indexIntoDocument + 1);
            }
        } else {
            ngrams.add(nGram);
        }
    }

    //private helper method that takes in a token and changes it into lowercase and removes all extraneous
    //punctuation
    private String cleanToken(String token) {
        return token.toLowerCase().replaceAll("[.,<>()!?@#$%^&*{}~:;|/`]", "");
    }
}
