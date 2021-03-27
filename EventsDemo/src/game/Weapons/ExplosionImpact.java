package game.Weapons;

import city.cs.engine.SensorEvent;
import city.cs.engine.SensorListener;
import game.Alien;

public class ExplosionImpact implements SensorListener {
    @Override
    public void beginContact(SensorEvent sensorEvent) {
        if (sensorEvent.getContactBody() instanceof Alien){
            sensorEvent.getContactBody().destroy();
        }
    }

    @Override
    public void endContact(SensorEvent sensorEvent) {

    }
}
