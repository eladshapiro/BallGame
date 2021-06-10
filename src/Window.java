import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Window extends JFrame {
    private Game game;

    public static void main(String[] args) {
        Window window = new Window();

    }

    public Window() {

        this.setBounds(Definitions.WINDOW_X_START, Definitions.WINDOW_Y_START, Definitions.WINDOW_WIDTH, Definitions.WINDOW_HEIGHT);
        this.setTitle("ball Game");
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.game=new Game();
        PlayerMovement playerMovement = new PlayerMovement(this.game.getPlayer());
        this.addKeyListener(playerMovement);
        mainGameLoop();




    }


    @Override
    public void paint(Graphics g) {
        g.setColor(Color.YELLOW); //background
        g.fillRect(Definitions.WINDOW_X_START, Definitions.WINDOW_Y_START, Definitions.WINDOW_WIDTH, Definitions.WINDOW_HEIGHT);
        this.game.paint(g);
        g.setColor(Color.BLACK);        //border
        g.fillRect(Definitions.WINDOW_X_BORDER_RIGHT, Definitions.WINDOW_Y_START, Definitions.BORDER_THICKNESS, Definitions.WINDOW_HEIGHT);
        g.fillRect(Definitions.WINDOW_X_START, Definitions.WINDOW_Y_BORDER_START, Definitions.WINDOW_WIDTH, Definitions.BORDER_THICKNESS);
        g.fillRect(Definitions.WINDOW_X_BORDER_LEFT, Definitions.WINDOW_Y_START, Definitions.BORDER_THICKNESS, Definitions.WINDOW_HEIGHT);
        g.setColor(Color.BLUE);
        g.setFont(new Font("david",Font.BOLD,Definitions.SCORE_SIZE));
        g.drawString("score:"+this.game.getScore(),Definitions.SCORE_X,Definitions.SCORE_Y);
        if(!this.game.isPlay()){
            g.setColor(Color.RED);
            g.setFont(new Font("david",Font.BOLD,Definitions.GAME_OVER_FONT_SIZE));
            g.drawString("Game over!",Definitions.GAME_OVER_X,Definitions.GAME_OVER_Y);

            g.setColor(Color.BLACK);
            g.setFont(new Font("david",Font.BOLD,Definitions.RESTART_FONT_SIZE));
            g.drawString("press enter to play again",Definitions.RESTART_X,Definitions.RESTART_Y);
            g.setColor(Color.BLUE);
            g.setFont(new Font("david",Font.BOLD,Definitions.SCORE_SIZE));
            g.drawString("score:"+this.game.getScore(),Definitions.SCORE_RESTART_X,Definitions.SCORE_RESTART_Y);

        }

    }


    public void mainGameLoop() {
        new Thread(() -> {
            while (this.game.isPlay()) {
                this.game.getBall().move();
                this.game.intersects(this.game.getBounds());
                if(this.game.finish()){
                    this.game.setPlay(false);

                }
                repaint();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            FinishGame finish = new FinishGame(this.game);
            this.addKeyListener(finish);
            mainGameLoop();
        }).start();
    }

    public Game getGame () {
        return game;
    }

    public void setGame (Game game){
        this.game = game;
    }

}

