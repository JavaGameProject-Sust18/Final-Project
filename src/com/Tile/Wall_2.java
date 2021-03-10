package com.Tile;

import com.Graphics.Assets;

public class Wall_2 extends Tile {
    public Wall_2(int id) {
        super(Assets.wall_2, id);
    }
    @Override
    public boolean isSolid(){
        return true;
    }
}
