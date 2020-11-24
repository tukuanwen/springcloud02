package com.tu.cloud02.services;

import com.tu.cloud02.handler.CommonHandler;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(value = "sentinel-openFeign-server")
public interface SentinelProviderServices {

    @GetMapping("/provider/dohello")
    public String doSOHello();
}
