package helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

//New feature in jdk 16
//Eliminate verbosity in creating Java Beans
//Equals, hashcode and toString are automatically created
record Person(String name, int age, Address adress) {
};

record Address(String firstLine, String city) {
};

@Configuration
public class HelloWorldConfiguration {
    @Bean
    public String name() {
        return "Wayne";
    }

    @Bean
    public int age() {
        return 20;
    }

    @Bean
    public Person person() {
        return new Person("Way", 28, new Address("Flusing Main Street", "Queens, NYC"));
    }

    @Bean
    public Person person2MethodCall() {
        return new Person(name(), age(), address()); //name, age
    }

    @Bean
    public Person person3Parameters(String name, int age, Address address3) { //name, age, address2
        return new Person(name, age, address3); //name, age
    }

    @Bean
    @Primary
    public Person person4Parameters(String name, int age, Address address) { //name, age, address2
        return new Person(name, age, address); //name, age
    }

    @Bean
    @Primary
    public Person person5Qualifier(String name, int age, @Qualifier("address3qualifier") Address address) { //name, age, address2
        return new Person(name, age, address); //name, age
    }

    @Bean(name = "address2")
    @Primary
    public Address address() {
        return new Address("28, Jalan Elektron U16/70", "Shah Alam, Selangor DE");
    }

    @Bean(name = "address3")
    @Qualifier("address3qualifier")
    public Address address3() {
        return new Address("Persiaran Lingkaran Shed", "Mid Valley, KL");
    }

}




