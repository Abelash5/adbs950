package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class DoorEncounter implements CollisionListener {

    private Door door;
    private GameLevel level;
    private Game game;

    public DoorEncounter(GameLevel level, Game game){
        this.level = level;
        this.game = game;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Ninja
                && level.isComplete()) {
            game.goToNextLevel();
        }
        }
}
