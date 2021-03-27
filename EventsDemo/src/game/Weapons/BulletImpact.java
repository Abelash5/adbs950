package game.Weapons;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.Alien;
import game.Crab;

public class BulletImpact implements CollisionListener {

    @Override
    public void collide(CollisionEvent collisionEvent) {

        if (collisionEvent.getOtherBody() instanceof Alien) {
            collisionEvent.getOtherBody().destroy();
            collisionEvent.getReportingBody().destroy();
        }
        else if (collisionEvent.getOtherBody() instanceof Crab) {
            collisionEvent.getOtherBody().destroy();
            collisionEvent.getReportingBody().destroy();
        }
        else
            collisionEvent.getReportingBody().destroy();
    }
}