package game;

import city.cs.engine.World;

import java.awt.*;

public abstract class GameLevel extends World {
    private Alien alien;
    private Ninja ninja;
    private Banana banana;
    private Door door;
    private Lava lava;
    private Game game;

    public GameLevel(Game game) {
        this.game = game;
    }

    public void populate(Game game){
        // all levels have an alien, a ninja, a banana, a door and a lava
        // and there are several collisions between the bodies
        // e.g. student needs to reach the door to complete the level hence a DoorEncounter
        alien = new Alien(this);
        ninja = new Ninja(this);
        banana = new Banana(this);
        door = new Door (this);
        lava = new Lava(this);

        AlienEncounter enemy = new AlienEncounter(alien);
        alien.addCollisionListener(enemy);
        DoorEncounter end = new DoorEncounter(this,game);
        door.addCollisionListener(end);
        BananaEncounter collision = new BananaEncounter(ninja,game);
        ninja.addCollisionListener(collision);
        LavaEncounter encounter = new LavaEncounter(lava);
        lava.addCollisionListener(encounter);
    }

    public Alien getAlien() { return alien; }
    public void setAlien(Alien a){ alien = a; }
    public Ninja getNinja() { return ninja; }
    public void setNinja(Ninja n){
        ninja = n;
    }
    public Banana getBanana() {return banana;}
    public Door getDoor() {return door;}
    public void setDoor(Door d){ door = d; }
    public Lava getLava() {return lava;}
    public void setLava(Lava l){ lava = l;
    }
    public Game getGame(){return game;}

    public abstract boolean isComplete();
    public abstract Image paintBackground();

    public abstract String getLevelName();

}



