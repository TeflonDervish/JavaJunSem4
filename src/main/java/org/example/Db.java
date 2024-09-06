package org.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class Db {

    private static Connector connector;


    public static void connetcDb() {

        connector = new Connector();

    }

    public static void addPerson(Person person) {

        try (Session session = connector.getSession();) {
            session.beginTransaction();
            session.save(person);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);

        }

    }

    public static void addAllPerson(List<Person> personList) {

        try (Session session = connector.getSession()) {
            session.beginTransaction();
            personList.forEach(x -> session.save(x));
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static List<Person> getAllPerson() {

        try (Session session = connector.getSession()) {

            return session.createQuery("FROM Person", Person.class).getResultList();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteAll() {
        try (Session session = connector.getSession()) {
            Transaction t = session.beginTransaction();
            List<Person> books = session.createQuery("FROM Person",
                    Person.class).getResultList();
            books.forEach(b -> {
                session.delete(b);
            });
            t.commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
