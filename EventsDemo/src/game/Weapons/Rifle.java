package game.Weapons;

import city.cs.engine.Body;

import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Rifle extends Weapon implements ActionListener {

    private Timer t;
    public Rifle(Body o) {

        super(o);
        t = new Timer(60, this);
    }

    @Override
    public void shoot() {
        Bullet b = new Bullet(getOwner().getWorld(),getOwner().getPosition(), getShootingDirection());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        shoot();
    }

    @Override
    public void startShooting(){
        t.start();
    }

    @Override
    public void stopShooting(){
        t.stop();
    }


}
