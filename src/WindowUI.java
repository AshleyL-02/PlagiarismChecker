import java.awt.EventQueue;

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
        setPreferredSize(new Dimension(600, 400));
        setMinimumSize(new Dimension(400, 300));
        setSize(new Dimension(610, 511));
        setTitle("Plagiarism Checker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 520);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
        
        Box verticalBox_3 = Box.createVerticalBox();
        verticalBox_3.setAlignmentY(Component.TOP_ALIGNMENT);
        contentPane.add(verticalBox_3);
        
        JLabel lblNewLabel_3 = new JLabel("Instrutions: Paste document in left, document to check against in right.");
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
        
        JTextArea textArea_1 = new JTextArea();
        textArea_1.setLineWrap(true);
        textArea_1.setDropMode(DropMode.INSERT);
        textArea_1.setColumns(1);
        scrollPane_1.setViewportView(textArea_1);
        textArea_1.setWrapStyleWord(true);
        
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
        
        JTextArea textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setDropMode(DropMode.INSERT);
        textArea.setColumns(1);
        scrollPane.setViewportView(textArea);
        
        JButton btnNewButton = new JButton("Check");
        btnNewButton.setAlignmentY(Component.TOP_ALIGNMENT);
        btnNewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        verticalBox_3.add(btnNewButton);
        
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
        
        JLabel lblNewLabel_4 = new JLabel("New label");
        lblNewLabel_4.setAlignmentY(Component.TOP_ALIGNMENT);
        verticalBox_4.add(lblNewLabel_4);
        
        JLabel lblNewLabel_6 = new JLabel("New label");
        lblNewLabel_6.setAlignmentY(Component.TOP_ALIGNMENT);
        verticalBox_4.add(lblNewLabel_6);
    }
}
