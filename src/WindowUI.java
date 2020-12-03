import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;

public class WindowUI extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    WindowUI frame = new WindowUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public WindowUI() {
        setTitle("Plagiarism Checker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 640, 640);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
        
        Box verticalBox_3 = Box.createVerticalBox();
        contentPane.add(verticalBox_3);
        
        JLabel lblNewLabel_3 = new JLabel("Instrutions: Paste document in left, document to check against in right.");
        lblNewLabel_3.setAlignmentX(Component.CENTER_ALIGNMENT);
        verticalBox_3.add(lblNewLabel_3);
        
        JSeparator separator = new JSeparator();
        verticalBox_3.add(separator);
        
        Box horizontalBox = Box.createHorizontalBox();
        verticalBox_3.add(horizontalBox);
        
        Box verticalBox = Box.createVerticalBox();
        horizontalBox.add(verticalBox);
        
        JLabel lblNewLabel = new JLabel("Main document");
        verticalBox.add(lblNewLabel);
        
        JTextArea textArea_1 = new JTextArea();
        verticalBox.add(textArea_1);
        
        Component rigidArea = Box.createRigidArea(new Dimension(10, 10));
        horizontalBox.add(rigidArea);
        
        Box verticalBox_1 = Box.createVerticalBox();
        verticalBox_1.setAlignmentX(Component.RIGHT_ALIGNMENT);
        horizontalBox.add(verticalBox_1);
        
        JLabel lblNewLabel_1 = new JLabel("Compared document");
        verticalBox_1.add(lblNewLabel_1);
        
        JTextArea textArea = new JTextArea();
        verticalBox_1.add(textArea);
        
        JSeparator separator_1 = new JSeparator();
        verticalBox_3.add(separator_1);
        
        JButton btnNewButton = new JButton("Check");
        btnNewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        verticalBox_3.add(btnNewButton);
        
        Box horizontalBox_1 = Box.createHorizontalBox();
        verticalBox_3.add(horizontalBox_1);
        
        Box verticalBox_2 = Box.createVerticalBox();
        horizontalBox_1.add(verticalBox_2);
        
        JLabel lblNewLabel_2 = new JLabel("Exact similarity:");
        verticalBox_2.add(lblNewLabel_2);
        
        JLabel lblNewLabel_5 = new JLabel("Exact + synonym similarity:");
        verticalBox_2.add(lblNewLabel_5);
        
        Component rigidArea_1 = Box.createRigidArea(new Dimension(10, 10));
        horizontalBox_1.add(rigidArea_1);
        
        Box verticalBox_4 = Box.createVerticalBox();
        horizontalBox_1.add(verticalBox_4);
        
        JLabel lblNewLabel_4 = new JLabel("New label");
        verticalBox_4.add(lblNewLabel_4);
        
        JLabel lblNewLabel_6 = new JLabel("New label");
        verticalBox_4.add(lblNewLabel_6);
    }
}
