package com.States;

import com.Entities.Creature.Player;
import com.Entities.Static.Dimension;
import com.Entities.Static.Stair;
import com.Main.Handler;
import com.World.World;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class GameState_2 extends State{
    public static int l=0;
    public static JFrame messageframe=new JFrame();
    public JButton button=new JButton("OK");
    private World world;
    public static Player player;
    public static Dimension dimension;

    public GameState_2(Handler handler){
        super(handler);
        world=new World(handler,"res/world/world-3.txt");
        handler.setWorld(world);
        player=handler.getWorld().getEntityManager().getPlayer();
        dimension=new Dimension(handler,800,100);
        handler.getWorld().getEntityManager().getEntities().removeAll(handler.getWorld().getEntityManager().getEntities());
        handler.getWorld().getEntityManager().addEntity(player);
        handler.getWorld().getEntityManager().addEntity(dimension);
        handler.getWorld().getEntityManager().addEntity(new Stair(handler,330,130,1));
        handler.getWorld().getEntityManager().addEntity(new Stair(handler,330,250,2));
        handler.getWorld().getEntityManager().addEntity(new Stair(handler,330,520,3));
        handler.getWorld().getEntityManager().addEntity(new Stair(handler,330,660,4));
        handler.getWorld().getEntityManager().addEntity(new Stair(handler,330,830,5));
        handler.getWorld().getEntityManager().addEntity(new Stair(handler,330,950,6));
        handler.getWorld().getEntityManager().addEntity(new Stair(handler,680,120,7));
        handler.getWorld().getEntityManager().addEntity(new Stair(handler,680,260,8));
        handler.getWorld().getEntityManager().addEntity(new Stair(handler,700,520,9));
        handler.getWorld().getEntityManager().addEntity(new Stair(handler,700,660,10));
        handler.getWorld().getEntityManager().addEntity(new Stair(handler,700,830,11));
        handler.getWorld().getEntityManager().addEntity(new Stair(handler,700,950,12));


    }

    public void tick() {
        world.tick();
    }

    public void render(Graphics g) {

        world.render(g);
        if(l==0) {
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
//                    JOptionPane.showMessageDialog(null, "", "Follow the Instruction", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("E:\\Game-01\\res\\texture\\bfsm.png"));
                    MessageFrame();
                    messageframe.setVisible(true);
                    AddButtonActionListener();
                }
            }, 600L);
            l++;
        }

    }

    public static Player getPlayer() {
        return player;
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
        messageframe.add(new JLabel(new ImageIcon("res/texture/bfsm.png")));
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
