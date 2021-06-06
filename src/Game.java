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
 // private int score=Definitions.START_SCORE;
 // private int totalBricks=Definitions.TOTAL_BRICKS;
  private Timer time;
  private int delay=Definitions.DELAY;
  private int playerX=Definitions.PLAYER_X;
  private int ballPosX=Definitions.BALL_POS_X;
  private int ballposY=Definitions.BALL_POS_Y;
  private int ballXdir=-Definitions.BALL_X_DIR;
  private int ballYdir=-Definitions.BALL_Y_DIR;
  private  int score=Definitions.START_SCORE;

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
  graphics.setColor(Color.YELLOW); //background
  graphics.fillRect(Definitions.WINDOW_X_START,Definitions.WINDOW_Y_START,Definitions.WINDOW_WIDTH,Definitions.WINDOW_HEIGHT);

  graphics.setColor(Color.BLACK);        //border
  graphics.fillRect(Definitions.WINDOW_X_START,Definitions.WINDOW_Y_START,Definitions.BORDER_THICKNESS,Definitions.WINDOW_HEIGHT);
  graphics.fillRect(Definitions.WINDOW_X_START,Definitions.WINDOW_Y_START,Definitions.WINDOW_WIDTH,Definitions.BORDER_THICKNESS);
  graphics.fillRect(Definitions.WINDOW_WIDTH-21,Definitions.WINDOW_Y_START,Definitions.BORDER_THICKNESS,Definitions.WINDOW_HEIGHT);

  graphics.setColor(Color.MAGENTA); //the players line
  graphics.fillRect(playerX,Definitions.PLAYER_Y,Definitions.LINE_WIDTH,Definitions.LINE_HEIGHT);

  graphics.setColor(Color.BLACK); // ball
  graphics.fillOval(ballPosX,ballposY,Definitions.BALL_WIDTH,Definitions.BALL_HEIGHT);

  graphics.setColor(Color.BLUE);
  graphics.setFont(new Font("david",Font.BOLD,Definitions.SCORE_SIZE));
  graphics.drawString("score:"+score,Definitions.SCORE_X,Definitions.SCORE_Y);


  if (ballposY>Definitions.WINDOW_HEIGHT)
  {
    play=false;
    ballYdir=Definitions.STOP_BALL_Y;
    ballXdir=Definitions.STOP_BALL_X;
    graphics.setColor(Color.RED);
    graphics.setFont(new Font("david",Font.BOLD,Definitions.GAME_OVER_FONT_SIZE));
    graphics.drawString("Game over!",Definitions.GAME_OVER_X,Definitions.GAME_OVER_Y);

    graphics.setColor(Color.BLACK);
    graphics.setFont(new Font("david",Font.BOLD,Definitions.RESTART_FONT_SIZE));
    graphics.drawString("press enter to play again",Definitions.RESTART_X,Definitions.RESTART_Y);
    graphics.setColor(Color.BLUE);
    graphics.setFont(new Font("david",Font.BOLD,Definitions.SCORE_SIZE));
    graphics.drawString("score:"+score,Definitions.SCORE_RESTART_X,Definitions.SCORE_RESTART_Y);

  }
  graphics.dispose();
}

  private void setFocusTraversalKeys(boolean b) {
  }
  public void actionPerformed(ActionEvent e)
  {
time.start();
if (play)
{
  if (new Rectangle(ballPosX, ballposY, Definitions.BALL_WIDTH,Definitions.BALL_HEIGHT).intersects(new Rectangle(playerX,Definitions.PLAYER_Y,Definitions.LINE_WIDTH,Definitions.LINE_HEIGHT))) // bounce of the player line
  {
ballYdir=-ballYdir;
score++;
  }
  ballPosX+=ballXdir;
  ballposY+=ballYdir;

  if(ballPosX<Definitions.WINDOW_X_START)
  {
    ballXdir=-ballXdir;  //replace the dirction
  }

  if(ballposY<Definitions.WINDOW_Y_START)
  {
    ballYdir=-ballYdir;  //replace the dirction
  }

  if(ballPosX>Definitions.WINDOW_WIDTH-Definitions.BORDER_BUG)
  {
    ballXdir=-ballXdir;  //replace the dirction
  }

}
repaint();
  }
  public void keyTyped(KeyEvent e)
  {
  }

  public void keyPressed(KeyEvent e)
  {
    if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
      if (playerX >= 600) {
        playerX = 600;
      } else {
        moveRight();
      }

    }
    if (e.getKeyCode() == KeyEvent.VK_LEFT) {
      if (playerX < 0) {
        playerX = 0;
      } else {
        moveLeft();
      }
    }

      if (e.getKeyCode() == KeyEvent.VK_ENTER)
      {
        if (!play)
        {
          ballPosX=Definitions.BALL_POS_X;
          ballposY=Definitions.BALL_POS_Y;
          ballXdir=-Definitions.BALL_X_DIR;
          ballYdir=-Definitions.BALL_Y_DIR;
          playerX=Definitions.PLAYER_X;
          score=Definitions.START_SCORE;

          repaint();
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
    playerX-=Definitions.PlAYER_LINE_MOVE;
  }
  public void keyReleased(KeyEvent e)
  {
  }
}
