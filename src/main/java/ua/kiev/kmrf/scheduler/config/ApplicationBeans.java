package ua.kiev.kmrf.scheduler.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationBeans {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}