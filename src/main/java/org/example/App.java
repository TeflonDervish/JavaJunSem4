package org.example;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Db.connetcDb();

        Person person = new Person("Ivan", "Ivanov", 40);

        Db.addPerson(person);

        Db.getAllPerson().forEach(System.out::println);



    }
}
