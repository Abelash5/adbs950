package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class LavaEncounter implements CollisionListener {

    private Lava lava;
    public LavaEncounter(Lava s) {
        lava = s;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Ninja) {
            lava.addCredits();
            System.out.println("Dissolved by lava");
            e.getOtherBody().destroy();
        }
    }

    }

