package com.States;

import com.Display.Display;
import com.Graphics.Animation;
import com.Graphics.Assets;
import com.Main.Game;
import com.Main.Handler;
import com.Tile.ui.ClickListener;
import com.Tile.ui.UiImageButton;
import com.Tile.ui.UiManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuState extends State{
    private UiManager uiManager;
    public int i=0;
    public static JFrame messageframe=new JFrame();
    public JButton button=new JButton("OK");
    public Animation animation;
    public Rectangle r,a,c;
    public boolean hovering=false,h1=false,h2=false;
    public MenuState(Handler handler) {
        super(handler);
        r=new Rectangle(380,280,120,45);
        a=new Rectangle(380,420,120,45);
        c=new Rectangle(380,350,120,45);
        animation=new Animation(1300,Assets.Maze);

    }

    @Override
    public void tick() {
        animation.tick();
        if(handler.getMouseManager().getP1()==null || handler.getMouseManager().getP()==null) return;
        if(r.contains(handler.getMouseManager().getP1())){
            State.setState(new GameState(handler));
            handler.getMouseManager().setUiManager(handler.getMouseManager().getUiManager());
        }
        if(a.contains(handler.getMouseManager().getP1())){
            System.exit(0);
        }
        if(c.contains(handler.getMouseManager().getP1())){
            if(i==0) {
                MessageFrame();
                messageframe.setVisible((true));
                AddButtonActionListener();
                i++;
            }
        }


        if(r.contains(handler.getMouseManager().getP()))
            hovering=true;
        else hovering=false;
        if(a.contains(handler.getMouseManager().getP()))
            h1=true;
        else h1=false;
        if(c.contains(handler.getMouseManager().getP()))
            h2=true;
        else h2=false;



    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.Maze[5],0,0,900,700,null);
        if(hovering)
            g.drawImage(Assets.button[1],380,280,120,45,null);
        else
            g.drawImage(Assets.button[0],380,280,120,45,null);
        if(h1)
            g.drawImage(Assets.exit[1],380,420,120,45,null);
        else
            g.drawImage(Assets.exit[0],380,420,120,45,null);
        if(h2)
            g.drawImage(Assets.HTP[1],380,350,120,45,null);
        else
            g.drawImage(Assets.HTP[0],380,350,120,45,null);
    }
    public void MessageFrame(){
        button.setBounds(0,0,100,50);
        button.setIcon(new ImageIcon("res/texture/ok.png"));
        JPanel panel =new JPanel();
        panel.setLayout(null);
        panel.setBounds(350,430,100, 50);
        panel.add(button);
        messageframe.setSize(800, 500);
        messageframe.add(panel);
        messageframe.add(new JLabel(new ImageIcon("res/texture/details.png")));
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
