package game;

import city.cs.engine.UserView;
import city.cs.engine.World;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;

public class GameView extends UserView {

    private Image background;

    public Image back;

    Ninja ninja;
    public GameView(World w , Ninja ninja, int width, int height) {
        super(w, width, height);
        // background = new ImageIcon("data/night.png").getImage();
        this.ninja = ninja;
    }

    public void setBack(Image background){
        this.back = background;
    }

    @Override
    protected void paintBackground(Graphics2D g) {

        g.drawImage(back, 0, 0, this);
    }

    @Override
    protected void paintForeground(Graphics2D g) {
        g.setFont(new Font("Arial",Font.BOLD,15));
        g.setColor(Color.WHITE);
        g.drawString("Number of Bananas Ate: " + ninja.getBananaCount(), 150, 100);
        g.drawString("Energy Level " + ninja.getEnergyCount(), 700, 100);
    }

    public void updateBanana(Ninja ninja){this.ninja = ninja;}
}
