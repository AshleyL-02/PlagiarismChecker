
// Represents a pair of texts to compare similarity
public class DocumentPair {
//    private String mainNGrams;
//    private String comparedNGrams;
    
    private int exactSimilarityScore;
    private int combinedSimilarityScore;
    
    // compares documents
    public DocumentPair(String mainDocument, String comparedDocument) {
        Converter main = new Converter(mainDocument);
        Converter compared = new Converter(comparedDocument);
        
        Comparer compareCD = new Comparer(c, d);
        
    }
    
    public int getExactSimilarityPercent(){
        
    }
    public int getCombinedSimilarityPercent() {
        
    }

}
