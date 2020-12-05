
// Represents a pair of texts that are compared for similarity
public class DocumentPair {
    private double exactSimilarityScore;
    private double combinedSimilarityScore;
    
    // compares documents
    public DocumentPair(String mainDocument, String comparedDocument) {
        Converter main = new Converter(mainDocument);
        Converter compared = new Converter(comparedDocument);
        
        Comparer comparer = new Comparer(main, compared);
        this.exactSimilarityScore = comparer.getExactScore();
        this.combinedSimilarityScore = comparer.getSynonymScore() + this.exactSimilarityScore;
        
    }
    
    public double getExactSimilarityScore(){
        return this.exactSimilarityScore;
    }
    public double getCombinedSimilarityScore() {
        return this.combinedSimilarityScore;
    }

}
