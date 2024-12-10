package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {
    JButton rules, back;
    JTextField tfname;

    Login() {
        // Set a gradient background
        setContentPane(new GradientPanel());

        setLayout(null);

        JLabel heading = new JLabel("Java Mastermind");
        heading.setBounds(470, 60, 300, 45);
        heading.setFont(new Font("Mongolian Baiti", Font.BOLD, 40));
        heading.setForeground(new Color(30, 144, 254));
        add(heading);

        JLabel name = new JLabel("Enter your name");
        name.setBounds(520, 150, 300, 20);
        name.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
        name.setForeground(new Color(30, 144, 254));
        add(name);

        tfname = new JTextField();
        tfname.setBounds(440, 200, 300, 25);
        tfname.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(tfname);

        rules = new JButton("Start");
        rules.setBounds(440, 270, 120, 25);
        rules.setBackground(new Color(30, 144, 254));
        rules.setForeground(Color.WHITE);
        rules.addActionListener(this);
        add(rules);

        back = new JButton("Back");
        back.setBounds(620, 270, 120, 25);
        back.setBackground(new Color(30, 144, 254));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setSize(1200, 500);
        setLocation(100, 150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == rules) {
            String name = tfname.getText();
            setVisible(false);
            new Rules(name);
        } else if (ae.getSource() == back) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}

// GradientPanel class to create a gradient background
class GradientPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();

        // Gradient from top (light blue) to bottom (light purple)
        Color color1 = new Color(173, 216, 230); // Light blue
        Color color2 = new Color(221, 160, 221); // Light purple
        GradientPaint gradient = new GradientPaint(0, 0, color1, 0, height, color2);

        g2d.setPaint(gradient);
        g2d.fillRect(0, 0, width, height);
    }
}
