package Snake;

import javax.swing.*;
import java.net.URL;

/**
 * author liulei
 * data
 * since 1.8
 * version 1.0
 * Description
 */
public class Data {
    public static URL headerURL = Data.class.getResource("/pic/header.png");
    public static URL upURL = Data.class.getResource("/pic/up.png");
    public static URL downURL = Data.class.getResource("/pic/down.png");
    public static URL leftURL = Data.class.getResource("/pic/left.png");
    public static URL rightURL = Data.class.getResource("/pic/right.png");
    public static URL bodyUrl = Data.class.getResource("/pic/body.png");
    public static URL foodurl = Data.class.getResource("/pic/food.png");
    public static ImageIcon header = new ImageIcon(headerURL);
    public static ImageIcon up = new ImageIcon(upURL);
    public static ImageIcon down = new ImageIcon(downURL);
    public static ImageIcon left = new ImageIcon(leftURL);
    public static ImageIcon right = new ImageIcon(rightURL);
    public static ImageIcon body = new ImageIcon(bodyUrl);
    public static ImageIcon food = new ImageIcon(foodurl);



}
