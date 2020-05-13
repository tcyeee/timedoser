package demo.tcyeee.entity.enums.base;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 项目所用到的logo
 *
 * @author huxiong
 * @date 2020/1/17 16:55
 */
@Getter
@AllArgsConstructor
public enum IconEnum {

    appreciate(0, "appreciate"),
    emoji(1, "emoji"),
    favor(2, "favor"),
    loading(3, "loading"),
    roundcheck(4, "roundcheck"),
    search(5, "search"),
    time(6, "time"),
    warn(7, "warn"),
    camera(8, "camera"),
    like(9, "like"),
    deliver(10, "deliver"),
    evaluate(11, "evaluate"),
    send(12, "send"),
    shop(13, "shop"),
    ticket(14, "ticket"),
    discover(15, "discover"),
    footprint(16, "footprint"),
    cart(17, "cart"),
    remind(18, "remind"),
    lock(19, "lock"),
    goods(20, "goods"),
    selection(21, "selection"),
    explore(22, "explore"),
    present(23, "present"),
    round(24, "round"),
    game(25, "game"),
    vipcard(26, "vipcard"),
    light(27, "light"),
    notice(28, "notice"),
    upstage(29, "upstage"),
    baby(30, "baby"),
    clothes(31, "clothes"),
    creative(32, "creative"),
    female(33, "female"),
    male(34, "male"),
    rank(35, "rank"),
    bad(36, "bad"),
    cameraadd(37, "cameraadd"),
    focus(38, "focus"),
    file(39, "file"),
    attention(40, "attention"),
    read(41, "read"),
    magic(42, "magic"),
    tag(43, "tag"),
    all(44, "all"),
    write(45, "write"),
    crown(46, "crown"),
    musicfill(47, "musicfill"),
    record(48, "record"),
    cardboard(49, "cardboard"),
    mail(50, "mail"),
    goodsnew(51, "goodsnew"),
    medal(52, "medal"),
    newshot(53, "newshot"),
    news(54, "news"),
    skin(55, "skin"),
    usefull(56, "usefull");

    private int index;
    private String name;
}
