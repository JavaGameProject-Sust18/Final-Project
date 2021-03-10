package com.Tile;

import com.Graphics.Assets;

public class River extends Tile {
    public River(int id) {
        super(Assets.river, id);
    }
    @Override
    public boolean isSolid(){
        return true;
    }
}