package demo.tcyeee.service.impl;

import demo.tcyeee.entity.vo.AdminIndexCountVo;
import demo.tcyeee.mapper.AdminIndexMapper;
import demo.tcyeee.service.AdminIndexService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author tcyeee
 * @date 2020/1/7 16:54
 */
@Service
public class AdminIndexServiceImpl implements AdminIndexService {

    @Resource
    private AdminIndexMapper adminIndexMapper;


    @Override
    public AdminIndexCountVo getCount() {
        return adminIndexMapper.getCount();
    }
}
