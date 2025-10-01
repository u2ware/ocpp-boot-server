package io.u2ware.ocpp.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import io.u2ware.ocpp.config.EnableOcppServer;
import io.u2ware.ocpp.config.OcppAttributes;
import io.u2ware.ocpp.OCPPVersion;

@Configuration
@EnableOcppServer(version = OCPPVersion.V2_1)
// @EnableOcppServer(version = OCPPVersion.V2_0_1)
// @EnableOcppServer(version = OCPPVersion.V1_6)
public class OCPPConfig implements WebMvcConfigurer{
    

    @Autowired
    protected OcppAttributes ocppAttributes;


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        String console = ocppAttributes.getOcppBootConsole();
        String viewName = String.format("redirect:%s", console);
        registry.addViewController("/").setViewName(viewName);
    }    


}
