import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {
    private int playerX;
    private int playerY;
    private int playerWidth;
    private int playerHeight;

    public Player() {
        this.playerX = Definitions.PLAYER_X;
        this.playerY = Definitions.PLAYER_Y;
        this.playerWidth = Definitions.LINE_WIDTH;
        this.playerHeight = Definitions.LINE_HEIGHT;
    }

    public int getPlayerX() {
        return playerX;
    }

    public void setPlayerX(int playerX) {
        this.playerX = playerX;
    }

    public int getPlayerY() {
        return playerY;
    }

    public void setPlayerY(int playerY) {
        this.playerY = playerY;
    }

    public int getPlayerWidth() {
        return playerWidth;
    }

    public void setPlayerWidth(int playerWidth) {
        this.playerWidth = playerWidth;
    }

    public int getPlayerHeight() {
        return playerHeight;
    }

    public void setPlayerHeight(int playerHeight) {
        this.playerHeight = playerHeight;
    }
    public void paint(Graphics graphics){
        graphics.setColor(Color.MAGENTA); //the players line
        graphics.fillRect(playerX,playerY,playerWidth,playerHeight);

    }
    public void moveRight()
    {
        playerX+=Definitions.PlAYER_LINE_MOVE;

    }
    public  void moveLeft()
    {
        playerX-=Definitions.PlAYER_LINE_MOVE;
    }

}
