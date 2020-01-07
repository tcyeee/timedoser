package demo.tcyeee.entity.vo;

import lombok.Data;

/**
 * @author huxiong
 * @date 2020/1/7 16:53
 */
@Data
public class AdminIndexCountVo {
    private int allUserCount;               // 总用户数量
    private int yesterdayCount;             // 昨日新增用户数量
    private int yesterdayUsedCount;         // 昨日活跃账号统计
    private int yesterdayCreatTimeCount;    // 昨日学习时间统计
}
