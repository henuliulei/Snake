package Snake;

import javax.swing.*;

/**
 * author liulei
 * data
 * since 1.8
 * version 1.0
 * Description
 */
public class StartGames {
    public static void main(String[] args) {
        //绘制一个静态窗口
        System.out.println(Data.header + "ssss");

        JFrame frame = new JFrame("贪吃蛇小游戏");
        frame.setBounds(10,10,900,720);//设置界面大小
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new GameJpanel());
        frame.setVisible(true);
    }
}
