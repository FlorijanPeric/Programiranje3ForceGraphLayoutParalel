package ForceGraphLayout;

import javax.swing.*;
import java.awt.*;

public class StartUi extends JFrame {
    private int widthIn;
    private int heightIn;
    private JTextField field1;
    private JTextField field2;
    private JTextField field3;
    private JTextField field4;
    public StartUi(int width,int height){
        this.widthIn=width;
        this.heightIn=height;
        setPreferredSize(new Dimension(width,height));
    }
    public void createUI(){


        setTitle("Input Form");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2)); // Set layout manager

        // Create labels and text fields
        JLabel label1 = new JLabel("Number of Nodes:");
        field1 = new JTextField();
        JLabel label2 = new JLabel("Number of Edges:");
        field2 = new JTextField();
        JLabel label3 = new JLabel("Type of run:");
        field3 = new JTextField();


        // Add labels and text fields to the frame
        add(label1);
        add(field1);
        add(label2);
        add(field2);
        add(label3);
        add(field3);

        // Add a button to save the data
        JButton saveButton = new JButton("Save");
        add(saveButton);
        setVisible(true);
    }



}
