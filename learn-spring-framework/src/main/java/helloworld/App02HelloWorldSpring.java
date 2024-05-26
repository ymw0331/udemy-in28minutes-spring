package helloworld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {

    public static void main(String[] args) {

        // 1. Launch a Spring Context
        try (var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)) {
            // 2. Configure the things that we want Spring to manage -
            // HelloWorldConfiguration -  @Configuration
            // name - @Bean
            // 3. Retrieving Beans managed by Spring (bean name or class name)
            System.out.println(context.getBean("name"));
            System.out.println(context.getBean("age"));
            System.out.println(context.getBean("person"));
            System.out.println(context.getBean("person2MethodCall"));
            System.out.println(context.getBean("person3Parameters"));
            System.out.println(context.getBean("address2"));
            System.out.println(context.getBean(Person.class));
            System.out.println(context.getBean(Address.class));
            System.out.println(context.getBean("person5Qualifier"));
            // What if multiple matching beans are available? Which one should Spring use?
            // Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out:: println);
        }
    }
}


/**
 * Spring Question You Might Be Thinking About:
 * 1. Spring Container vs Spring Context vs IOC Container vs Application Context
 * Spring Container : Manages Spring beans & their lifecycle
 * eg: HelloWorldConfig contains all the definitions of the beans,
 * - inputs to create Spring container (POJOS + config => IOC Container => Ready System)
 * - output is the ready system, inside JVM contains Spring Context that manages all the beans
 * - once created Java Classes and configuration, IOC container create a runtime system for us (Spring context and all beans)
 * <p>
 * Two types of Containers:
 * i. Bean Factory: Basic Spring Container
 * ii. Application Context: Advanced Spring Container with enterprise-specific features
 * - easy to use in web applications
 * - easy i18n
 * - easy integration with Spring AOP
 * <p>
 * <p>
 * 2. Java Beans vs Spring Beans
 * Java Bean : Claasses adhering to 3 contraints:
 * - Have public default (no arguments) constructors
 * - Allow access to their properties using getter and setter methods
 * - Implements java.io.Serializable
 * <p>
 * POJO: Plain Old Java Objects
 * - No  contraints
 * - Any Java Object is a POJO
 * <p>
 * Spring Bean: Any Java Ojbect that is managed by Spring
 * - Spring uses IOC container (Bean Factory or Application Context) to manage these objects
 * <p>
 * 3. How can I list all beans managed by Spring Framework?
 * Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out:: println);
 * <p>
 * <p>
 * 4. What if multiple matching beans are available? Which one should Spring use?
 * <p>
 * <p>
 * <p>
 * 5. Spring is managing objects and performing auto-wiring.
 * - But arent we writing the code to create objects?
 * - How do we get Spring to create objects for us?
 */
