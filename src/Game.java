import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JPanel implements KeyListener  {
  private Ball ball;
  private Player player;
  private static int score;
  private boolean play;

  public Game() {
    this.ball = new Ball();
    this.player=new Player();
    score=Definitions.START_SCORE;
    play=true;

  }

  public boolean isPlay() {
    return play;
  }

  public void setPlay(boolean play) {
    this.play = play;
  }

  public Ball getBall() {
    return ball;
  }

  public void setBall(Ball ball) {
    this.ball = ball;
  }

  public Player getPlayer() {
    return player;
  }

  public void setPlayer(Player player) {
    this.player = player;
  }

  public static int getScore() {
    return score;
  }

  public static void setScore(int score) {
    Game.score = score;
  }

  public void paint(Graphics graphics){
    ball.paint(graphics);
    player.paint(graphics);
  }
  public void intersects(Rectangle rectangle){
    if (new Rectangle(this.ball.getBallPosX(),this.ball.getBallPosY(),this.ball.getBallWidth(),this.ball.getBallHeight()).intersects(new Rectangle(this.player.getPlayerX(),
            this.player.getPlayerY(),this.player.getPlayerWidth(),this.player.getPlayerHeight())) )
    {
      this.ball.setBallYDir(-this.ball.getBallYDir());
      score++;

    }


  }
  public boolean finish(){
    if (this.ball.getBallPosY()>Definitions.WINDOW_HEIGHT)
    {
      this.ball.setBallPosY(Definitions.STOP_BALL_Y);
      this.ball.setBallPosX(Definitions.STOP_BALL_X);
      return true;

    }
    return false;

  }

  @Override
  public void keyTyped(KeyEvent e) {

  }

  @Override
  public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_ENTER)
    {

    }
  }

  @Override
  public void keyReleased(KeyEvent e) {

  }


}



