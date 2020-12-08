//Group 29
//Emma Chen, Ashley Luty, Joshua Wang
//The DocumentPair class represents a pair of texts that are compared for similarity

public class DocumentPair {
    
    //represents how much the first provided document has plagiarized off of the second one exactly (copied 
    //portions of text)
    private double exactSimilarityScore;
    
    //represents how much the first provided document has plagiarized off of the second one when including
    //synonyms (copied portions of text and related synonyms)
    private double combinedSimilarityScore;
    
    //pre: the first provided String, mainDocument, is the document that is being checked for plagiarism. the 
    //second provided String, comparedDocument, is the document that mainDocument is being checked against.
    //
    //post: initializes the exact similarity score and the combined similarity score (exact + synonym similarity) fields
    //for the pair of documents
    public DocumentPair(String mainDocument, String comparedDocument) {
        Converter main = new Converter(mainDocument);
        Converter compared = new Converter(comparedDocument);
        
        Comparer comparer = new Comparer(main, compared);
        this.exactSimilarityScore = comparer.getExactScore();
        this.combinedSimilarityScore = comparer.getSynonymScore() + this.exactSimilarityScore;
        
    }
    
    //returns a percentage of how much the first provided document has plagiarized off of the second one exactly (copied 
    //portions of text)
    public double getExactSimilarityScore(){
        return this.exactSimilarityScore;
    }
    
    //returns a percentage of how much the first provided document has plagiarized off of the second one exactly (copied 
    //portions of text)
    public double getCombinedSimilarityScore() {
        return this.combinedSimilarityScore;
    }

}
