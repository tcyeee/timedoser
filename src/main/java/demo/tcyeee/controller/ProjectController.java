package demo.tcyeee.controller;

import demo.tcyeee.entity.po.Project;
import demo.tcyeee.service.ProjectService;
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


    @PostMapping("save")
    public String save(@RequestBody Project project) {
        return creatStatusResponse(projectService.save(project));
    }

    @GetMapping("findAll")
    public String findAll() {
        return creatJsonResponse(projectService.findAll());
    }

    @GetMapping("deleteOne")
    public String deleteOne(Integer id) {
        if (id == null) return creatErrResponse(PARAMS_ERROR_INFO);
        return creatStatusResponse(projectService.deleteOne(id));
    }
}
