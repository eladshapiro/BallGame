import javax.swing.*;
import java.awt.*;

public class Window extends JFrame
{
        public static void main(String[] args)
        {
            JFrame window=new JFrame();
            Game game=new Game();
            window.setBounds(Definitions.WINDOW_X_START,Definitions.WINDOW_Y_START,Definitions.WINDOW_WIDTH,Definitions.WINDOW_HEIGHT);
            window.setTitle("ball Game");
            window.setResizable(false);
            window.setVisible(true);
            window.setLocationRelativeTo(null);
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.add(game);
        }

    }


