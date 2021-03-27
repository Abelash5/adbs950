package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class AlienEncounter implements CollisionListener {

    private Alien alien;
    public AlienEncounter(Alien a) {
        alien = a;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Ninja) {
            alien.addCredits();
            System.out.println("Killed by Alien");
            e.getOtherBody().destroy();
        }
    }

}



