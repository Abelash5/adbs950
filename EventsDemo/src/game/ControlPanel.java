package game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel {
    private JPanel mainPanel;
    private JButton restartButton;
    private JButton pauseButton;
    private JButton resumeButton;
    private JButton quitButton;
    private JButton level1Button;
    private JButton level2Button;
    private JButton level3Button;

    private Game game;
    public ControlPanel(Game game) {
        this.game = game;
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.pause();
            }
        });
        resumeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.resume();
            }
        });
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { game.restart(); }
        });
        level1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { game.level1(); }
        });
        level2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { game.level2(); }
        });
        level3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { game.level3(); }
        });
    }

    public JPanel getMainPanel()
    {
        return mainPanel;
    }
}
