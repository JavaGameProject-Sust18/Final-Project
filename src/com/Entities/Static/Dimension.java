package com.Entities.Static;

import com.Graphics.Assets;
import com.Item.Item;
import com.Main.Handler;
import com.States.*;
import com.Tile.Tile;


import javax.swing.*;
import java.awt.*;

public class Dimension extends StaticEntity{
    public static   int i=0,j=0;
    public float x,y;
    public Dimension(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TW+68, Tile.TH+105);
        this.x=x;
        this.y=y;
        bounds.x=10;
        bounds.y=60;
        bounds.width=width/2+60;
        bounds.height=height/2+10;
    }

    @Override
    public void tick() {

    }
    @Override
    public void passThrough() {
        if(i==1 && j==0) {
            if (handler.getWorld().getEntityManager().getPlayer().getInventory().getLength() == 5) {
                State.setState(new GameState_2(handler));
                i+=1;
                j+=1;
                handler.getWorld().getEntityManager().getPlayer().getInventory().addItems(Item.stone1);
                handler.getWorld().getEntityManager().getPlayer().getInventory().addItems(Item.stone);
            } else {
                JOptionPane.showMessageDialog(null,"You have failed");
                State.setState(new MenuState(handler));
            }
        }
        else if(i==2 && j==1){
            if (handler.getWorld().getEntityManager().getPlayer().getInventory().getLength() < 3) {
                JOptionPane.showMessageDialog(null,"Please find Diamond Stone");
            }
            else {
                State.setState(new KnapsackState(handler));
                i++;
                j += 1;
                handler.getWorld().getEntityManager().getPlayer().getInventory().addItems(Item.stone1);
                handler.getWorld().getEntityManager().getPlayer().getInventory().addItems(Item.stone);
                handler.getWorld().getEntityManager().getPlayer().getInventory().addItems(Item.stone2);
            }
        }
        else if(i==3 && j==2){
            if(handler.getWorld().getItemManager().getP()==57 && handler.getWorld().getItemManager().getW()==16){
                handler.getWorld().getEntityManager().getPlayer().getInventory().addItems(Item.stone1);
                handler.getWorld().getEntityManager().getPlayer().getInventory().addItems(Item.stone);
                handler.getWorld().getEntityManager().getPlayer().getInventory().addItems(Item.stone2);
                handler.getWorld().getEntityManager().getPlayer().getInventory().addItems(Item.stone3);
                JOptionPane.showMessageDialog(null,"Winner");
                State.setState(new MenuState(handler));

            }
            else if(handler.getWorld().getItemManager().getW()>16){
                JOptionPane.showMessageDialog(null,"Over Weight");
                State.setState(new MenuState(handler));
            }
            else if(handler.getWorld().getItemManager().getW()<16){
                JOptionPane.showMessageDialog(null,"Less Weight and profit is not maximized..");
                State.setState(new MenuState(handler));
            }
            i++;
        }
        else if(i==0 && j==0) {
            State.setState(handler.getGame().problemstate);
            i += 1;
        }
        System.out.println(i);


    }

    @Override
    public void render(Graphics g) {
        if(i==0)
            g.drawImage(Assets.Gate,(int)(x-handler.getGameCemera().getxOffset()),(int)(y-handler.getGameCemera().getyOffset()),width,height,null);
        else g.drawImage(Assets.dimension,(int)(x-handler.getGameCemera().getxOffset()),(int)(y-handler.getGameCemera().getyOffset()),width,height,null);
    }

    @Override
    public void setX(float x) {
        this.x = x;
    }

    @Override
    public void setY(float y) {
        this.y = y;
    }

    public static void setI(int i) {
        Dimension.i = i;
    }
}
