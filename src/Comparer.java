//Group 29
//Ashley Luty, Joshua Wang, Emma Chen
//The Comparer class does the comparison between two documents and returns a value that represents the
//percent similarity of the first document to the second document (n-gram equality)

import java.util.*;

public class Comparer {

    //Set<String> of n-grams for the document that is being suspected for plagiarism
    private Set<String> ngrams1;

    //Set<String> of n-grams for the document that the other document is being suspected for plagiarizing
    //off of
    private Set<String> ngrams2;

    private double exactScore;
    //approximate score (out of 100.00) of how SIMILAR (not just copied text) the two documents are to each
    //other
    private double synonymScore;

    //pre: takes in the Converter of two documents (the first is for the document that is being suspected for
    //plagiarism and the second is for the document that the other document is being suspected for plagiarizing
    //off of
    //
    //post: initializes the two n-gram Set<String> for both documents
    public Comparer(Converter c1, Converter c2) {
        ngrams1 = c1.getNGrams();
        ngrams2 = c2.getNGrams();

        compareNGrams();
    }

    //post: returns a double score (percent out of 100.00) that is number of n-grams in that are exactly the same
    //between the two documents divided by the total number of n-grams of the document
    //suspected of plagiarism. also initializes the (double) synonymScore field
    // if either ngram set is empty, scores are 0.0%
    private void compareNGrams() {
        // if either ngram set is empty, scores are 0
        if(ngrams1.isEmpty() || ngrams2.isEmpty()) {
            exactScore =0;
            synonymScore =0;
        } else {
            // choose smaller set
            Set<String> ngrams = ngrams1;
            Set<String> ngramsOther = ngrams2;
            if (ngrams2.size() < ngrams1.size()) {
                ngrams = ngrams2;
                ngramsOther = ngrams1;
            }

            // iterate over smaller set
            int copied = 0;
            int similar = 0;
            for (String ngram : ngrams) {
                if (ngramsOther.contains(ngram)) {
                    copied++;
                    similar++;
                } else {
                    for (String ngramOther : ngramsOther) {
                        if (SynonymMap.synonymInSet(ngram, ngramOther)) {
                            similar++;
                        }
                    }
                }
            }

            synonymScore = (double) ((int) (((double) similar / (double) ngrams1.size() * 100.00) * 100.00) / 100.00);
            exactScore = (double) ((int) (((double) copied / (double) ngrams1.size() * 100.00) * 100.00) / 100.00);
        }
    }

    public double getExactScore() {
        return exactScore;
    }
    public double getSynonymScore() {
        return synonymScore;
    }

    //post: returns the similarity score categorization that includes synonyms
    public String getSynonymScoreMessage() {
        String ret = "When including synonyms, the amount plagiarized is approximately ";
        double score = synonymScore + exactScore;
        if (score == 100.00) {
            return ret + "all of it: " + score + "%";
        } else if (score < 100.00 && score >= 80.00) {
            return ret + "almost all of it: " + score + "%";
        } else if (score < 80.00 && score >= 60.00) {
            return ret + "most of it: " + score + "%";
        } else if (score < 60.00 && score >= 40.00) {
            return ret + "half of it: " + score + "%";
        } else if (score < 40.00 && score >= 20.00) {
            return ret + "a small part of it: " + score + "%";
        } else {
            return ret + "a negligible part of it: " + score + "%";
        }
    }
}
