package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener {

    String name;
    JButton start, back;

    Rules(String name) {
        this.name = name;
        // Set a different background color (light gray in this case)
        getContentPane().setBackground(new Color(250, 248, 255));  // Light blue background
        setLayout(null);

        JLabel heading = new JLabel("Welcome " + name + " to Java Mastermind");
        heading.setBounds(200, 20, 700, 30);
        heading.setFont(new Font("Mongolian Baiti", Font.BOLD, 28));
        heading.setForeground(new Color(30, 144, 254));  // Blue color for the heading
        add(heading);

        JLabel rules = new JLabel();
        rules.setBounds(50, 90, 700, 350);
        rules.setFont(new Font("Tahoma", Font.PLAIN, 16));
        rules.setText(
            "<html>" + 
                "1. Stay calm and let your knowledge do the talking." + "<br><br>" +
                "2. The clock is ticking, but your focus should never waver." + "<br><br>" +
                "3. This isn't a race; it's a challenge. Solve one question at a time." + "<br><br>" +
                "4. No need to panic—every question has a solution waiting for you." + "<br><br>" +
                "5. Wisdom is answering with confidence. Don’t rush, think smart." + "<br><br>" +
                "6. It’s okay if others are ahead—your turn will come, just focus!" + "<br><br>" +
                "7. If you're feeling nervous, remember: pressure builds diamonds." + "<br><br>" +
                "8. The path to success is paved with answers, not doubts. Good luck!" + "<br><br>" +
            "</html>"
        );
        add(rules);

        back = new JButton("Back");
        back.setBounds(250, 500, 100, 30);
        back.setBackground(new Color(30, 144, 254));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        start = new JButton("Start");
        start.setBounds(400, 500, 100, 30);  // Fixed bounds for the Start button
        start.setBackground(new Color(30, 144, 254));
        start.setForeground(Color.WHITE);
        start.addActionListener(this);
        add(start);

        setSize(800, 650);
        setLocation(350, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == start) {
            setVisible(false);
            new Quiz(name);  // Starts the quiz
        } else {
            setVisible(false);
            new Login();  // Goes back to the login screen
        }
    }

    public static void main(String[] args) {
        new Rules("User");  // Example user name
    }
}
