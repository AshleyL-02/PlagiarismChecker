import java.util.Set;

//program should figure out if I'm quoting shakespeare?
// https://github.com/edent/Open-Source-Shakespeare

// Comparer finds n-gram equality between two document n-grams
public class Comparer {
    
    // pre: takes two sets of strings representing the n-grams of two documents
    // post: returns number of n-grams in common
    public static int compareNGrams(Set<String> ngrams1, Set<String> ngrams2) {
        // choose smaller set
        Set<String> ngrams = ngrams1;
        Set<String> ngramsOther = ngrams2;
        if(ngrams2.size() < ngrams1.size()) {
            ngrams = ngrams2;
            ngramsOther = ngrams1;
        }
        
        // iterate over smaller set
        int counter = 0;
        for(String ngram : ngrams) {
            if(ngramsOther.contains(ngram)) {
                counter++;
            }
        }
        return counter;
    }
}
