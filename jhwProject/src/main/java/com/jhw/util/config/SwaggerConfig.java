package com.jhw.util.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;

/**
 * Swagger配置
 * @author Administrator
 *
 */
@Configuration
@EnableSwagger
@EnableWebMvc
public class SwaggerConfig {

	private SpringSwaggerConfig springSwaggerConfig;  
	  
    /** 
     * Required to autowire SpringSwaggerConfig 
     */  
    @Autowired  
    public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig)  
    {  
        this.springSwaggerConfig = springSwaggerConfig;  
    }
  
    /** 
     * Every SwaggerSpringMvcPlugin bean is picked up by the swagger-mvc 
     * framework - allowing for multiple swagger groups i.e. same code base 
     * multiple swagger resource listings. 
     */  
    @Bean  
    public SwaggerSpringMvcPlugin customImplementation()  
    {  
        return new SwaggerSpringMvcPlugin(this.springSwaggerConfig)  
                .apiInfo(apiInfo())  
                .includePatterns(".*?");  
    }  
  
    private ApiInfo apiInfo()  
    {  
        ApiInfo apiInfo = new ApiInfo(  
        		"江湖味系统API",
                "前后端接口API管理",
                "无",
                "291529461@qq.com",
                "无",
                "无");
        return apiInfo;  
    }
    
}
