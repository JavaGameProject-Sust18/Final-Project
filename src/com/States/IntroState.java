package com.States;

import com.Display.Display;
import com.Graphics.Animation;
import com.Graphics.Assets;
import com.Main.Handler;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.net.URL;

public class IntroState extends State {

    private Image logo;

    private int alpha;
    private int ticks;

    private final int FADE_IN = 60;
    private final int LENGTH = 100;
    private final int FADE_OUT = 320;
    public Image intro;

    public IntroState(Handler handler) {
        super(handler);
        intro = new ImageIcon(this.getClass().getResource("/texture/Intro.gif")).getImage();
    }


    @Override
    public void tick() {
        handleInput();
        ticks++;
        if(ticks < FADE_IN) {
            alpha = (int) (255 - 255 * (1.0 * ticks / FADE_IN));
            if(alpha < 0) alpha = 0;
        }
        if(ticks > FADE_IN + LENGTH) {
            alpha = (int) (255 * (1.0 * ticks - FADE_IN - LENGTH) / FADE_OUT);
            if(alpha > 255) alpha = 255;
        }
        if(ticks > FADE_IN + LENGTH + FADE_OUT) {
            State.setState(handler.getGame().menustate);
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, 900, 700);
        g.drawImage(intro, 0, 0, 900, 700, null);
        g.setColor(new Color(0, 0, 0, alpha));
        g.fillRect(0, 0, 900, 700);
    }
    public void handleInput() {
        if(handler.getKeyManeger().key[KeyEvent.VK_ENTER]) {
            State.setState(handler.getGame().menustate);
        }
    }
}
