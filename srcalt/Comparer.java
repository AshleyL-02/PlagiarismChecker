import java.util.Set;
import java.io.*;

//program should figure out if I'm quoting shakespeare?
// https://github.com/edent/Open-Source-Shakespeare

//https://www.kaggle.com/duketemon/wordnet-synonyms

// Comparer finds n-gram equality between two document n-grams
public class Comparer {
    
	private Set<String> ngrams1;
	private Set<String> ngrams2;
	
	public Comparer(Converter c1, Converter c2) {
		ngrams1 = c1.getNGrams();
		ngrams2 = c2.getNGrams();
	}
	
    // pre: takes two sets of strings representing the n-grams of two documents
    // post: returns number of n-grams in common
    public int compareNGrams() throws FileNotFoundException {
        // choose smaller set
        Set<String> ngrams = ngrams1;
        Set<String> ngramsOther = ngrams2;
        SynonymMap synonyms = new SynonymMap();
        if(ngrams2.size() < ngrams1.size()) {
            ngrams = ngrams2;
            ngramsOther = ngrams1;
        }
        
        // iterate over smaller set
        int counter = 0;
        for(String ngram : ngrams) {
            if(ngramsOther.contains(ngram) || synonyms.synonymInSet(ngram, ngramsOther)) {
                counter++;
            }
        }
        return counter;
    }
}
