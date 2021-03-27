package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class CrabEncounter implements CollisionListener {

    private Crab crab;
    public CrabEncounter(Crab c) { crab = c; }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Ninja) {
            crab.addCredits();
            crab.playCrabsound();
            System.out.println("Ate by crab");
            e.getOtherBody().destroy();
        }
    }

}