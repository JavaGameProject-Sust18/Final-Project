package com.Tile;

import com.Graphics.Assets;

public class Tree_1 extends Tile {
    public Tree_1(int id) {
        super(Assets.Tree_1, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}