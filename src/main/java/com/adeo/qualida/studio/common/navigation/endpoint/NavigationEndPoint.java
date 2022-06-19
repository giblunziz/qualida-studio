package com.adeo.qualida.studio.common.navigation.endpoint;

import com.adeo.qualida.studio.common.navigation.model.ApplicationModule;
import com.adeo.qualida.studio.common.navigation.service.ModuleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/nav")
@Slf4j
@RequiredArgsConstructor
public class NavigationEndPoint {
    private final ModuleService moduleService;

    /**
     [
        {
            "name": "admin",
            "controller": "api/admin",
            "_enabled": true|false,
            "auth": "public|role_name"
        }
     ]


     *
     * @return*/

    @GetMapping("/")
    public List<ApplicationModule> getModuleInfo() {
         log.info("/module");
        return moduleService.getModulesInfo();
    }
}
