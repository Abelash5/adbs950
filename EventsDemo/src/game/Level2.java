package game;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

public class Level2 extends GameLevel{

    public Level2(Game game) {
        //the base class will create the ninja,alien,banana,door and lava
        super(game);

        // make the ground
        Shape shape = new BoxShape(19, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -11.5f));

        // make a platform
        Shape platform2Shape = new BoxShape(5, 0.3f);
        StaticBody platform2 = new StaticBody(this, platform2Shape);
        platform2.setPosition(new Vec2(11, 0f));

        // make a platform
        Shape platform3Shape = new BoxShape(4, 0.3f);
        StaticBody platform3 = new StaticBody(this, platform3Shape);
        platform3.setPosition(new Vec2(11f, -6.5f));

        // make a platform
        Shape platform4Shape = new BoxShape(4, 0.3f);
        StaticBody platform4 = new StaticBody(this, platform4Shape);
        platform4.setPosition(new Vec2(-1f, -5f));

        // make a platform
        Shape platform5Shape = new BoxShape(2, 0.3f);
        StaticBody platform5 = new StaticBody(this, platform5Shape);
        platform5.setPosition(new Vec2(-10f, 0f));

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
        getNinja().setPosition(new Vec2(16,-10));
        getDoor().setPosition(new Vec2(-16.5f,-9f));
        getBanana().setPosition(new Vec2(-11f,5f));
        getAlien().setPosition(new Vec2(-10,-11.5f));
        getLava().setPosition(new Vec2(10f,-5.5f));

        // add a new body (bomb) to the level
        // and a collision listener between the ninja and bomb
        Bomb bomb = new Bomb(this);
        bomb.setPosition(new Vec2(-2,-3.7f));
        BombEncounter encount = new BombEncounter(bomb);
        bomb.addCollisionListener(encount);

        //create some pickups (bananas)
        for (int i = 0; i < 2; i++) {
            Banana banana = new Banana(this);
            banana.setPosition(new Vec2(i * 10f, 5));
        }
    }

    @Override
    public boolean isComplete() {
        if (getNinja().getBananaCount() == 3)
            return true;
        else return false;
    }

    @Override
    public Image paintBackground(){
        Image background = new ImageIcon("data/Sea.png").getImage();
        return background;
    }

    @Override
    public String getLevelName() {
        return "Level2";
    }

}
