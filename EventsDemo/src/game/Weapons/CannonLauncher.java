package game.Weapons;

import city.cs.engine.Body;

public class CannonLauncher extends Weapon {
    public CannonLauncher(Body o) {
        super(o);
    }

    @Override
    public void shoot() {
        Cannon c = new Cannon(getOwner().getWorld(), getOwner().getPosition(), getShootingDirection());
    }
}
