package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.StaticBody;

/**
 * @author      Abelash Rangarajah
 * @version     1.0
 * @since       26th March 2021
 */

public class DestroyOnImpact implements CollisionListener {

    /**
     * Collision between two bodies
     * <p>
     * When the ninja picks up the bananas, the bananas are destroyed and an impact is created in the centre of the game.
     *
     * @param  collisionEvent An event were two or more objects are interfering with each other.
     */

    @Override
    public void collide(CollisionEvent collisionEvent) {
        if (collisionEvent.getOtherBody() instanceof StaticBody
                || collisionEvent.getOtherBody() instanceof Ninja)
            collisionEvent.getReportingBody().destroy();
    }
}
