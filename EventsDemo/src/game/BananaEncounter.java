package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class BananaEncounter implements CollisionListener {

    private Ninja ninja;
    private Game game;
    public BananaEncounter(Ninja n, Game g) {
        ninja = n;
        this.game = g;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Banana) {
            ninja.addBananas();
            ninja.CheckEnergy();
            ninja.playBananasound();
            e.getOtherBody().destroy();

            for (int i=0; i<70; i++){
                DynamicBody d = new DynamicBody(game.getLevel(),
                        new CircleShape(0.2f));
                d.setPosition(game.getView().getCentre());
                d.setLinearVelocity(new Vec2(
                        (float)(Math.random()*10-5),
                        (float)(Math.random()*10) ));
                d.addCollisionListener(new DestroyOnImpact());
            }
        }
    }
}
