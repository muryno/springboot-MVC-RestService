package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class VersionController {

    @Value("${app.version}")
    public String getVer;

    @GetMapping
    @RequestMapping("/")
    public Map<String,String> getVersion(){
        Map<String,String>  mapVersion = new HashMap<>();
        mapVersion.put("app-version", getVer);

        return mapVersion;
    }
}
