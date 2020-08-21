package com.gfpz.snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements KeyListener {

    int lenth;//蛇的长度
    int[] snakeX = new int[600];//蛇的坐标
    int[] snakeY = new int[500];
    String fx;// R L  U  D  方向
    boolean isStart = false;//游戏是否开始

    //初始化
    public void init(){
        lenth = 3;
        snakeX[0] = 100;snakeY[0] = 100;//头部坐标
        snakeX[1] = 75;snakeY[1] = 100;//第一个身体坐标
        snakeX[2] = 50;snakeY[2] = 100;//第二个身体坐标
        fx = "R";
    }

    //构造器  调 初始化方法
    public GamePanel() {
        init();
        //获取键盘的监听事件
        //this.s
    }

    //画板：画界面，画🐍
    //Graphics 画笔
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);//清屏
        this.setBackground(Color.WHITE);//设置背景颜色
        //绘制头部 广告
        Data.header.paintIcon(this, g, 25, 11);
        //绘制游戏区域
        g.fillRect(25, 75, 850, 600);
        //画一条静态的蛇
        if(fx.equals("R")){
            Data.right.paintIcon(this,g,snakeX[0],snakeY[0]);
        }else if(fx.equals("L")){
            Data.left.paintIcon(this,g,snakeX[0],snakeY[0]);
        }else if(fx.equals("U")){
            Data.up.paintIcon(this,g,snakeX[0],snakeY[0]);
        }else if(fx.equals("D")){
            Data.down.paintIcon(this,g,snakeX[0],snakeY[0]);
        }
        for (int i = 1; i < lenth; i++) {
            Data.body.paintIcon(this,g,snakeX[i],snakeY[i]);
        }

        //游戏是否开始
        if (false == isStart) {
            //画一段文字
            g.setColor(Color.WHITE);
            g.setFont(new Font("微软雅黑", Font.BOLD, 40));
            g.drawString("按下空格开始游戏。", 300, 300);

        }
    }

    //监听键盘的输入  要求类需要实现 KeyListener 接口
    //并重写如下方法

    /**
     * 键盘按下 未释放
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {
        //获取键盘是哪个键
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_SPACE) {
            isStart = !isStart;//！！！
            repaint();//刷新界面！！！
        }


    }






    @Override
    public void keyTyped(KeyEvent e) {
        //键盘按下 弹起
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //释放某个键
    }
}
