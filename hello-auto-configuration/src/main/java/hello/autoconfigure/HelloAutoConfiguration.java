package hello.autoconfigure;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import third.party.hello.ConsoleHelloService;
import third.party.hello.HelloService;

@Configuration
@ConditionalOnClass(HelloService.class)
@EnableConfigurationProperties(HelloProperties.class) // if that auto-config can be taken, or if the conditions defined here are matched then please create a bean for me
public class HelloAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public HelloService helloService(HelloProperties properties) { // and I can use the bean to inject it to this method
        return new ConsoleHelloService(
                properties.getPrefix(),
                properties.getSuffix()
        );
    }
}
