import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class PlayerMovement implements KeyListener {
    private Player player;

    public PlayerMovement (Player player) {
        this.player = player;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (this.player.getPlayerX() >=Definitions.WINDOW_X_BORDER_LEFT-this.player.getPlayerWidth()) {
                this.player.setPlayerX(Definitions.WINDOW_HEIGHT);
            } else {
                this.player.moveRight();
            }

        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (this.player.getPlayerX() < Definitions.WINDOW_X_BORDER_RIGHT) {
                this.player.setPlayerX(Definitions.WINDOW_X_START);
            } else {
                this.player.moveLeft();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
