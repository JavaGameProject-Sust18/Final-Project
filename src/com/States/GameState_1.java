package com.States;

import com.Entities.Creature.Player;
import com.Entities.EntityManager;
import com.Entities.Static.Dimension;
import com.Entities.Static.Tree;
import com.Graphics.Assets;
import com.Inventory.Inventory;
import com.Item.Item;
import com.Item.ItemManager;
import com.Main.Game;
import com.Main.Handler;
import com.Tile.Tile;
import com.World.World;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class GameState_1 extends State {
    public int i=0,j=0;
    private boolean active=false;
    public static JFrame messageframe=new JFrame();
    public static JFrame mapframe=new JFrame();
    public JButton button=new JButton("OK");
    public JButton MapBtn=new JButton("Back");
    private Player player;
    private Dimension dimension;
    private World world;
    private EntityManager entityManager;
    public GameState_1(Handler handler) {
        super(handler);
        world=new World(handler,"res/world/world-2.txt");
        handler.setWorld(world);

        player=handler.getWorld().getEntityManager().getPlayer() ;
        player.setX(150);
        player.setY(100);
        dimension=new Dimension(handler,1020,950);
        handler.getWorld().getEntityManager().getEntities().removeAll(handler.getWorld().getEntityManager().getEntities());
        handler.getWorld().getEntityManager().addEntity(dimension);
        handler.getWorld().getEntityManager().addEntity(player);
        player.getInventory().addItems(Item.stone);
        handler.getWorld().getItemManager().addItem(Item.v1.createNew(600,200));
        handler.getWorld().getItemManager().addItem(Item.v2.createNew(965,490));
        handler.getWorld().getItemManager().addItem(Item.v3.createNew(1090,850));
        handler.getWorld().getItemManager().addItem(Item.v4.createNew(325,420));
        handler.getWorld().getItemManager().addItem(Item.v5.createNew(600,455));
        handler.getWorld().getItemManager().addItem(Item.v6.createNew(130,850));
        handler.getWorld().getItemManager().addItem(Item.v1.createNew(645,800));


    }

    @Override
    public void tick() {
        world.tick();
        if(handler.getKeyManeger().justPressed[KeyEvent.VK_M])
            active = !active;
        if(active&& j==0){
            MapView();
            mapframe.setVisible(true);
            j++;
        }
        if(i==0) {
            MessageFrame();
            messageframe.setVisible(true);
            AddButtonActionListener();
            i++;
        }
    }

    @Override
    public void render(Graphics g) {
        world.render(g);
    }

    public void MapView(){
        MapBtn.setBounds(0,0,100,50);
        ImageIcon icon=new ImageIcon("res/texture/back.png");
        Image img = icon.getImage() ;
        Image newimg = img.getScaledInstance( 100, 50,  java.awt.Image.SCALE_SMOOTH ) ;
        MapBtn.setIcon(new ImageIcon( newimg ));
        MapBtn.setBackground(new Color(0,0,0, 0));
        MapBtn.setBorderPainted(false);
        JPanel panel =new JPanel();
        panel.setLayout(null);
        panel.setBounds(320,580,100, 50);
        panel.add(MapBtn);
        mapframe.setSize(700, 640);
        mapframe.add(panel);
        mapframe.add(new JLabel("View Map"));
        mapframe.add(new JLabel(new ImageIcon("res/texture/map.jpg")));
        mapframe.dispose();
        mapframe.setUndecorated(true);
        mapframe.setBackground(new Color(0,0,0, (float) 0.7));
        mapframe.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        mapframe.setResizable(false);
        mapframe.setLocationRelativeTo(null);
    }

    public void MessageFrame(){
        button.setBounds(0,0,100,50);
        button.setIcon(new ImageIcon("res/texture/ok.png"));
        JPanel panel =new JPanel();
        panel.setLayout(null);
        panel.setBounds(200,430,100, 50);
        panel.add(button);
        messageframe.setSize(500, 500);
        messageframe.add(panel);
        messageframe.add(new JLabel(new ImageIcon("res/texture/spm.png")));
        messageframe.dispose();
        messageframe.setUndecorated(true);
        messageframe.setBackground(new Color(0,0,0,0));
        messageframe.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        messageframe.setResizable(false);
        messageframe.setLocationRelativeTo(null);
    }
    public void AddButtonActionListener(){
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                messageframe.setVisible(false);
            }
        });
        MapBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mapframe.setVisible(false);
            }
        });
    }

}
