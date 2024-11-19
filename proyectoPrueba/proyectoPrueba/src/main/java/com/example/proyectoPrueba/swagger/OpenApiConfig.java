/**
 * 
 */
package com.example.proyectoPrueba.swagger;

/*import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;*/

/**
 * <b>Descripción:</b> Clase correspondiente al swagger de la app
 * @author roger
 *
 */
/*@Configuration
public class OpenApiConfig implements WebMvcConfigurer{
	
	@Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Usuario AppJAVA21").version("1.0").description("Api de prueba usando java21 que consta de registrar usuarios con sus atributos requeridos"));
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/swagger-ui.html");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

}*/

/*@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Mi API")
                                .version("1.0.0")
                                .description("Documentación de mi API RESTful que expone los servicios para gestionar recursos"));
    }
}*/


/*@Configuration
public class OpenApiConfig {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public")
                .pathsToMatch("/api/**") // Define qué rutas incluir en la documentación
                .build();
    }
}*/




/*@Configuration
public class OpenApiConfig {

    @Bean
    public GroupedOpenApi securityApi() {
        return GroupedOpenApi.builder()
                .group("security")
                .pathsToMatch("/api/**")
                //.addOpenApiCustomizer(openApi -> openApi
                .addOpenApiCustomiser(openApi -> openApi
                    .components(new io.swagger.v3.oas.models.Components())
                    .addSecurityItem(new io.swagger.v3.oas.models.security.SecurityRequirement()
                        .addList("bearerAuth")))
                .build();
    }
}*/




/*@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info().title("My API").version("1.0").description("API Documentation"));
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
            .group("public")
            .pathsToMatch("/api/**") // Ajusta las rutas de la API que deseas incluir
            .build();
    }
}*/
