import javax.swing.*;
import java.util.Random;
import java.awt.event.*;

public class NumberGuessingGame implements ActionListener {
    JFrame f;
    JRadioButton yes, no;
    JButton b;
    int randomNumber, guessedNumber;
    boolean play = true;

    NumberGuessingGame() {
        Random random = new Random();
        this.randomNumber = random.nextInt(100) + 1;
        System.out.println("The random number generated is :" + randomNumber);
        guessNum();
    }

    public void userInput() {
        f = new JFrame();
        try {
            guessedNumber = Integer.parseInt(JOptionPane.showInputDialog(f, "Guess the number between 1 to 100"));
            System.out.println(guessedNumber);
        } catch (Exception e) {
            System.exit(0);
        }
    }

    public void guessNum() {
        int trail = 0;
        while (play == true) {
            for (int i = 0; i < 10; i++) {
                userInput();
                trail++;
                if (randomNumber == guessedNumber) {
                    System.out.println("User won the game");
                    break;
                } else if (randomNumber > guessedNumber) {
                    if (randomNumber - guessedNumber > 10) {
                        JOptionPane.showMessageDialog(f, "Your guess is too low");
                    } else
                        JOptionPane.showMessageDialog(f, "Your guess is a little low");
                } else if (randomNumber < guessedNumber) {
                    if (-randomNumber + guessedNumber > 10) {
                        JOptionPane.showMessageDialog(f, "Your guess is too high");
                    } else
                        JOptionPane.showMessageDialog(f, "Your guess is a little high");
                }
            }
            if (trail < 10) {
                JOptionPane.showMessageDialog(f,
                        "Congratulations user won the game\n\nYour have guessed the number in  "
                                + trail + " trails\n You won " + (10 - trail + 1) * 10 + " points");

            } else {
                JOptionPane.showMessageDialog(f, "The system won the game");
            }
            playAgain();
            break;
            // System.out.println(playAgain());

        }

    }

    public void playAgain() {
        JLabel label = new JLabel("Do you want to play again");
        f.add(label);
        label.setBounds(50, 50, 600, 30);
        yes = new JRadioButton("Yes");
        yes.setBounds(100, 100, 100, 30);
        no = new JRadioButton("No");
        no.setBounds(100, 150, 100, 30);
        ButtonGroup bg = new ButtonGroup();
        bg.add(yes);
        bg.add(no);
        b = new JButton("click");
        b.setBounds(100, 200, 80, 30);
        b.addActionListener(this);
        f.add(yes);
        f.add(no);
        f.add(b);
        f.setSize(300, 300);
        f.setBounds(750, 350, 300, 300);
        f.setLayout(null);
        f.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (yes.isSelected()) {
            f.dispose();
            new NumberGuessingGame();
        }
        if (no.isSelected()) {
            f.dispose();
            JOptionPane.showMessageDialog(f, "Thank you");
        }
    }

    public static void main(String[] args) {
        new NumberGuessingGame();
    }
}
