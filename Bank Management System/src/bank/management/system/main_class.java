package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//public class MainClass extends JFrame implements ActionListener
public class main_class extends JFrame implements ActionListener{
    JButton b1, b2, b3, b4, b5, b6, b7;
    String pin;

    main_class(String pin) {
        this.pin = pin;

        // Setting up the background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1550, 830);
        add(l3);

        // Label for instruction
        JLabel label = new JLabel("Please Select Your Transaction");
        label.setBounds(430, 180, 700, 35);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("System", Font.BOLD, 28));
        l3.add(label);

        // Button setup
        b1 = createButton("DEPOSIT", 410, 274, l3);
        b2 = createButton("CASH WITHDRAWAL", 700, 274, l3);
        b3 = createButton("FAST CASH", 410, 318, l3);
        b4 = createButton("MINI STATEMENT", 700, 318, l3);
        b5 = createButton("PIN CHANGE", 410, 362, l3);
        b6 = createButton("BALANCE ENQUIRY", 700, 362, l3);
        b7 = createButton("EXIT", 700, 406, l3);

        setLayout(null);
        setSize(1550, 1080);
        setLocation(0, 0);
        setVisible(true);
    }

    // Helper method for button creation
    private JButton createButton(String text, int x, int y, JLabel parent) {
        JButton button = new JButton(text);
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(65, 125, 128));
        button.setBounds(x, y, 150, 35);
        button.addActionListener(this);
        parent.add(button);
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            new Deposit(pin);
            setVisible(false);
        } else if (e.getSource() == b7) {
            System.exit(0);
        } else if (e.getSource() == b2) {
            new Withdrawl(pin);  // Corrected typo
            setVisible(false);
        } else if (e.getSource() == b6) {
            new BalanceEnquriy(pin);  // Corrected class name
            setVisible(false);
        } else if (e.getSource() == b3) {
            new FastCash(pin);
            setVisible(false);
        } else if (e.getSource() == b5) {
            new Pin(pin);
            setVisible(false);
        } else if (e.getSource() == b4) {
            new mini(pin);  // Corrected class name
        }
    }

    public static void main(String[] args) {
        new main_class("");
    }
}
