import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JPanel implements KeyListener, ActionListener
{
  private boolean play=false;
  private int score=0;
  private int totalBricks=21;
  private Timer time;
  private int delay;
  private int playerX=Definitions.PLAYER_X;
  private int ballPosX=Definitions.BALL_POS_X;
  private int bolPosY=Definitions.BALL_POS_Y;
  private int ballXdir=-Definitions.BALL_X_DIR;
  private int ballYdir=-Definitions.BALL_Y_DIR;

public Game()
{
  addKeyListener(this);
  setFocusable(true);
  setFocusTraversalKeys(false);
  time=new Timer(delay,this);
  time.start();
}
public void paint(Graphics graphics)
{
  graphics.setColor(Color.BLACK); //background
  graphics.fillRect(1,1,692,592);

  graphics.setColor(Color.RED);
  graphics.fillRect(0,0,3,592);
  graphics.fillRect(0,0,692,3);
  graphics.fillRect(691,0,3,592);


}

  private void setFocusTraversalKeys(boolean b) {
  }

  @Override
  public void actionPerformed(ActionEvent e) {

  }

  @Override
  public void keyTyped(KeyEvent e) {

  }

  @Override
  public void keyPressed(KeyEvent e) {

  }

  @Override
  public void keyReleased(KeyEvent e) {

  }
}
