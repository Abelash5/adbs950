package game.Weapons;

import city.cs.engine.CircleShape;
import city.cs.engine.Fixture;
import city.cs.engine.SolidFixture;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

import java.awt.*;

public class Bullet extends Projectile{
    public Bullet(World w, Vec2 from, Vec2 towards) {
        super(w, from, towards);
        CircleShape s = new CircleShape(0.1f);
        Fixture f = new SolidFixture(this,s);
        this.setFillColor(Color.black);

        this.addCollisionListener(new BulletImpact());
    }

    @Override
    public float getSpeed() {
        return 20;
    }
}
