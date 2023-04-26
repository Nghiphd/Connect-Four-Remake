import javax.swing.*;
import java.awt.*;

public class Window {
    public static void main(String[] args) {
        int buttonPositionX = 0;
        int buttonPositionY = 7 * 128 - 128;
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("Connect4");
        ConnectFourUI connectFourUI = new ConnectFourUI();
        Button button0 = new Button("1");
        Button button1 = new Button("2");
        Button button2 = new Button("3");
        Button button3 = new Button("4");
        Button button4 = new Button("5");
        Button button5 = new Button("6");
        Button button6 = new Button("7");
        button0.setBounds(buttonPositionX, buttonPositionY, 128, 128);
        button1.setBounds(buttonPositionX + 128, buttonPositionY, 128, 128);
        button2.setBounds(buttonPositionX + 128 * 2, buttonPositionY, 128, 128);
        button3.setBounds(buttonPositionX + 128 * 3, buttonPositionY, 128, 128);
        button4.setBounds(buttonPositionX + 128 * 4, buttonPositionY, 128, 128);
        button5.setBounds(buttonPositionX + 128 * 5, buttonPositionY, 128, 128);
        button6.setBounds(buttonPositionX + 128 * 6, buttonPositionY, 128, 128);
        frame.add(button0);
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);
        frame.add(button5);
        frame.add(button6);
        frame.add(connectFourUI);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        connectFourUI.startThread();
        button0.addActionListener(e -> connectFourUI.select = 1);
        button1.addActionListener(e -> connectFourUI.select = 2);
        button2.addActionListener(e -> connectFourUI.select = 3);
        button3.addActionListener(e -> connectFourUI.select = 4);
        button4.addActionListener(e -> connectFourUI.select = 5);
        button5.addActionListener(e -> connectFourUI.select = 6);
        button6.addActionListener(e -> connectFourUI.select = 7);

    }


}
