import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class FortuneTellerApp {

    private static final String[] FORTUNES = {
    "You will find great success in your future endeavors.",
    "A new opportunity will arise that will change your life.",
    "Take risks and you will be rewarded.",
    "Good fortune will come to you in unexpected ways.",
    "Your hard work will pay off in the near future.",
    "A journey is in store for you, which will lead to new experiences.",
    "Be open to new possibilities and you will find happiness.",
    "Your creativity will flourish, bringing you joy and fulfillment.",
    "Trust your instincts; they will guide you in the right direction.",
    "Love and happiness will surround you in the days ahead.",
    "Embrace change and new opportunities will come your way.",
    "Your persistence and determination will lead you to success.",
    "A long-awaited dream will soon become a reality.",
    "Listen to your intuition, it holds the key to your future.",
    "Luck will be on your side in your upcoming endeavors.",
    "A cherished friendship will bring you great joy and support.",
    "Seize the day and make the most of every moment.",
    "Your positive attitude will attract abundance into your life.",
    "Traveling to new places will broaden your horizons.",
    "Believe in yourself and you can overcome any obstacle.",
    "Your kindness and generosity will be repaid tenfold.",
    "Success and recognition will come from your hard work.",
    "An unexpected surprise will bring you great happiness.",
    "Your financial situation will improve in the near future.",
    "A loved one will offer you valuable advice.",
    "New opportunities for personal growth will come your way.",
    "Your determination will lead you to achieve your goals.",
    "Positive changes are on the horizon for you.",
    "A lucky streak will bring you good fortune in all aspects of life.",
    "Your perseverance will lead to victory.",
    "Open your mind to new possibilities and you will find success.",
    "Your dreams hold the key to your future success.",
    "Inner peace and harmony will guide your path.",
    "A new beginning awaits you in the near future.",
    "Your talents and skills will be recognized and appreciated.",
    "Generosity and kindness will lead you to meaningful connections.",
    "The universe is conspiring to bring you joy and abundance.",
    "Wisdom and clarity will guide your decision-making.",
    "Love will find its way to your heart when you least expect it.",
    "A breakthrough moment will lead to a major transformation.",
    "The challenges you face will make you stronger and wiser.",
    "Opportunities for personal and professional growth are on the horizon.",
    "Your positive energy will attract positive outcomes in all areas of life."
};


    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(700, 410);
        frame.setTitle("Fortune Teller");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel background = new JLabel("", new ImageIcon("background.jpg"), JLabel.CENTER);
        background.setBounds(0, 0, 700, 410);
        frame.add(background);
        frame.setLayout(null);

        JLabel lab1 = new JLabel();
        lab1.setText("Name");
        lab1.setBounds(90, 15, 50, 15);
        background.add(lab1);

        JTextField tf1 = new JTextField();
        tf1.setBounds(190, 15, 90, 15);
        background.add(tf1);

        JLabel lab2 = new JLabel();
        lab2.setText("Date of Birth");
        lab2.setBounds(90, 35, 90, 10);
        background.add(lab2);

        JTextField tf2 = new JTextField();
        tf2.setBounds(190, 35, 90, 15);
        background.add(tf2);

        JTextArea ta = new JTextArea();
        ta.setBounds(10, 60, 660, 250);
        Font f = new Font("MV Boli", Font.ITALIC,21);
        ta.setFont(f);
        background.add(ta);
        ta.setOpaque(false);

        JButton okBtn = new JButton("Ok");
        okBtn.setBounds(270, 325, 80, 20);
        background.add(okBtn);

        JRadioButton clearRadioBtn = new JRadioButton("Clear");
        clearRadioBtn.setBounds(180, 300, 60, 20);
         
        background.add(clearRadioBtn);

        JRadioButton generateRadioBtn = new JRadioButton("Generate");
        generateRadioBtn.setBounds(385, 300, 80, 20);
        generateRadioBtn.setSelected(true); // 
       // generateRadioBtn.setBorder(border); 
        background.add(generateRadioBtn);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(clearRadioBtn);
        buttonGroup.add(generateRadioBtn);

        okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = tf1.getText();
                String dob = tf2.getText();

                if (clearRadioBtn.isSelected()) {
                    ta.setText(""); 
                } else if (generateRadioBtn.isSelected()) {
                    if (name.isEmpty() || dob.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "Please enter your name and date of birth.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        String fortune = generateRandomFortune();
                        String result = "Name: " + name + "\nDate of Birth: " + dob + "\n\n" + fortune;
                        ta.setText(result);
                    }
                }
            }
        });

        frame.setVisible(true);
    }

    private static String generateRandomFortune() {
        Random random = new Random();
        int index = random.nextInt(FORTUNES.length);
        return FORTUNES[index];
    }
}
