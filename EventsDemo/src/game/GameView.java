package game;

import city.cs.engine.UserView;
import city.cs.engine.World;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;

/**
 * @author      Abelash Rangarajah abelash.rangarajah@city.ac.uk
 * @version     1.0
 * @since       26th March 2021
 */

public class GameView extends UserView {

    public Image back;

    Game game;

    /**
     * View the game
     * <p>
     * Views the gameplay. E.g. adds the bodies or paints the background
     *
     * @param w  Current world
     * @param game Where the world is created.
     * @param width Length for the gameplay
     * @param height Height for the gameplay
     */

    public GameView(World w ,Game game, int width, int height) {
        super(w, width, height);
        this.game = game;
    }

    /**
     * Paints the background
     * <p>
     * Paints the background with the image
     *
     * @param background - Background of the game
     */

    public void setBack(Image background){
        this.back = background;
    }

    /**
     * Paints the background
     * <p>
     * Adds an image to the background of the game.
     *
     * @param g  Current world
     */

    @Override
    protected void paintBackground(Graphics2D g) {

        g.drawImage(back, 0, 0, this);
    }

    /**
     * Text added to the world
     * <p>
     * Text is added to the game but doesnt interfere with it. It overlays
     * the world.
     *
     * @param g  Current world
     */

    @Override
    protected void paintForeground(Graphics2D g) {
        g.setFont(new Font("Arial",Font.BOLD,15));
        g.setColor(Color.WHITE);
        g.drawString("Number of Bananas Ate: " + game.getLevel().getNinja().getBananaCount(), 250, 100);
        g.drawString("Energy Level: " + game.getLevel().getNinja().getEnergyCount(), 500, 100);
        g.drawString("Level: " + game.getLevel().getLevelName(),100,100);
    }

    /**
     * Updates banana encounter
     * <p>
     * Updates the banana pickup by the ninja when a new level is created
     *
     * @param game Then entire game
     */

    public void updateBanana(Game game){this.game = game;}
}
