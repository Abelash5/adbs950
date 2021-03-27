package game;

import city.cs.engine.*;
import game.Weapons.CannonLauncher;
import game.Weapons.Pistol;
import game.Weapons.Rifle;
import game.Weapons.Weapon;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Ninja extends Walker {
    private static final Shape NinjaShape = new PolygonShape(
            0.21f,1.93f, -0.84f,0.53f, -0.14f,-1.93f, 0.65f,-1.9f, 1.06f,0.69f, 0.76f,1.43f);

    private static SoundClip bananaSound;
    private int BananaCount;
    private int EnergyCount;

    static {
        try {
            bananaSound = new SoundClip("data/Eating.wav");
            System.out.println("Loading eating sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    private static SoundClip death;

    static {
        try {
            death = new SoundClip("data/Killed.wav");
            System.out.println("Loading death sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    private static final BodyImage image =
            new BodyImage("data/Ninja.png", 4f);

    private Weapon[] weapons;
    private int activeWeapon;

    public Ninja (World world) {
        super(world, NinjaShape);
        addImage(image);

        BananaCount = 0;
        EnergyCount = 0;

        weapons = new Weapon[3];
        weapons[0] = new Pistol (this);
        weapons[1] = new Rifle (this);
        weapons[2] = new CannonLauncher(this);
    }

    public Weapon getActiveWeapon(){
        return weapons[activeWeapon];
    }

    public void setActiveWeapon(int i){
        activeWeapon = i;
    }

    public void addBananas(){
        BananaCount++;
        System.out.println("Ate Banana: " +
                "bananaCount = " + BananaCount);
    }
    public int getBananaCount(){
        return BananaCount;
    }

    public void CheckEnergy(){
        EnergyCount = EnergyCount + 10;
        System.out.println("Become healthier: " +
                "bananaCount = " + EnergyCount);
    }
    public int getEnergyCount(){
        return EnergyCount;
    }

    @Override
    public void destroy()
    {
        death.play();
        super.destroy();
    }

    public void playBananasound(){
        bananaSound.play();
    }

    public void setBananaCount(int bc){
        BananaCount = bc;
    }



}
