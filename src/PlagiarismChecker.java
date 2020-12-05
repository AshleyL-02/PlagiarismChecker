import java.awt.EventQueue;
import java.io.FileNotFoundException;

// A PlagiarismChecker checks the similarity between two texts
public class PlagiarismChecker {
    //application window
    private static WindowUI appWindow;

    public static void main(String[] args) throws FileNotFoundException { 
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
