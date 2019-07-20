package demo.tcyeee.utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 图片工具，生成验证码图片，压缩图片。
 *
 * @author tcyeee
 */

@SuppressWarnings("unused")
public class ImageChenkUtil {
    private static final String CHAR_RANGE = "ABCDEFGHJKMNPQRSTUVWXY023456789";
    private static final int SIZE = 4;
    private static final int LINES = 6;
    private static final int WIDTH = 120;
    private static final int HEIGHT = 40;
    private static final int FONT_SIZE = 10;

    /**
     * 生成验证码图片
     *
     * @return spring and img
     */
    public static Map<String, BufferedImage> getImage() {
        StringBuilder sb = new StringBuilder();
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics graphic = image.getGraphics();
        graphic.setColor(Color.WHITE);
        graphic.fillRect(0, 0, WIDTH, HEIGHT);
        Random ran = new Random();
        for (int i = 1; i <= SIZE; i++) {
            char c = CHAR_RANGE.charAt(ran.nextInt(CHAR_RANGE.length()));
            graphic.setColor(getRandomColor(ran));
            graphic.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, ran.nextInt(FONT_SIZE) + 23));
            graphic.drawString(String.valueOf(c), (i - 1) * WIDTH / SIZE + 1, HEIGHT - 3);
            sb.append(c);
        }
        for (int i = 1; i <= LINES; i++) {
            graphic.setColor(getRandomColor(ran));
            graphic.drawLine(ran.nextInt(WIDTH), ran.nextInt(HEIGHT), ran.nextInt(WIDTH), ran.nextInt(HEIGHT));
        }
        Map<String, BufferedImage> map = new HashMap<>();
        map.put(sb.toString(), image);
        return map;
    }

    private static Color getRandomColor(Random r) {
        return new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));

    }

    public static String createRandom() {
        char[] rands = new char[4];
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            rands[i] = CHAR_RANGE.charAt(random.nextInt(31));
        }
        return new String(rands);
    }

    public static void drawBackground(Graphics g) {
        // 画背景
        g.setColor(getRandomColor(new Random()));
        g.fillRect(0, 0, WIDTH, HEIGHT);

        // 随机产生 120 个干扰点
        for (int i = 0; i < 150; i++) {
            int x = (int) (Math.random() * WIDTH);
            int y = (int) (Math.random() * HEIGHT);
            int red = (int) (Math.random() * 255);
            int green = (int) (Math.random() * 255);
            int blue = (int) (Math.random() * 255);

            g.setColor(new Color(red, green, blue));
            g.drawOval(x, y, 1, 0);
        }
    }

    public static void drawRands(Graphics g, String rands) {
        g.setColor(Color.BLACK);
        g.setFont(new Font(null, Font.ITALIC | Font.BOLD, 28));

        // 在不同的高度上输出验证码的每个字符
        g.drawString("" + rands.charAt(0), 1, 27);
        g.drawString("" + rands.charAt(1), 26, 25);
        g.drawString("" + rands.charAt(2), 48, 28);
        g.drawString("" + rands.charAt(3), 71, 26);
    }
}
