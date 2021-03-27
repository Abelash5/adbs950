package game.Weapons;

import city.cs.engine.Body;
import org.jbox2d.common.Vec2;

public class Pistol extends Weapon{
    public Pistol(Body o) {
        super(o);
    }

    @Override
    public void shoot() {
        Bullet b = new Bullet(getOwner().getWorld(),getOwner().getPosition(),getShootingDirection());
    }
}
