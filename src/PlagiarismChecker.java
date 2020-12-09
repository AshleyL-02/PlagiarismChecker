//Group 29
//Joshua Wang, Ashley Luty, Emma Chen
// A PlagiarismChecker checks the similarity between two texts. When the class is run, the user interface should pop up.

import java.awt.EventQueue;
import java.io.FileNotFoundException;

public class PlagiarismChecker {
    //application window
    private static WindowUI appWindow;

    public static void main(String[] args) throws FileNotFoundException { 
        // called once, to parse synonyms file
        SynonymMap.setupMap();
        
        createAppWindow();
    }
    
    private static void createAppWindow() {        
        // create application window
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    appWindow = new WindowUI();
                    appWindow.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
