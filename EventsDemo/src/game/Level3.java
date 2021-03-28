package game;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

public class Level3 extends GameLevel{


    public Level3(Game game) {
        //the base class will create the ninja,alien,banana,door and lava
        super(game);

        // make the ground
        Shape shape = new BoxShape(19, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -11.5f));

        // make a platform
        Shape platform1Shape = new BoxShape(4, 0.5f);
        StaticBody platform1 = new StaticBody(this, platform1Shape);
        platform1.setPosition(new Vec2(14, 5.5f));

        // make a platform
        Shape platform2Shape = new BoxShape(5, 0.4f);
        StaticBody platform2 = new StaticBody(this, platform2Shape);
        platform2.setPosition(new Vec2(-11, 5.5f));

        // make a platform
        Shape platform3Shape = new BoxShape(4, 0.5f);
        StaticBody platform3 = new StaticBody(this, platform3Shape);
        platform3.setPosition(new Vec2(1f, -7f));

        // make a platform
        Shape platform4Shape = new BoxShape(4, 0.3f);
        StaticBody platform4 = new StaticBody(this, platform4Shape);
        platform4.setPosition(new Vec2(0f, 1f));

        // make a platform
        Shape platform5Shape = new BoxShape(4, 0.4f);
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
        getNinja().setPosition(new Vec2(-15,-10));
        getDoor().setPosition(new Vec2(14,7.9f));
        getBanana().setPosition(new Vec2(-11,6.5f));
        getAlien().setPosition(new Vec2(-13,-3.5f));
        getLava().setPosition(new Vec2(11,-10.3f));

        // add a new body (crab) to the level
        // and a collision listener between the ninja and crab
        Crab crab = new Crab(this);
        crab.setPosition(new Vec2(-7,-10));
        CrabEncounter kill = new CrabEncounter(crab);
        crab.addCollisionListener(kill);

        // add a new body (bomb) to the level
        // and a collision listener between the ninja and bomb
        Bomb bomb = new Bomb(this);
        bomb.setPosition(new Vec2(3,2.5f));
        BombEncounter encount = new BombEncounter(bomb);
        bomb.addCollisionListener(encount);

        //create some pickups (bananas)
        for (int i = 0; i < 3; i++) {
            Banana banana = new Banana(this);
            banana.setPosition(new Vec2(i * 8f, 5));
        }
    }

    // Ninja needs to collect a certain amount of bananas to move to the next level
    @Override
    public boolean isComplete() {
        if (getNinja().getBananaCount() == 4)
            return true;
        else return false;
    }

    // Paints the background of the level
    @Override
    public Image paintBackground(){
        Image background = new ImageIcon("data/Dungeon.png").getImage();
        return background;
    }

    // Returns the level
    @Override
    public String getLevelName() {
        return "Level3";
    }

}
