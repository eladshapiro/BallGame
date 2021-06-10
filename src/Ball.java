import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Ball extends JPanel {
    private int ballPosX;
    private int ballPosY;
    private int ballWidth;
    private int ballHeight;
    private int ballXDir;
    private int ballYDir;


    public Ball() {
        this.ballPosX = Definitions.BALL_POS_X;
        this.ballPosY = Definitions.BALL_POS_Y;
        this.ballWidth = Definitions.BALL_WIDTH;
        this.ballHeight = Definitions.BALL_HEIGHT;
        this.ballXDir=Definitions.BALL_X_DIR;
        this.ballYDir=Definitions.BALL_Y_DIR;
    }

    public int getBallPosX() {
        return ballPosX;
    }

    public void setBallPosX(int ballPosX) {
        this.ballPosX = ballPosX;
    }

    public int getBallPosY() {
        return ballPosY;
    }

    public void setBallPosY(int ballPosY) {
        this.ballPosY = ballPosY;
    }

    public int getBallWidth() {
        return ballWidth;
    }

    public void setBallWidth(int ballWidth) {
        this.ballWidth = ballWidth;
    }

    public int getBallHeight() {
        return ballHeight;
    }

    public void setBallHeight(int ballHeight) {
        this.ballHeight = ballHeight;
    }

    public int getBallXDir() {
        return ballXDir;
    }

    public void setBallXDir(int ballXDir) {
        this.ballXDir = ballXDir;
    }

    public int getBallYDir() {
        return ballYDir;
    }

    public void setBallYDir(int ballYDir) {
        this.ballYDir = ballYDir;
    }

    public void paint(Graphics graphics){
        graphics.setColor(Color.BLACK); // ball
        graphics.fillOval(this.ballPosX,this.ballPosY,this.ballWidth,this.ballHeight);
    }
    public void move()
    {
        this.ballPosX-=ballXDir;
        this.ballPosY-=ballYDir;

        if(ballPosX<Definitions.WINDOW_X_BORDER_RIGHT)
        {
            ballXDir=-ballXDir;  //replace the dirction
        }

        if(ballPosY<Definitions.WINDOW_Y_BORDER_START)
        {
            ballYDir=-ballYDir;  //replace the dirction
        }

        if(ballPosX>Definitions.WINDOW_X_BORDER_LEFT-this.ballWidth)
        {
            ballXDir=-ballXDir;  //replace the dirction
        }

    }

}




