//Group 29
//Ashley Luty, Joshua Wang, Emma Chen

//The Comparer class calculates the percent similarity of two documents (n-gram equality),
// and the synonym similarity

import java.util.*;

public class Comparer {
    //approximate percent (out of 100.00) of the amount of text the first document copied from the second
    private double exactScore;

    //approximate percent (out of 100.00) of the amount of text the first document copied from the second,
    //  that contain matching (but not equal) synonyms
    private double synonymScore;

    //pre: takes in the Converter of two documents (the first is for the document that is being suspected for
    //  plagiarism and the second is for the document that the other document is being suspected for plagiarizing
    //  off of)
    //post: initializes the two similarity scores for the documents, exact and synonym-only scores
    public Comparer(Converter c1, Converter c2) {
        compareNGrams(c1.getNGrams(), c2.getNGrams());
    }

    // pre: takes two sets representing n-grams of same token length; the first is for the document that is being 
    //      suspected for plagiarism, the second is the document being plagiarized off of
    // post: initializes the two similarity scores for the documents, exact and synonym-only scores (percent /100
    //      first document matches second); if either ngram set is empty, scores are 0.0%
    private void compareNGrams(Set<String> ngramsMain, Set<String> ngramsCompared) {
        if(ngramsMain.isEmpty() || ngramsCompared.isEmpty()) {
            exactScore =0;
            synonymScore =0;
        } else {
            // choose smaller set
            Set<String> ngrams = ngramsMain;
            Set<String> ngramsOther = ngramsCompared;
            if (ngramsCompared.size() < ngramsMain.size()) {
                ngrams = ngramsCompared;
                ngramsOther = ngramsMain;
            }

            // iterate over smaller set
            int exactMatches = 0;
            int synonymMatches = 0; //synonym-only
            for (String ngram : ngrams) {
                if (ngramsOther.contains(ngram)) {
                    exactMatches++;
                } else {
                    for (String ngramOther : ngramsOther) {
                        if (SynonymMap.areSynonymNGrams(ngram, ngramOther)) {
                            synonymMatches++;
                            break;
                        }
                    }
                }
            }

            synonymScore = (double) ((int) (((double) synonymMatches / (double) ngramsMain.size() * 100.00) * 100.00) / 100.00);
            exactScore = (double) ((int) (((double) exactMatches / (double) ngramsMain.size() * 100.00) * 100.00) / 100.00);
        }
    }
    
    // post: returns the percent (/100) the first document matches exactly the second
    public double getExactScore() {
        return exactScore;
    }
       
    // post: returns the percent (/100) the first document synonym-matches the second document, 
    //      not including exact matches
    public double getSynonymScore() {
        return synonymScore;
    }

    //post: returns the similarity score categorization that includes synonyms (uses the exactScore + synonymScore)
    public String getSynonymExactScoreMessage() {
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
