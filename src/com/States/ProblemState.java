package com.States;

import com.Display.Display;
import com.Graphics.Assets;
import com.Main.Handler;
import com.Tile.ui.ClickListener;
import com.Tile.ui.UiImageButton;
import com.Tile.ui.UiManager;
import com.Tower.GameMain;

import java.awt.*;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import com.Tower.*;

public  class ProblemState extends State {
    private int invX=0,invY=0,invWidth=880,invHeight=600;
    private UiManager uimanager;
    public boolean active;
    public Rectangle a;

    public ProblemState(Handler handler) {
        super(handler);
        uimanager=new UiManager(handler);
        handler.getMouseManager().setUiManager(uimanager);
        uimanager.addObject(new UiImageButton(520, 270, 200, 45, Assets.button, new ClickListener() {
            @Override
            public void onClick() {
               try{
                DataInputStream input =new DataInputStream(new FileInputStream("res/images/input.txt"));
                int x=input.readInt();
                input.close();
                State.setState(new GameHold(handler));
                } catch (IOException e) {
                    e.printStackTrace();
                }
               GameMain.buttonmusic();

            }

        }));
    }


    @Override
    public void tick() {
        uimanager.tick();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.Maze[5],0,0,900,700,null);
        g.drawImage(Assets.tower,100, 150, 700, 400,null);
        uimanager.render(g);
    }


}


