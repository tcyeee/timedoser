package demo.tcyeee.controller.setting;

import demo.tcyeee.entity.base.FixedInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenyueee
 * @since 2019/11/9 23:32
 */
@RestController
@RequestMapping("setting")
public class SettingController {

    @GetMapping("test")
    public String test() {
        return FixedInfo.linkTest;
    }
}
