import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.nio.CharBuffer;

public class Game extends JPanel implements KeyListener, ActionListener
{
  private boolean play=false;
  private int score=0;
  private int totalBricks=21;
  private Timer time;
  private int delay;
  private int playerX=Definitions.PLAYER_X;
  private int ballPosX=Definitions.BALL_POS_X;
  private int ballposY=Definitions.BALL_POS_Y;
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
  graphics.setColor(Color.PINK); //background
  graphics.fillRect(1,1,692,592);

  graphics.setColor(Color.RED);        //border
  graphics.fillRect(0,0,3,592);
  graphics.fillRect(0,0,692,3);
  graphics.fillRect(691,0,3,592);

  graphics.setColor(Color.MAGENTA); //the players line
  graphics.fillRect(playerX,550,100,8);

  graphics.setColor(Color.WHITE); // ball
  graphics.fillOval(ballPosX,ballposY,20,20);

}

  private void setFocusTraversalKeys(boolean b) {
  }
  public void actionPerformed(ActionEvent e)
  {
time.start();
if (play)
{
  if (new Rectangle(ballPosX, ballposY, 20,20).intersects(new Rectangle(playerX,550,100,8)))
  {
ballYdir=-ballYdir;
  }
  ballposY+=ballXdir;
  ballposY+=ballYdir;

  if(ballPosX<0)
  {
    ballXdir=-ballXdir;  //replace the dirction
  }

  if(ballposY<0)
  {
    ballYdir=-ballYdir;  //replace the dirction
  }

  if(ballPosX>670)
  {
    ballXdir=-ballXdir;  //replace the dirction
  }
}
repaint();
  }
  public void keyTyped(KeyEvent e) {

  }

  public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
      if (playerX >= 600) {
        playerX = 600;
      } else {
        moveRight();
      }

    }
    if (e.getKeyCode() == KeyEvent.VK_LEFT) {
      if (playerX < 600) {
        playerX = 10;
      } else {
        moveLeft();
      }

    }
  }
  public void moveRight()
  {
    play=true;
    playerX+=Definitions.PlAYER_LINE_MOVE;

  }
  public  void moveLeft()
  {
    play=true;
    playerX+=Definitions.PlAYER_LINE_MOVE;
  }

  @Override
  public void keyReleased(KeyEvent e) {

  }
}
