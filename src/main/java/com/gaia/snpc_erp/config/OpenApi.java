package com.gaia.snpc_erp.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApi {

    @Bean
    public OpenAPI customOpenAPI() {
        Server server = new Server();
        server.setDescription("LOCAL ENV");
        server.setUrl("http://localhost:8888/api");

        Contact contact = new Contact();
        contact.setName("GAIA SARL");
        contact.setEmail("gaia@gaia.cm");

        Info info = new Info();
        info.title("SNPC-ERP SERVICE API");
        info.contact(contact);
        info.setVersion("v1.0");
        info.setDescription("Cette API expose touts les endpoints de la plateforme SNPC-ERP.");

        return new OpenAPI().info(info).servers(List.of(server));
    }
}
