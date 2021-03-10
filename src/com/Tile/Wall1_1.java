package com.Tile;

import com.Graphics.Assets;

public class Wall1_1 extends Tile {
    public Wall1_1(int id) {
        super(Assets.wall1_1, id);
    }
    @Override
    public boolean isSolid(){
        return true;
    }
}