package Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

/**
 * author liulei
 * data
 * since 1.8
 * version 1.0
 * Description
 */
public class GameJpanel extends JPanel implements KeyListener, ActionListener {//画板：花界面和蛇
    static  int length;
    int [] snakex = new int[600];
    int [] snakey = new int[500];
    String fx = "R";//方向
    boolean isstart = false;
    //死亡判断
    boolean isFail = false;
    int score;
  int ss = 0;
    Timer timer = new Timer(200,this);//定时器，对事件监听
    int foodx;
    int foody;
    Random random = new Random();
    public void init(){//初始蛇和食物的位置
        length = 3;
        snakex[0] = 100;snakey[0] = 100;
        snakex[1] = 75;snakey[1] = 100;
        snakex[2] = 50;snakey[2] = 100;
        fx = "R";
        foodx = 25 + 25*random.nextInt(34);
        foody = 75 + 25*random.nextInt(24);
        //isstart = true;
        score = 0;
    }

    public GameJpanel() {
        init();
        //获取键盘的监听事件
        this.setFocusable(true);//获取当前鼠标的焦点
        this.addKeyListener(this);//键盘监听类加载进来
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {//对整个界面进行渲染，使用repaint()进行再次渲染
        super.paintComponent(g);
        System.out.println(ss++);
        this.setBackground(Color.white);
        Data.header.paintIcon(this,g,25,11);
        //绘制游戏区域
        g.fillRect(25,75,850,575);
        if(fx.equals("R")){//头的方向
            Data.right.paintIcon(this,g,snakex[0],snakey[0]);
        }if(fx.equals("L")){
            Data.left.paintIcon(this,g,snakex[0],snakey[0]);
            //System.out.println(fx);
        }if(fx.equals("U")){
            Data.up.paintIcon(this,g,snakex[0],snakey[0]);
        }if(fx.equals("D")){
            Data.down.paintIcon(this,g,snakex[0],snakey[0]);
        }
        //画一条静态的蛇
       // Data.right.paintIcon(this,g,snakex[0],snakey[0]);
        for (int i = 1; i < length; i++) {//蛇的身体
            Data.body.paintIcon(this,g,snakex[i],snakey[i]);
        }
        //画积分和长度
        g.setColor(Color.white);
        g.setFont(new Font("微软雅黑",Font.BOLD,15));
        g.drawString("长度:"+length,750,35);
        g.drawString("得分:"+score,750,50);
        Data.food.paintIcon(this,g,foodx,foody);
        if(isstart == false){//还没开始
            g.setColor(Color.yellow);
            g.setFont(new Font("微软雅黑",Font.BOLD,40));
            g.drawString("按下空格开始游戏",300,300);

        }
        if(isFail == true){//失败
            g.setColor(Color.yellow);
            g.setFont(new Font("微软雅黑",Font.BOLD,40));
            g.drawString("游戏失败，按下空格重新开始",300,300);
        }
    }
    //监听键盘的输入

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {//监听键盘事件
        //如果游戏开始处于开始，并且没有结束
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            if(isFail){
                isFail = false;
                init();
            }else{//暂停游戏
                isstart = !isstart;
            }

            repaint();//刷新界面
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            fx = "R";
        }if(e.getKeyCode() == KeyEvent.VK_LEFT){
            fx = "L";
        }if(e.getKeyCode() == KeyEvent.VK_UP){
            fx = "U";
        }if(e.getKeyCode() == KeyEvent.VK_DOWN){
            fx = "D";
        }
    }
    //结束判断

    @Override
    public void keyReleased(KeyEvent e) {
    }
    @Override
    public void actionPerformed(ActionEvent e) {//每个事件周期内触发一次
        if(isstart && isFail == false){//如果游戏处于开始状态
            for (int i = length-1; i > 0 ; i--) {//后一个移到前一个位置
                snakex[i] = snakex[i-1];
                snakey[i] = snakey[i-1];
            }
           // snakex[0] = snakex[0]+25;//头部移动
            if(fx.equals("R")){
                snakex[0] = snakex[0]+25;//头部移动
                if(snakex[0]>850){
                    snakex[0] = 25;
                }
            }
            if(fx.equals("L")){
                snakex[0] = snakex[0]-25;//头部移动
                if(snakex[0] < 25){
                    snakex[0] = 850;
                }
            }if(fx.equals("U")){
                snakey[0] = snakey[0]-25;//头部移动
                if(snakey[0] < 75){
                    snakey[0] = 600;
                }
            }if(fx.equals("D")){
                snakey[0] = snakey[0]+25;//头部移动
                if(snakey[0] >625){
                    snakey[0] = 75;
                }
            }
            if(snakex[0] == foodx && foody == snakey[0]){//吃食物
                length ++;
                score += 10;
                foodx = 25 + 25*random.nextInt(30);
                foody = 75 + 25*random.nextInt(20);
            }
            for (int i = 1; i < length; i++) {
                if(snakex[0] == snakex[i] && snakey[i] ==snakey[0]){
                    isFail = true;
                    //isstart =false;
                }
            }
            repaint();//刷新界面
        }
        timer.start();//让时间动起来
    }
    //
}
