package game.Weapons;

import game.Game;
import game.GameView;
import game.Ninja;
import org.jbox2d.common.Vec2;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;

public class ShootController implements MouseListener, MouseMotionListener {

    private Game game;
    private GameView view;
    public ShootController(GameView view, Game game){
        this.game = game;
        this.view = view;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        game.getLevel().getNinja().getActiveWeapon().shoot();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Vec2 p = view.viewToWorld(new Point2D.Float(e.getX(),e.getY()));
        Vec2 direction = p.sub(game.getLevel().getNinja().getPosition());
        direction.normalize();
        game.getLevel().getNinja().getActiveWeapon().setShootingDirection(direction);
        game.getLevel().getNinja().getActiveWeapon().startShooting();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        game.getLevel().getNinja().getActiveWeapon().stopShooting();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Vec2 p = view.viewToWorld(new Point2D.Float(e.getX(),e.getY()));
        Vec2 direction = p.sub(game.getLevel().getNinja().getPosition());
        direction.normalize();
        game.getLevel().getNinja().getActiveWeapon().setShootingDirection(direction);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Vec2 p = view.viewToWorld(new Point2D.Float(e.getX(),e.getY()));
        Vec2 direction = p.sub(game.getLevel().getNinja().getPosition());
        direction.normalize();
        game.getLevel().getNinja().getActiveWeapon().setShootingDirection(direction);
    }

    public void updateShoot(Game game){
        this.game = game;
    }

}
