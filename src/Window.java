import javax.swing.*;
import java.awt.*;

public class Window extends JFrame
{
        public static void main(String[] args)
        {
            JFrame window=new JFrame();
            Game game=new Game();
            window.setBounds(10,10,700,600);
            window.setTitle("ball Game");
            window.setResizable(false);
            window.setVisible(true);
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.add(game);
        }

    }


