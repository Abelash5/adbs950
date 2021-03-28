package game;

import org.jbox2d.common.Vec2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

/**
 * @author      Abelash Rangarajah abelash.rangarajah@city.ac.uk
 * @version     1.0
 * @since       26th March 2021
 */

public class NinjaController implements KeyListener {

    private Game game;

    private static final float WALKING_SPEED = 7;

    public NinjaController(Game game) {
        this.game = game;
    }

    /**
     * Key pressed
     * <p>
     * It is fired when a key is pressed that can be converted into a unicode character
     *
     * @param e Keyboard event is generated
     * @return When a key is pressed an object/ method is invoked
     */

    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * A key is pressed to invoke a method
     * <p>
     * The listener interface for receiving keyboard events (keystrokes). The ninja either walks left,right
     * or jumps depending on what key is pressed
     *
     * @param e Keyboard event is generated
     */

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A) {
            game.getLevel().getNinja().startWalking(-WALKING_SPEED);
        }
        else if (code == KeyEvent.VK_D) {
            game.getLevel().getNinja().startWalking(WALKING_SPEED);
        }
        else if (code == KeyEvent.VK_W) {
            game.getLevel().getNinja().jump(10);
        }
        else if (code == KeyEvent.VK_S){
            try {
                GameSaverLoader.save(game.getLevel(), "data/save.txt");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        else if (code == KeyEvent.VK_L){
            try {
                GameLevel level = GameSaverLoader.load(game,"data/save.txt");
                game.setLevel(level);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        else if (code == KeyEvent.VK_1){
            game.getLevel().getNinja().setActiveWeapon(0);
        }
        else if (code == KeyEvent.VK_2){
            game.getLevel().getNinja().setActiveWeapon(1);
        }
        else if (code == KeyEvent.VK_3){
            game.getLevel().getNinja().setActiveWeapon(2);
        }
    }

    /**
     * The keyReleased() function is called once every time a key is released.
     * <p>
     * The key that was released will be stored in the key variable so that it returns a method so the ninja will
     * stop walking once either of keys "a" or "d" is released. The methods includes for the ninja to stop sliding by
     * setting the linear velocity to 0.
     *
     * @param  e Keyboard event is generated
     */

        @Override
        public void keyReleased(KeyEvent e) {
            int code = e.getKeyCode();
            if (code == KeyEvent.VK_A) {
                game.getLevel().getNinja().stopWalking();
                game.getLevel().getNinja().setLinearVelocity(new Vec2(0,0));
            } else if (code == KeyEvent.VK_D) {
                game.getLevel().getNinja().stopWalking();
                game.getLevel().getNinja().setLinearVelocity(new Vec2(0,0));
            }
        }

    /**
     * Updates the ninja
     * <p>
     * Updates the ninja so that it can move to the next level
     *
     * @param game The ninja is updated in the entire game
     */


    // Updates the ninja when moving to different levels.
    public void updateNinja(Game game){
        this.game = game;
    }

}
