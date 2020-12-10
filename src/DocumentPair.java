//Group 29
//Emma Chen, Ashley Luty, Joshua Wang
// The DocumentPair class represents a pair of texts that are compared for similarity. Used by UI

public class DocumentPair {
    // percent the main document exactly plagiarized off of the compared document
    private double exactSimilarityScore;
    
    // percent the main document plagiarized off of the compared document, with both exact and synonym similarity
    private double combinedSimilarityScore;
    
    //pre: mainDocument is the document that is being checked for plagiarism,
    //      comparedDocument is the document that mainDocument is being checked against
    //post: initializes the exact similarity score and the combined similarity score (exact + synonym similarity) fields
    //  for the pair of documents
    public DocumentPair(String mainDocument, String comparedDocument) {
        Converter main = new Converter(mainDocument);
        Converter compared = new Converter(comparedDocument);
        
        Comparer comparer = new Comparer(main, compared);
        this.exactSimilarityScore = comparer.getExactScore();
        this.combinedSimilarityScore = comparer.getSynonymScore() + this.exactSimilarityScore;
        
    }
    
    // returns percent (/100) the main document exactly plagiarized off of the compared document
    public double getExactSimilarityScore(){
        return this.exactSimilarityScore;
    }
    
    // returns percent (/100) the main document exactly plagiarized off of the compared document, with both 
    //      exact and synonym similarity
    public double getCombinedSimilarityScore() {
        return this.combinedSimilarityScore;
    }
}
