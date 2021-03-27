package game;

import city.cs.engine.DebugViewer;
import city.cs.engine.SoundClip;
import city.cs.engine.WorldView;
import game.Weapons.ShootController;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

import java.awt.*;
import java.io.IOException;
import java.util.logging.Level;

import static game.NinjaController.*;

/**
 * A world with some bodies.
 */
public class Game {

    /** The World in which the bodies move and interact. */
    private GameLevel level;

    /** A graphical display of the world (a specialised JPanel). */
    private GameView view;

    private NinjaController controller;

    private SoundClip gameMusic;

    private ShootController shootController;


    /** Initialise a new Game. */
    public Game() {

        level = new Level1(this);
        level.populate(this);

        try {
            gameMusic = new SoundClip("data/GameMusic.wav");   // Open an audio input stream
            gameMusic.loop();  // Set it to continous playback (looping)
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }

        // make a view
        view = new GameView(level, level.getNinja(), 1000, 600);
        view.setZoom(20);
        view.setBack(level.paintBackground());

        shootController = new ShootController(view, level.getGame());
        ShootController sc = new ShootController(view, level.getGame());
        view.addMouseListener(sc);
        view.addMouseMotionListener(sc);

        // uncomment this to draw a 1-metre grid over the view
        // view.setGridResolution(1);

        // add some mouse actions
        // add this to the view, so coordinates are relative to the view

        controller = new NinjaController(level.getGame());
        view.addKeyListener(controller);

        view.addMouseListener(new GiveFocus(view));

        //world.addStepListener(new Tracker(view, world.getStudent()));

        // add the view to a frame (Java top level window)
        final JFrame frame = new JFrame("Basic world");
        frame.add(view);

        ControlPanel controlPanel = new ControlPanel(this);
        frame.add(controlPanel.getMainPanel(),BorderLayout.WEST);

        // enable the frame to quit the application
        // when the x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // don't let the frame be resized
        frame.setResizable(false);
        // size the frame to fit the world view
        frame.pack();
        // finally, make the frame visible
        frame.setVisible(true);

        // uncomment this to make a debugging view
        //JFrame debugView = new DebugViewer(level, 1000, 600);

        // start our game world simulation!
        level.start();
    }

    public void pause(){
        level.stop();
        gameMusic.pause();
    }

    public void resume() {
        level.start();
        gameMusic.resume();
    }

    public void restart(){
        level.stop();
        level = new Level1(this);
        level.populate(this);
        view.setWorld(level);
        view.setZoom(20);
        view.setBack(level.paintBackground());
        controller.updateNinja(level.getGame());
        shootController.updateShoot(level.getGame());
        level.start();
        gameMusic.play();
    }

    public void level1(){
        level.stop();
        level = new Level1(this);
        level.populate(this);
        view.setWorld(level);
        view.setZoom(20);
        view.setBack(level.paintBackground());
        controller.updateNinja(level.getGame());
        shootController.updateShoot(level.getGame());
        level.start();
    }

    public void level2(){
        level.stop();
        level = new Level2(this);
        level.populate(this);
        view.setWorld(level);
        view.setZoom(20);
        view.setBack(level.paintBackground());
        controller.updateNinja(level.getGame());
        shootController.updateShoot(level.getGame());
        level.start();
    }

    public void level3(){
        level.stop();
        level = new Level3(this);
        level.populate(this);
        view.setWorld(level);
        view.setZoom(20);
        view.setBack(level.paintBackground());
        controller.updateNinja(level.getGame());
        shootController.updateShoot(level.getGame());
        level.start();
    }

    public void setLevel(GameLevel level){
        // stop the current level
        this.level.stop();
        // level now refers to the new level
        this.level = level;
        // change the view to look into new level
        view.setWorld(this.level);
        // zoom the view
        view.setZoom(20);
        // add background to the world
        view.setBack(this.level.paintBackground());
        // update the banana count score
        view.updateBanana(this.level.getNinja());
        // change the controller to control the ninja in the new world
        controller.updateNinja(this.level.getGame());
        // updates the controller so that the ninja can shoot in the new world
        shootController.updateShoot(level.getGame());
        // start the simulation in the lew level
        this.level.start();
    }

    public void goToNextLevel(){

        if (level instanceof Level1){
            // stop the current level
            level.stop();
            // level now refers to the new level
            level = new Level2(this);
            level.populate(this);
            // change the view to look into new level
            view.setWorld(level);
            // zoom the view
            view.setZoom(20);
            // add background to the world
            view.setBack(level.paintBackground());
            // update the banana count score
            view.updateBanana(level.getNinja());
            // change the controller to control the ninja in the new world
            controller.updateNinja(level.getGame());
            // updates the controller so that the ninja can shoot in the new world
            shootController.updateShoot(level.getGame());
            // start the simulation in the lew level
            level.start();
        }
        else if (level instanceof Level2) {
            level.stop();
            level = new Level3(this);
            level.populate(this);
            view.setWorld(level);
            view.setZoom(20);
            view.setBack(level.paintBackground());
            view.updateBanana(level.getNinja());
            controller.updateNinja(level.getGame());
            shootController.updateShoot(level.getGame());
            level.start();
        }
        else if (level instanceof Level3){
            System.out.println("Well done! Game complete.");
            System.exit(0);
        }
    }

    /** Run the game. */
    public static void main(String[] args) {

        new Game();
    }

    public GameLevel getLevel(){
        return level;
    }
    public GameView getView() {
        return view;
    }

}
