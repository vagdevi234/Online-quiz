package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener {
    
    String questions[][] = new String[10][5];      
    String answers[][] = new String[10][2];
    String useranswers[][] = new String[10][1];
    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions;
    JButton next, submit;
    
    public static int timer = 15;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;
    
    String name;
    
    Quiz(String name) {
        this.name = name;
        setBounds(50, 0, 1440, 850);
        getContentPane().setBackground(new Color(245, 245, 220)); // Light beige background
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1440, 392);
        add(image);
        
        qno = new JLabel();
        qno.setBounds(100, 450, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        qno.setForeground(new Color(50, 50, 150)); // Navy blue text
        add(qno);
        
        question = new JLabel();
        question.setBounds(150, 450, 900, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        question.setForeground(new Color(50, 50, 150)); // Navy blue text
        add(question);

        // Define questions
        questions[0][0] = "What is the size of the int data type in Java?";
        questions[0][1] = "2 bytes";
        questions[0][2] = "4 bytes";
        questions[0][3] = "8 bytes";
        questions[0][4] = "1 byte";

        questions[1][0] = "What is the default value of a boolean variable in Java?";
        questions[1][1] = "true";
        questions[1][2] = "false";
        questions[1][3] = "0";
        questions[1][4] = "null";

        questions[2][0] = "Which method is used to find the length of a string in Java?";
        questions[2][1] = "size()";
        questions[2][2] = "length()";
        questions[2][3] = "getSize()";
        questions[2][4] = "getLength()";

        questions[3][0] = "Which exception is thrown when dividing a number by zero?";
        questions[3][1] = "NullPointerException";
        questions[3][2] = "NumberFormatException";
        questions[3][3] = "ArithmeticException";
        questions[3][4] = "IndexOutOfBoundsException";

        questions[4][0] = "What is the keyword for creating an object in Java?";
        questions[4][1] = "create";
        questions[4][2] = "new";
        questions[4][3] = "object";
        questions[4][4] = "instance";

        questions[5][0] = "What does System.out.println() do in Java?";
        questions[5][1] = "Prints a line to the console";
        questions[5][2] = "Reads a line from the console";
        questions[5][3] = "Opens a file";
        questions[5][4] = "Terminates the program";

        questions[6][0] = "Which collection type stores key-value pairs?";
        questions[6][1] = "List";
        questions[6][2] = "Map";
        questions[6][3] = "Set";
        questions[6][4] = "Queue";

        questions[7][0] = "Which is the correct syntax for declaring an array in Java?";
        questions[7][1] = "int arr = new int[5]";
        questions[7][2] = "int[] arr = new int[5]";
        questions[7][3] = "int arr = [5]";
        questions[7][4] = "int arr(5)";

        questions[8][0] = "What is the parent class of all classes in Java?";
        questions[8][1] = "Object";
        questions[8][2] = "Class";
        questions[8][3] = "Super";
        questions[8][4] = "Parent";

        questions[9][0] = "What is the process of converting a primitive value into an object in Java called?";
        questions[9][1] = "Boxing";
        questions[9][2] = "Autoboxing";
        questions[9][3] = "Unboxing";
        questions[9][4] = "Casting";

        // Updated Answers
        answers[0][1] = "4 bytes";
        answers[1][1] = "false";
        answers[2][1] = "length()";
        answers[3][1] = "ArithmeticException";
        answers[4][1] = "new";
        answers[5][1] = "Prints a line to the console";
        answers[6][1] = "Map";
        answers[7][1] = "int[] arr = new int[5]";
        answers[8][1] = "Object";
        answers[9][1] = "Autoboxing";

        // ... (remaining questions and answers are unchanged)

        opt1 = new JRadioButton();
        opt1.setBounds(170, 520, 700, 30);
        opt1.setBackground(new Color(240, 255, 240)); // Light green background
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt1);
        
        opt2 = new JRadioButton();
        opt2.setBounds(170, 560, 700, 30);
        opt2.setBackground(new Color(240, 255, 240)); // Light green background
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt2);
        
        opt3 = new JRadioButton();
        opt3.setBounds(170, 600, 700, 30);
        opt3.setBackground(new Color(240, 255, 240)); // Light green background
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt3);
        
        opt4 = new JRadioButton();
        opt4.setBounds(170, 640, 700, 30);
        opt4.setBackground(new Color(240, 255, 240)); // Light green background
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt4);
        
        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);
        
        next = new JButton("Next");
        next.setBounds(1100, 550, 200, 40);
        next.setFont(new Font("Tahoma", Font.PLAIN, 22));
        next.setBackground(new Color(30, 144, 255)); // Dodger blue background
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);
        
        submit = new JButton("Submit");
        submit.setBounds(1100, 710, 200, 40);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 22));
        submit.setBackground(new Color(34, 139, 34)); // Forest green background
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);
        
        start(count);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            repaint();
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
               useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }
            
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            
            count++;
            start(count);
        } else if (ae.getSource() == submit) {
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }

            for (int i = 0; i < useranswers.length; i++) {
                if (useranswers[i][0].equals(answers[i][1])) {
                    score += 10;
                }
            }
            setVisible(false);
            new Score(name, score);
        }
    }
    
    public void paint(Graphics g) {
        super.paint(g);
        String time = "Time left - " + timer + " seconds";
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        if (timer > 0) { 
            g.drawString(time, 1100, 500);
        } else {
            g.drawString("Times up!!", 1100, 500);
        }
        
        timer--;
        
        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        if (ans_given == 1) {
            ans_given = 0;
            timer = 15;
        } else if (timer < 0) {
            timer = 15;
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if (count == 9) {
                setVisible(false);
                new Score(name, score);
            } else {
                count++;
                start(count);
            }
        }
    }
    
    public void start(int count) {
        qno.setText("" + (count + 1) + ". ");
        question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);
        
        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);
        
        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);
        
        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);
        
        groupoptions.clearSelection();
    }
    
    public static void main(String[] args) {
        new Quiz("User");
    }
}
