package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Db.connetcDb();

        Db.deleteAll();

        Person person = new Person("Ivan", "Ivanov", 40);

        List<Person> personList = new ArrayList<Person>() {{
           add(new Person("Oleg", "2" , 3));
            add(new Person("Kirill", "2" , 4));
            add(new Person("Afanasiy", "2" , 5));
        }};


        Db.addPerson(person);
        Db.addAllPerson(personList);

        Db.getAllPerson().forEach(System.out::println);



    }
}
