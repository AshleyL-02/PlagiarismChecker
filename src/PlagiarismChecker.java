import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// A PlagiarismChecker checks the similarity between two texts
public class PlagiarismChecker {
    //application window
    private static WindowUI appWindow;

    public static void main(String[] args) {  
        
        // create button action listener
        ActionListener checkButtonActionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkButtonPressed();
            }
        }
        
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
        
        // subscribe to button events

    }

}
