package demo.tcyeee.controller.project;

import demo.tcyeee.entity.po.Project;
import demo.tcyeee.service.ProjectService;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import static demo.tcyeee.utils.ResponseUtils.*;

/**
 * @author chenyueee
 * @since 2020/1/20 22:58
 */
@RestController
@RequestMapping("project")
public class ProjectController {

    @Resource
    private ProjectService projectService;


    @RequestMapping("save")
    public String save(Project project) {
        if (StringUtils.isBlank(project.getName())) return creatErrResponse(PARAMS_ERROR_INFO + "name");
        return creatStatusResponse(projectService.save(project));
    }

    @GetMapping("findAll")
    public String findAll() {
        return creatJsonResponse(projectService.findAll());
    }

    @GetMapping("deleteOne")
    public String deleteOne(String id) {
        if (id == null) return creatErrResponse(PARAMS_ERROR_INFO + "id");
        return creatStatusResponse(projectService.deleteOne(id));
    }
}
