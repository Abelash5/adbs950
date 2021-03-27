package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Crab extends DynamicBody {

    private static final Shape CrabShape = new CircleShape(1f);

    private static SoundClip crabSound;

    static {
        try {
            crabSound = new SoundClip("data/Crab.wav");
            System.out.println("Loading crab sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    private static final BodyImage image =
            new BodyImage("data/Crab.png", 2f);

    public Crab(World world) {
        super(world, CrabShape);
        addImage(image);
    }

    private int credits;

    public void addCredits() {
        credits++;
        System.out.println("Live Lost: " +
                +credits);
    }

    public void playCrabsound(){
        crabSound.play();
    }

}