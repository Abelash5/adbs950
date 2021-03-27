package game;

import city.cs.engine.*;

public class Lava extends StaticBody {

    private static final Shape LavaShape = new BoxShape(0.7f,0.7f);

    private static final BodyImage image =
            new BodyImage("data/Lava.gif", 1.4f);

    public Lava(World world) {
        super(world,LavaShape);
        addImage(image);
    }

    private int credits;

    public void addCredits(){
        credits++;
        System.out.println("Live Lost: " +
                + credits);
    }
    public int getCredits() {return credits;}
}
