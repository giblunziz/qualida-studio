package com.adeo.qualida.studio.common.navigation.service;

import com.adeo.qualida.studio.common.navigation.model.ApplicationModule;
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
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ModuleService {
    private final ObjectMapper mapper;

    @Value("classpath:/static/modules.json")
    private Resource resource;
    private List<ApplicationModule> modules;

    @SneakyThrows
    @PostConstruct
    private void onLoad() {
        modules = Arrays.asList(mapper.readValue(resource.getURL(), ApplicationModule[].class));
        log.info("modules loaded: \n{}",mapper.writerWithDefaultPrettyPrinter().writeValueAsString(modules));
    }

    public List<ApplicationModule> getModulesInfo() {
        return modules.stream()
//                .filter(m -> m.isEnabled())
                .collect(Collectors.toList());
    }
}
