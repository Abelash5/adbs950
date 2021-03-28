package game.Weapons;

import city.cs.engine.DynamicBody;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

/**
 * @author      Abelash Rangarajah abelash.rangarajah@city.ac.uk
 * @version     1.0
 * @since       26th March 2021
 */

public abstract class Projectile extends DynamicBody {

    /**
     * Saves the game
     * <p>
     * Saves the level so that when the user returns to play the game, they dont have to start from the beginning and can continues from where they were last from.
     *
     * @param w World where the game is created
     * @param from Where the method is being targetted from
     * @param towards Where the method is being targetted to
     * @return Returns the position of the bodies in the game. Also shows if the bananas have been picked up or not. In conclusion the stae of the game.
     */

    public Projectile(World w, Vec2 from, Vec2 towards) {
        super(w);
        this.setPosition(from.add(towards.mul(2)));
        this.setLinearVelocity(towards.mul(getSpeed()));
    }

    /**
     * Speed of the projectile
     * <p>
     * This states the speed of the weapons when it is projected so when mouse is pressed
     * @return Returns the speed of the weapons
     */

    public abstract float getSpeed();

}
