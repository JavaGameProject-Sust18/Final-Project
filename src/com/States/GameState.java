package com.States;

import com.Display.Display;
import com.Entities.Creature.Player;
import com.Entities.Static.Dimension;
import com.Entities.Static.Rock;
import com.Entities.Static.Stone;
import com.Entities.Static.Tree;
import com.Item.Item;
import com.Main.Handler;
import com.World.World;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameState extends State {
    public int i=0;
    public static JFrame messageframe=new JFrame();
    public JButton button=new JButton("OK");
    private Player player;
    private World world;
    private Dimension dimension;
    public GameState(Handler handler) {
        super(handler);
        world=new World(handler,"res/world/world-1.txt");
        handler.setWorld(world);
        player=handler.getWorld().getEntityManager().getPlayer() ;
        player.setX(510);
        player.setY(700);
        dimension=new Dimension(handler,450,330);
        handler.getWorld().getEntityManager().getEntities().removeAll(handler.getWorld().getEntityManager().getEntities());
        handler.getWorld().getEntityManager().addEntity(player);
        handler.getWorld().getEntityManager().addEntity(dimension);
        for(int i=0;i<420;i+=70){
            for(int j=500;j<800;j+=40){
                handler.getWorld().getEntityManager().addEntity(new Tree(handler,i,j));
            }
        }
        for(int i=530;i<1100;i+=70){
            for(int j=500;j<800;j+=40){
                handler.getWorld().getEntityManager().addEntity(new Tree(handler,i,j));
            }
        }
    }

    @Override
    public void tick() {
        world.tick();
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
    public void MessageFrame(){
        button.setBounds(0,0,100,50);
        button.setIcon(new ImageIcon("res/texture/ok.png"));
        JPanel panel =new JPanel();
        panel.setLayout(null);
        panel.setBounds(200,430,100, 50);
        panel.add(button);
        messageframe.setSize(500, 500);
        messageframe.add(panel);
        messageframe.add(new JLabel(new ImageIcon("res/texture/thm.png")));
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
    }


}
