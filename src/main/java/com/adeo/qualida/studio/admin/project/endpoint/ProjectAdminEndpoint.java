package com.adeo.qualida.studio.admin.project.endpoint;

import com.adeo.qualida.studio.admin.project.model.Project;
import com.adeo.qualida.studio.admin.project.service.AdminProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/admin/project")
@RequiredArgsConstructor
public class ProjectAdminEndpoint {
    private final AdminProjectService projectService;

    @GetMapping("/")
    public List<Project> getProjectInfo() {
        return projectService.getProjectInfo();
    }
}
