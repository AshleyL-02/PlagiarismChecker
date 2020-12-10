//Group 29
//Joshua Wang, Ashley Luty, Emma Chen
// A PlagiarismChecker checks the similarity between two texts provided via user interface.

import java.awt.EventQueue;
import java.io.FileNotFoundException;

public class PlagiarismChecker {
    public static void main(String[] args) throws FileNotFoundException { 
        // called once, to parse synonyms file
        SynonymMap.setupMap();
        
        setupAppWindow();
    }
    
    // post: constructor helper method, creates and opens application window
    private static void setupAppWindow() {        
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    WindowUI appWindow = new WindowUI();
                    appWindow.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
