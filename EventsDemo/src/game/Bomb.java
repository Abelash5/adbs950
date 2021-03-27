package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Bomb extends StaticBody {

    private static final Shape BombShape = new CircleShape(1f);

    private static SoundClip bombSound;

    static {
        try {
            bombSound = new SoundClip("data/Bomb.wav");
            System.out.println("Loading bomb sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

        private static final BodyImage image =
            new BodyImage("data/Bomb.png", 2f);


    public Bomb (World world) {
        super(world, BombShape);
        addImage(image);
    }

    private int credits;

    public void addCredits(){
        credits++;
        System.out.println("Live Lost: " +
                + credits);
    }

    public int getCredits() {return credits;}

    public void playBombsound(){
        bombSound.play();
    }

}
