package game;

import city.cs.engine.DynamicBody;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author      Abelash Rangarajah abelash.rangarajah@city.ac.uk
 * @version     1.0
 * @since       26th March 2021
 */

public class GameSaverLoader {

    /**
     * Saves the game
     * <p>
     * Saves the level so that when the user returns to play the game, they dont have to start from the beginning and can continues from where they were last from.
     *
     * @param level - Level where i'm in.
     * @param fileName - File where i want the game to be saved to.
     * @return Returns the position of the bodies in the game. Also shows if the bananas have been picked up or not. In conclusion the stae of the game.
     */

    public static void save(GameLevel level, String fileName)
            throws IOException
    {
        boolean append = false;
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName, append);
            writer.write(level.getLevelName() + "\n");

            for (StaticBody body : level.getStaticBodies()) {
                if (body instanceof Door) {
                    writer.write("Door," + body.getPosition().x + "," +
                            body.getPosition().y + "\n");
                }
                else if (body instanceof Lava) {
                    writer.write("Lava," + body.getPosition().x + "," +
                            body.getPosition().y + "\n");
                }
                else if (body instanceof Bomb) {
                    writer.write("Bomb," + body.getPosition().x + "," +
                            body.getPosition().y + "\n");
                }

            }

            for (DynamicBody body : level.getDynamicBodies()) {
                if (body instanceof Ninja) {
                    writer.write("Ninja," + body.getPosition().x + "," +
                            body.getPosition().y + "," +
                            ((Ninja) body).getBananaCount() + "\n");
                }
                else if (body instanceof Alien) {
                    writer.write("Alien," + body.getPosition().x + "," +
                            body.getPosition().y + "\n");
                }
                else if (body instanceof Banana) {
                    writer.write("Banana," + body.getPosition().x + "," +
                            body.getPosition().y + "\n");
                }
                else if (body instanceof Crab) {
                    writer.write("Crab," + body.getPosition().x + "," +
                            body.getPosition().y + "\n");
                }
            }
        }finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    /**
     * Loads the game
     * <p>
     * Loads the level so that when the user returns to play the game, they dont have to start from the beginning and can continues from where they were last from.
     *
     * @param game - Loads the entire game
     * @param fileName - File where i want the game to be loaded from.
     * @return Returns the position of the bodies in the game. Also shows if the bananas have been picked up or not. In conclusion the stae of the game.
     */

    public static GameLevel load(Game game, String fileName)
            throws IOException
    {
        FileReader fr = null;
        BufferedReader reader = null;
        try {
            System.out.println("Reading " + fileName + " ...");
            fr = new FileReader(fileName);
            reader = new BufferedReader(fr);
            String line = reader.readLine();

            GameLevel level = null;
            if (line.equals("Level1"))
                level = new Level1(game);
            else if (line.equals("Level2"))
                level = new Level2(game);
            else if (line.equals("Level3"))
                level = new Level3(game);

            line = reader.readLine();
            while (line != null) {

                String[] tokens = line.split(",");

                if (tokens[0].equals("Ninja")) {
                    Ninja n = new Ninja(level);
                    float x = Float.parseFloat(tokens[1]);
                    float y = Float.parseFloat(tokens[2]);
                    n.setPosition(new Vec2(x, y));
                    int bc = Integer.parseInt(tokens[3]);
                    n.setBananaCount(bc);

                    level.setNinja(n);
                    BananaEncounter collision = new BananaEncounter(n, game);
                    n.addCollisionListener(collision);

                }
                else if (tokens[0].equals("Alien")) {
                    Alien a = new Alien(level);
                    float x = Float.parseFloat(tokens[1]);
                    float y = Float.parseFloat(tokens[2]);
                    a.setPosition(new Vec2(x, y));

                    level.setAlien(a);
                    AlienEncounter enemy = new AlienEncounter(a);
                    a.addCollisionListener(enemy);

                }
                else if (tokens[0].equals("Banana")) {
                    Banana b = new Banana(level);
                    float x = Float.parseFloat(tokens[1]);
                    float y = Float.parseFloat(tokens[2]);
                    b.setPosition(new Vec2(x, y));
                }
                else if (tokens[0].equals("Crab")) {
                    Crab c = new Crab(level);
                    float x = Float.parseFloat(tokens[1]);
                    float y = Float.parseFloat(tokens[2]);
                    c.setPosition(new Vec2(x, y));

                    CrabEncounter kill = new CrabEncounter(c);
                    c.addCollisionListener(kill);
                }
                else if (tokens[0].equals("Door")) {
                    Door d = new Door(level);
                    float x = Float.parseFloat(tokens[1]);
                    float y = Float.parseFloat(tokens[2]);
                    d.setPosition(new Vec2(x, y));

                    level.setDoor(d);
                    DoorEncounter end = new DoorEncounter(level,game);
                    d.addCollisionListener(end);
                }
                else if (tokens[0].equals("Lava")) {
                    Lava l = new Lava(level);
                    float x = Float.parseFloat(tokens[1]);
                    float y = Float.parseFloat(tokens[2]);
                    l.setPosition(new Vec2(x, y));

                    level.setLava(l);
                    LavaEncounter encounter = new LavaEncounter(l);
                    l.addCollisionListener(encounter);
                }
                else if (tokens[0].equals("Bomb")) {
                    Bomb b = new Bomb(level);
                    float x = Float.parseFloat(tokens[1]);
                    float y = Float.parseFloat(tokens[2]);
                    b.setPosition(new Vec2(x, y));

                    BombEncounter encount = new BombEncounter(b);
                    b.addCollisionListener(encount);
                }
                line = reader.readLine();
            }
            return level;
        }
        finally {
            if (reader != null) {
                reader.close();
            }
            if (fr != null) {
                fr.close();
            }
        }
    }

}
