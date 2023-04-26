import javax.swing.*;
import java.awt.*;


public class ConnectFourUI extends JPanel implements Runnable {
    final int diskSlotSize = 128;
    final int boardRowSlots = 6;
    final int boardColumnSlots = 7;
    final int diskSize = 128;
    final int SCREEN_WIDTH = diskSlotSize * boardColumnSlots;
    final int SCREEN_HEIGHT = diskSlotSize * boardRowSlots + 128;
    int diskY = -128;
    int diskX = 0;
    int diskY1 = -128;
    int yDiskY = -128;
    int diskSpeed = 10;
    int select;
    Thread thread;
    ConnectFourUI() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.BLUE);
    }

    public void startThread() {
        thread = new Thread(this);
        thread.start();
    }
    @Override
    public void run() {
        while (thread != null) {
            redraw();
            repaint();
            // Pause the game loop for 16 milliseconds to regulate the frame rate
            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void redraw() { 
        if (select == 1) {
            diskY += diskSpeed;
        } else if (select == 2) {
            diskY1 += diskSpeed;
        } else if (select == 3) {
            yDiskY += diskSpeed;
        }
        if (diskY > SCREEN_HEIGHT - 128 * 2) {
            diskY = SCREEN_HEIGHT - 128 * 2;
        } else if (diskY1 > SCREEN_HEIGHT - 128 * 2) {
            diskY1 = SCREEN_HEIGHT - 128 * 2;
        }


    }



    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(Color.RED);
        for (int i = 0; i < SCREEN_WIDTH + 128; i += 128) {
            for (int j = 0; j < SCREEN_HEIGHT; j += 128) {
                g2D.setColor(Color.WHITE);
                g2D.fillOval(i, j, diskSize, diskSize);
            }
        }
        g2D.fillOval(diskX, diskY, diskSize, diskSize);
        g2D.fillOval(diskX + 128, diskY1 , diskSize, diskSize );
        g2D.setColor(Color.YELLOW);
        g2D.fillOval(diskX, yDiskY, diskSize, diskSize);

        g2D.dispose();
    }


}
