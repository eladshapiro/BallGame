import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JPanel  {
  private Ball ball;
  private Player player;
  private static int score;
  private boolean play;
  private int gameSpeed;

  public Game() {
    this.ball = new Ball();
    this.player=new Player();
    score=Definitions.START_SCORE;
    play=true;
    gameSpeed=Definitions.START_GAME_SPEED;

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

  public int getGameSpeed() {
    return gameSpeed;
  }

  public void setGameSpeed(int gameSpeed) {
    this.gameSpeed = gameSpeed;
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
      if(score%Definitions.NEXT_LEVEL==0){
        gameSpeed--;                                   //the speed is faster, and the player is smaller
        this.player.setPlayerWidth(this.player.getPlayerWidth()-1);
      }

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


}



