package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Alien extends Walker {

    private static final Shape AlienShape = new PolygonShape(
            -0.07f,2.47f, -0.63f,-0.56f, -0.2f,-2.35f, 0.21f,-2.37f, 0.53f,1.97f);


    private static final BodyImage image =
            new BodyImage("data/Alien.png", 5f);

    public Alien(World world) {
        super(world, AlienShape);
        addImage(image);
    }

    private int credits;

    public void addCredits(){
        credits++;
        System.out.println("Death " +
                + credits);
    }
    public int getCredits() {return credits;}


}





