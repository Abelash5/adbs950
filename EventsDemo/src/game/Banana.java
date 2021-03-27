package game;

import city.cs.engine.*;

public class Banana extends DynamicBody {

    private static final Shape BananaShape = new CircleShape(0.5f);

    private static final BodyImage image =
            new BodyImage("data/Banana.png", 2f);

    public Banana(World world) {
        super(world, BananaShape);
        addImage(image);
    }

}