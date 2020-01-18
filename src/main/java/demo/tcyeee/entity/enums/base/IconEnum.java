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
    emoji(2, "emoji"),
    favor(3, "favor"),
    loading(4, "loading"),
    roundcheck(6, "roundcheck"),
    search(8, "search"),
    time(10, "time"),
    warn(11, "warn"),
    camera(12, "camera"),
    like(13, "like"),
    deliver(15, "deliver"),
    evaluate(16, "evaluate"),
    send(17, "send"),
    shop(18, "shop"),
    ticket(19, "ticket"),
    discover(21, "discover"),
    footprint(25, "footprint"),
    cart(28, "cart"),
    remind(29, "remind"),
    lock(33, "lock"),
    goods(35, "goods"),
    selection(36, "selection"),
    explore(37, "explore"),
    present(38, "present"),
    round(40, "round"),
    game(41, "game"),
    vipcard(43, "vipcard"),
    light(45, "light"),
    notice(48, "notice"),
    upstage(49, "upstage"),
    baby(50, "baby"),
    clothes(52, "clothes"),
    creative(53, "creative"),
    female(54, "female"),
    male(55, "male"),
    rank(56, "rank"),
    bad(57, "bad"),
    cameraadd(58, "cameraadd"),
    focus(59, "focus"),
    file(62, "file"),
    attention(63, "attention"),
    read(65, "read"),
    magic(67, "magic"),
    tag(68, "tag"),
    all(69, "all"),
    write(72, "write"),
    crown(74, "crown"),
    musicfill(76, "musicfill"),
    record(77, "record"),
    cardboard(78, "cardboard"),
    mail(79, "mail"),
    goodsnew(80, "goodsnew"),
    medal(81, "medal"),
    newshot(82, "newshot"),
    news(83, "news"),
    skin(84, "skin"),
    usefull(85, "usefull");

    private int index;
    private String name;
}
