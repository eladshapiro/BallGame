import javax.swing.*;
import java.awt.*;

public class Window extends JFrame
{
        public static void main(String[] args)
        {
            new Window();
        }

        public Window()
        {
            this.init();

        }

        private void init () {
            this.setVisible(true);
            this.setSize(Definitions.WINDOW_WIDTH, Definitions.WINDOW_HEIGHT);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLayout(null);
            this.setResizable(false);
            this.setLocationRelativeTo(null);
        }

        public void paint (Graphics graphics) {
            super.paint(graphics);
        }



    }


