package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Door extends StaticBody {

    private static final Shape DoorShape = new CircleShape(1.9f);

    private static final BodyImage image =
            new BodyImage("data/Door.png", 4f);

    public Door (World world) {
        super(world, DoorShape);
        addImage(image);
    }

    private int credits;

    public void addCredits(){
        credits++;
        System.out.println("Achieved Level " +
                + credits);
    }
    public int getCredits() {return credits;}
    
}
