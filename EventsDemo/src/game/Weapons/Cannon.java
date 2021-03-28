package game.Weapons;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cannon extends Projectile implements ActionListener {

    Fixture smallCircle;

    public Cannon(World w, Vec2 from, Vec2 towards) {
        super(w, from, towards);
        CircleShape s = new CircleShape(0.3f);
        smallCircle = new SolidFixture(this,s);
        this.setFillColor(Color.black);

        Timer t = new Timer(500,this);
        t.setInitialDelay(3000);
        t.start();

    }

    @Override
    public float getSpeed() {
        return 5;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (smallCircle != null) {
            smallCircle.destroy();
            smallCircle = null;
            CircleShape s = new CircleShape(0.4f);
            GhostlyFixture f = new GhostlyFixture(this, s);
            this.setFillColor(Color.orange);
            System.out.println("Explode");

            Sensor sensor = new Sensor(this,s);
            sensor.addSensorListener(new ExplosionImpact());
        }
        else
            {
            this.destroy();
            }
    }
}
