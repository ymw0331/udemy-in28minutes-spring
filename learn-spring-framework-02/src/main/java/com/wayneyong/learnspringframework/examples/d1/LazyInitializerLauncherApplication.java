package com.wayneyong.learnspringframework.examples.d1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class ClassA {
}

@Component
class ClassB {
    private ClassA classA;

    public ClassB(ClassA classA) {
        // Logic
        System.out.println("Some Initialization logic");
        this.classA = classA;
    }
}

@Configuration
@ComponentScan("com.wayneyong.learnspringframework.examples.d1")
public class LazyInitializerLauncherApplication {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(LazyInitializerLauncherApplication.class)) {
            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);
        }
    }
}
