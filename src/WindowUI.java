//Group 29
//Joshua Wang, Ashley Luty, Emma Chen

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.DropMode;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// A WindowUI is a user interface window that provides areas to input text,
//  and displays similarity scores
// Boilerplate Swing design code written with eclipse WindowBuilder plugin

public class WindowUI extends JFrame {
    // window text
    private static final String WINDOW_TITLE = "Plagiarism Checker";
    private static final String INSTRUCTIONS = "Instrutions: Paste document in left, "
            + "document to check against in right. Must be >=4 words.";
    
    // text areas for user-inputted documents
    private JTextArea mainDocTextArea, comparedDocTextArea;
    
    // similarity score labels
    private JLabel exactSimilarityLabel, combinedSimilarityLabel;

    // post: creates the ui window
    public WindowUI() {
        setPreferredSize(new Dimension(600, 400));
        setMinimumSize(new Dimension(400, 300));
        setSize(new Dimension(610, 511));
        setTitle(WINDOW_TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 520);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
        
        Box verticalBox_3 = Box.createVerticalBox();
        verticalBox_3.setAlignmentY(Component.TOP_ALIGNMENT);
        contentPane.add(verticalBox_3);
        
        JLabel lblNewLabel_3 = new JLabel(INSTRUCTIONS);
        lblNewLabel_3.setAlignmentY(Component.TOP_ALIGNMENT);
        lblNewLabel_3.setAlignmentX(Component.CENTER_ALIGNMENT);
        verticalBox_3.add(lblNewLabel_3);
        
        Box horizontalBox = Box.createHorizontalBox();
        horizontalBox.setBorder(new LineBorder(new Color(0, 0, 0)));
        horizontalBox.setAlignmentY(Component.CENTER_ALIGNMENT);
        verticalBox_3.add(horizontalBox);
        
        Box verticalBox = Box.createVerticalBox();
        verticalBox.setAlignmentX(Component.RIGHT_ALIGNMENT);
        horizontalBox.add(verticalBox);
        
        JLabel lblNewLabel = new JLabel("Main document");
        lblNewLabel.setAlignmentY(Component.TOP_ALIGNMENT);
        verticalBox.add(lblNewLabel);
        
        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setAlignmentY(Component.TOP_ALIGNMENT);
        scrollPane_1.setAlignmentX(Component.LEFT_ALIGNMENT);
        verticalBox.add(scrollPane_1);
        
        // Main Doc
        mainDocTextArea = new JTextArea();
        mainDocTextArea.setLineWrap(true);
        mainDocTextArea.setDropMode(DropMode.INSERT);
        mainDocTextArea.setColumns(1);
        scrollPane_1.setViewportView(mainDocTextArea);
        mainDocTextArea.setWrapStyleWord(true);
        
        Component rigidArea = Box.createRigidArea(new Dimension(10, 10));
        horizontalBox.add(rigidArea);
        
        Box verticalBox_1 = Box.createVerticalBox();
        horizontalBox.add(verticalBox_1);
        
        JLabel lblNewLabel_1 = new JLabel("Compared document");
        lblNewLabel_1.setAlignmentY(Component.TOP_ALIGNMENT);
        verticalBox_1.add(lblNewLabel_1);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setAlignmentY(Component.TOP_ALIGNMENT);
        scrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);
        verticalBox_1.add(scrollPane);
        
        // Compared Doc
        comparedDocTextArea = new JTextArea();
        comparedDocTextArea.setLineWrap(true);
        comparedDocTextArea.setWrapStyleWord(true);
        comparedDocTextArea.setDropMode(DropMode.INSERT);
        comparedDocTextArea.setColumns(1);
        scrollPane.setViewportView(comparedDocTextArea);
        
        // Check Button and action listener
        JButton checkButton = new JButton("Check");
        checkButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displaySimilarityScores();
            }
        });
        checkButton.setAlignmentY(Component.TOP_ALIGNMENT);
        checkButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        verticalBox_3.add(checkButton);
        
        Box horizontalBox_1 = Box.createHorizontalBox();
        horizontalBox_1.setAlignmentY(Component.CENTER_ALIGNMENT);
        verticalBox_3.add(horizontalBox_1);
        
        Box verticalBox_2 = Box.createVerticalBox();
        horizontalBox_1.add(verticalBox_2);
        
        JLabel lblNewLabel_2 = new JLabel("Exact similarity:");
        lblNewLabel_2.setAlignmentY(Component.TOP_ALIGNMENT);
        verticalBox_2.add(lblNewLabel_2);
        
        JLabel lblNewLabel_5 = new JLabel("Exact + synonym similarity:");
        lblNewLabel_5.setAlignmentY(Component.TOP_ALIGNMENT);
        verticalBox_2.add(lblNewLabel_5);
        
        Component rigidArea_1 = Box.createRigidArea(new Dimension(10, 10));
        horizontalBox_1.add(rigidArea_1);
        
        Box verticalBox_4 = Box.createVerticalBox();
        horizontalBox_1.add(verticalBox_4);
        
        // Result Labels
        exactSimilarityLabel = new JLabel("--");
        exactSimilarityLabel.setAlignmentY(Component.TOP_ALIGNMENT);
        verticalBox_4.add(exactSimilarityLabel);
        
        combinedSimilarityLabel = new JLabel("--");
        combinedSimilarityLabel.setAlignmentY(Component.TOP_ALIGNMENT);
        verticalBox_4.add(combinedSimilarityLabel);
    }
    
    // pre: called automatically whenever check button is pressed
    // post: takes String text from main and compared text areas,
    //      displays resulting exact and combined similarity scores 
    //      (percents out of main document)
    private void displaySimilarityScores() {
        DocumentPair docs = new DocumentPair(mainDocTextArea.getText(), comparedDocTextArea.getText());
        exactSimilarityLabel.setText(docs.getExactSimilarityScore() + " %");
        combinedSimilarityLabel.setText(docs.getCombinedSimilarityScore() + " %");;
    }
    
}
