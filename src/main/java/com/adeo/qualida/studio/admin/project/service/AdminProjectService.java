package com.adeo.qualida.studio.admin.project.service;

import com.adeo.qualida.studio.admin.project.model.Project;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdminProjectService {
    private final ObjectMapper mapper;
    private List<Project> projects;

    @Value("classpath:/static/project.json")
    private Resource resource;

    @PostConstruct
    @SneakyThrows
    private void onLoad() {
        projects = Arrays.asList(mapper.readValue(resource.getURL(), Project[].class));
        log.info("projects loaded:\n{}", mapper.writerWithDefaultPrettyPrinter().writeValueAsString(projects));
    }

    public List<Project> getProjectInfo() {
        return projects;
    }
}
