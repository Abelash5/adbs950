package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class BombEncounter implements CollisionListener {

    private Bomb bomb;
    public BombEncounter(Bomb b) { bomb = b; }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Ninja) {
            bomb.addCredits();
            bomb.playBombsound();
            System.out.println("Killed by bomb blast");
            e.getOtherBody().destroy();
        }
    }

}