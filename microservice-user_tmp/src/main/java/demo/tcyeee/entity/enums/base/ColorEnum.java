package demo.tcyeee.entity.enums.base;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 项目中的颜色设置
 *
 * @author tcyeee
 * @date 2020/1/17 16:44
 */
@Getter
@AllArgsConstructor
public enum ColorEnum {

    /* 标准色 */
    red(0, "red"),
    orange(1, "orange"),
    yellow(2, "yellow"),
    olive(3, "olive"),
    green(4, "green"),
    cyan(5, "cyan"),
    blue(6, "blue"),
    purple(7, "purple"),
    mauve(8, "mauve"),
    pink(9, "pink"),
    brown(10, "brown"),
    grey(11, "grey"),
    black(12, "black"),
    darkGray(13, "darkGray"),
    gray(14, "gray"),
    ghostWhite(15, "ghostWhite"),

    /* 浅色 */
    redLight(17, "redLight"),
    orangeLight(18, "orangeLight"),
    yellowLight(19, "yellowLight"),
    oliveLight(20, "oliveLight"),
    greenLight(21, "greenLight"),
    cyanLight(22, "cyanLight"),
    blueLight(23, "blueLight"),
    purpleLight(24, "purpleLight"),
    mauveLight(25, "mauveLight"),
    pinkLight(26, "pinkLight"),
    brownLight(27, "brownLight"),
    greyLight(28, "greyLight");


    private int index;
    private String name;
}
