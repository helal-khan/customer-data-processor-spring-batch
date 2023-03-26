package io.helal.customerdataprocessor.configuration.mapper;

import io.helal.customerdataprocessor.configuration.mapper.impl.MapperRegistryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public MapperRegistry mapperRegistry() {
        return new MapperRegistryImpl();
    }
}
