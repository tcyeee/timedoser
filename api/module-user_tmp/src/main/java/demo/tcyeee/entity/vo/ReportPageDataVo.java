package demo.tcyeee.entity.vo;

import demo.tcyeee.controller.report.ReportController;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * report页面初始化时候需要的数据
 *
 * @author chenyueee
 * @see ReportController#pageData()
 * @since 2019-09-22 20:17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportPageDataVo {

    private BigDecimal dayCount;       // 今日学习时间
    private BigDecimal weekCount;      // 本周学习时间
    private BigDecimal allCount;       // 总计学习时间
}
