package hello.autoconfigure;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import third.party.hello.ConsoleHelloService;
import third.party.hello.HelloService;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloAutoConfigurationTest {

    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner()
            .withConfiguration(AutoConfigurations.of(HelloAutoConfiguration.class));

    @Test
    public void defaultServiceIsAutoConfigured() {
        this.contextRunner
                .withPropertyValues("hello.prefix=Test")
                .run(context -> {
                    assertThat(context).hasSingleBean(HelloService.class);
                    assertThat(context.getBean(HelloService.class).sayHello("World")).isEqualTo("Test World!");
                });
    }

    @Test
    public void defaultServiceBacksOff() {
        this.contextRunner
                .withUserConfiguration(UserConfiguration.class)
                .run(context -> {
                    assertThat(context).hasSingleBean(HelloService.class);
                    assertThat(context.getBean(HelloService.class).sayHello("Works")).isEqualTo("Mine Works**");
                });
    }

    @Configuration
    static class UserConfiguration {

        @Bean
        public HelloService myHelloService() {
            return new ConsoleHelloService("Mine", "**");
        }
    }

}
