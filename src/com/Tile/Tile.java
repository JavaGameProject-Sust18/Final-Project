package com.Tile;

import com.Graphics.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {
    public static Tile[] tiles=new Tile[256];
    public static Tile grassTile=new GrassTile(0);
    public static Tile rockTile=new RockTile(1);
    public static Tile treeTile=new TreeTile(2);
    public static Tile rock1Tile=new Rock1Tile(3);
    public static Tile blackTile=new DarkTile(4);
    public static Tile dartTile=new DartTile(5);
    public static Tile wall=new Wall(6);
    public static Tile wall_1=new Wall_1(7);
    public static Tile wall1=new Wall1(8);
    public static Tile wall1_1=new Wall1_1(9);
    public static Tile wall_2=new Wall_2(10);
    public static Tile wall_2_1=new Wall_2_1(11);
    public static Tile road=new Road(12);
    public static Tile sky=new Sky(13);
    public static Tile river=new River(14);
    public static int TW=64,TH=64;
    protected BufferedImage texture;
    protected final int id;
    public Tile(BufferedImage texture,int id) {
        this.id=id;
        this.texture=texture;
        tiles[id]=this;
    }
    public void tick(){

    }
    public void render(Graphics g,int x,int y){
        if(texture != Assets.wall || texture != Assets.wall1 ) {
            g.drawImage(texture, x, y, TW, TH, null);
        }else g.drawImage(texture, x, y, 100, 64, null);

    }
    public boolean isSolid(){
        return false;
    }

    public int getId() {
        return id;
    }
}
