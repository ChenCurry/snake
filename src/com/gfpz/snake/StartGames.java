package com.gfpz.snake;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * 这个类的作用就是绘制一个窗口，然后把panel面板显示在上面即可
 */
public class StartGames {
    public static void main(String[] args) {
        //绘制静态窗口 JFrame
        JFrame frame = new JFrame("贪吃蛇🐍");
        //设置界面大小
        frame.setBounds(10, 10, 900, 720);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(Data.tb.getImage());
        //面板JPanel  可以加入到JFrame窗口
        frame.add(new GamePanel());
        frame.setVisible(true);
    }
}
