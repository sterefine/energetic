package com.sterefine.energetic.bean.config;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * author sterefine
 */
@Configuration
public class BeanConfig {
    @Bean(name = "beanTest")
    public ThirdLibClass getThirdClass() {
        return new ThirdLibClass("f1", "f2");
    }

    @Bean("f1")
    public ThirdLibParam getParam(){
        return new ThirdLibParam(1);
    }

    @Bean("f2")
    public ThirdLibParam getParam2(){
        return new ThirdLibParam(2);
    }

    @Bean
    @Primary
    public ThirdLibClass getService(@Qualifier("f2") ThirdLibParam param) {
        switch (param.getP1()) {
            case 1:
                return new ThirdLibClass("f1", "f2");
            case 2:
                return new ThirdLibClass("f2", "f2");
            case 3:
                return new ThirdLibClass("f3", "f2");
            default:
                return new ThirdLibClass("f0", "f2");
        }
    }
}
