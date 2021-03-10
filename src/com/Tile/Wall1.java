package com.Tile;

import com.Graphics.Assets;

public class Wall1 extends Tile {
    public Wall1(int id) {
        super(Assets.wall1, id);
    }
    @Override
    public boolean isSolid(){
        return true;
    }
}