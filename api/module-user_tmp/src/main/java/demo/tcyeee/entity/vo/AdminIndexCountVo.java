package demo.tcyeee.entity.vo;

import lombok.Data;

/**
 * @author tcyeee
 * @date 2020/1/7 16:53
 */
@Data
public class AdminIndexCountVo {
    private int allUserSum;            // 总用户数量

    private int userAdd;               // 昨日新增用户
    private int exUserAdd;             // 前天新增用户

    private int yesUsedSum;            // 昨日活跃账号统计
    private int exYesUsedSum;          // 前天活跃账号统计

    private int workSum;               // 昨日学习时间统计
    private int exWorkSum;             // 前天学习时间统计

}
