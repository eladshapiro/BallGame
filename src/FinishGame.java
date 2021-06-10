import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class FinishGame implements KeyListener {
    private Game game;

    public FinishGame(Game game) {
        this.game = game;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            this.game.getBall().setBallPosX(Definitions.BALL_POS_X);
            this.game.getBall().setBallPosY(Definitions.BALL_POS_Y);
            this.game.getBall().setBallXDir(Definitions.BALL_X_DIR);
            this.game.getBall().setBallYDir(Definitions.BALL_Y_DIR);
            this.game.getPlayer().setPlayerX(Definitions.PLAYER_X);
            this.game.getPlayer().setPlayerWidth(Definitions.LINE_WIDTH);
            this.game.setScore(Definitions.START_SCORE);
            this.game.setGameSpeed(Definitions.START_GAME_SPEED);
            this.game.setPlay(true);
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
