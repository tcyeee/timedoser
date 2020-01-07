package demo.tcyeee.service;

import demo.tcyeee.entity.vo.AdminIndexCountVo;
import org.springframework.stereotype.Service;

/**
 * @author huxiong
 * @date 2020/1/7 16:54
 */
@Service
public interface AdminIndexService {
    /**
     * 获取统计数据
     *
     * @return count
     */
    AdminIndexCountVo getCount();
}
