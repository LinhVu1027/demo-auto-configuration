# Simulating auto-configuration

### Usecase:

We have an external lib `hello-service` with its package `third.party.hello`. And we want to create our own lib `starter` that when we add this `starter` as a dependency to our `hello-app` application, this will bring us `hello-service` lib and a default bean of `HelloService.java` and we can configure this bean through declaring its properties like `hello.prefix` and `hello.suffix` in our `application.properties` file. So we won't need to create a bean of `HelloService.java` by ourselves, let it auto-configured.

### Task:
1. Create `hello-auto-configuration` lib:
- In this lib, all the dependencies are `optional` or `test scope`

2. Create `hello-starter` lib:
- In this lib, add `hello-service` third party dependency and `hello-auto-configuration` dependency. So when our `hello-app` add this `starter`, it will have all `HelloService.java` and `HelloService` bean auto-configured as well.

## Reference
- `#1` **It's a Kind of Magic: Under the Covers of Spring Boot - Brian Clozel, Stéphane Nicoll** provided by [**SpringDeveloper youtube channel**](https://www.youtube.com/watch?v=jDchAEHIht0&ab_channel=SpringDeveloper)
- `#2` [**Their github project**](https://github.com/snicoll/hello-service-auto-configuration) 
- `#3` Official Spring Documentation about [**Creating Your Own Auto-configuration**](https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.developing-auto-configuration)