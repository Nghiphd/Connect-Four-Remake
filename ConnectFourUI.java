import javax.swing.*;
import java.awt.*;

public class ConnectFourUI extends JPanel implements Runnable {
    final int diskSlotSize = 128;
    final int boardRowSlots = 6;
    final int boardColumnSlots = 7;
    final int diskSize = 128;
    final int SCREEN_WIDTH = diskSlotSize * boardColumnSlots;
    final int SCREEN_HEIGHT = diskSlotSize * boardRowSlots + 128;
    int[] diskY = { -128, -128, -128, -128, -128, -128, -128 };
    int[] diskX = { 0, 128, 256, 384, 512, 640, 768 };
    int diskSpeed = 60;
    int select;
    boolean isYellowTurn;
    boolean isRedTurn;


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
        selectDiskPosition();
        collisionDisk();
    }

    private void collisionDisk() {
        if (diskY[0] > SCREEN_HEIGHT - diskSize * 2) {
            diskY[0] = SCREEN_HEIGHT - diskSize * 2;
        } else if (diskY[1] > SCREEN_HEIGHT - 128 * 2) {
            diskY[1] = SCREEN_HEIGHT - diskSize * 2;
        } else if (diskY[2] > SCREEN_HEIGHT - diskSize * 2) {
            diskY[2] = SCREEN_HEIGHT - diskSize * 2;
        } else if (diskY[3] > SCREEN_HEIGHT - diskSize * 2) {
            diskY[3] = SCREEN_HEIGHT - diskSize * 2;
        } else if (diskY[4] > SCREEN_HEIGHT - diskSize * 2) {
            diskY[4] = SCREEN_HEIGHT - diskSize * 2;
        } else if (diskY[5] > SCREEN_HEIGHT - diskSize * 2) {
            diskY[5] = SCREEN_HEIGHT - diskSize * 2;
        } else if (diskY[6] > SCREEN_HEIGHT - diskSize * 2) {
            diskY[6] = SCREEN_HEIGHT - diskSize * 2;
        }
    }

    private void selectDiskPosition() {
        if (isYellowTurn == true) {
            if (select == 1) {
                diskY[0] += diskSpeed;
            } else if (select == 2) {
                diskY[1] += diskSpeed;
            } else if (select == 3) {
                diskY[2] += diskSpeed;
            } else if (select == 4) {
                diskY[3] += diskSpeed;
            } else if (select == 5) {
                diskY[4] += diskSpeed;
            } else if (select == 6) {
                diskY[5] += diskSpeed;
            } else if (select == 7) {
                diskY[6] += diskSpeed;
            }
        }
        if (isRedTurn) {
            if (select == 1) {
                diskY[0] += diskSpeed;
            } else if (select == 2) {
                diskY[1] += diskSpeed;
            } else if (select == 3) {
                diskY[2] += diskSpeed;
            } else if (select == 4) {
                diskY[3] += diskSpeed;
            } else if (select == 5) {
                diskY[4] += diskSpeed;
            } else if (select == 6) {
                diskY[5] += diskSpeed;
            } else if (select == 7) {
                diskY[6] += diskSpeed;
            }
        }
            
        
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(Color.RED);
        for (int i = 0; i < SCREEN_WIDTH + diskSlotSize; i += diskSlotSize) {
            for (int j = 0; j < SCREEN_HEIGHT; j += diskSlotSize) {
                g2D.setColor(Color.WHITE);
                g2D.fillOval(i, j, diskSize, diskSize);
            }
        }
        g2D.setColor(Color.RED);
        g2D.fillOval(diskX[0], diskY[0], diskSize, diskSize);
        g2D.fillOval(diskX[1], diskY[1], diskSize, diskSize);
        g2D.fillOval(diskX[2], diskY[2], diskSize, diskSize);
        g2D.fillOval(diskX[3], diskY[3], diskSize, diskSize);
        g2D.fillOval(diskX[4], diskY[4], diskSize, diskSize);
        g2D.fillOval(diskX[5], diskY[5], diskSize, diskSize);
        g2D.fillOval(diskX[6], diskY[6], diskSize, diskSize);

        g2D.setColor(Color.YELLOW);
        g2D.fillOval(diskX[7], diskY[0], diskSize, diskSize);
        g2D.fillOval(diskX[8], diskY[1], diskSize, diskSize);
        g2D.fillOval(diskX[9], diskY[2], diskSize, diskSize);
        g2D.fillOval(diskX[10], diskY[3], diskSize, diskSize);
        g2D.fillOval(diskX[11], diskY[4], diskSize, diskSize);
        g2D.fillOval(diskX[12], diskY[5], diskSize, diskSize);
        g2D.fillOval(diskX[13], diskY[6], diskSize, diskSize);
        g2D.dispose();
    }

}
