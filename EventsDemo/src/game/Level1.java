package game;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

public class Level1 extends GameLevel{

    public Level1(Game game) {
        //the base class will create the ninja,alien,banana,door and lava
        super(game);

        // make the ground
        Shape shape = new BoxShape(19, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -11.5f));

        // make a platform
        Shape platform1Shape = new BoxShape(4, 0.5f);
        StaticBody platform1 = new StaticBody(this, platform1Shape);
        platform1.setPosition(new Vec2(6, 5.5f));

        // make a platform
        Shape platform2Shape = new BoxShape(5, 0.5f);
        StaticBody platform2 = new StaticBody(this, platform2Shape);
        platform2.setPosition(new Vec2(13, 0f));

        // make a platform
        Shape platform3Shape = new BoxShape(4, 0.5f);
        StaticBody platform3 = new StaticBody(this, platform3Shape);
        platform3.setPosition(new Vec2(1f, -7f));

        // make a platform
        Shape platform4Shape = new BoxShape(4, 0.5f);
        StaticBody platform4 = new StaticBody(this, platform4Shape);
        platform4.setPosition(new Vec2(0f, 1f));

        // make a platform
        Shape platform5Shape = new BoxShape(4, 0.5f);
        StaticBody platform5 = new StaticBody(this, platform5Shape);
        platform5.setPosition(new Vec2(-14f, -3.5f));

        //left wall
        Shape wall1Shape = new BoxShape(0.5f, 10f);
        StaticBody wall1 = new StaticBody(this, wall1Shape);
        wall1.setPosition(new Vec2(-18.5f, -2f));

        //right wall
        Shape wall2Shape = new BoxShape(0.5f, 10f);
        StaticBody wall2 = new StaticBody(this, wall2Shape);
        wall2.setPosition(new Vec2(18.5f, -2));

    }

    @Override
    public void populate(Game game){
        super.populate(game);
        //positions of the ninja,door,banana,alien and lava
        getNinja().setPosition(new Vec2(15, -10));
        getDoor().setPosition(new Vec2(16.5f, 2.4f));
        getBanana().setPosition(new Vec2(7, 7.5f));
        getAlien().setPosition(new Vec2(-13, -3.5f));
        getLava().setPosition(new Vec2(9, -10.3f));

        //create some pickups (bananas)
        for (int i = 0; i < 1; i++) {
            Banana banana = new Banana(this);
            banana.setPosition(new Vec2(i * 2.5f, 5));
        }
    }

    @Override
    public boolean isComplete() {
        if (getNinja().getBananaCount() >= 2)
            return true;
        else
            return false;
    }

    @Override
    public Image paintBackground(){
        Image background = new ImageIcon("data/Night.png").getImage();
        return background;
    }

    @Override
    public String getLevelName() {
        return "Level1";
    }

}
