/*
Task 2. (5 points) A person stream
Create:
1. Person class with name and age fields
2. A collection of Persons;
3. Two instances of Comparator interface using lambda expressions: first one for comparing by name, second one – by age
   Then sort them using these comparators.
   Use for Each method for printing information about all the persons.
   Try to use method reference if it is possible.
 */
package lamdas;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Srinivas",24),
                new Person("Kunal",30),
                new Person("Bala",28)
        );

        Comparator<Person> nameComparator =   Comparator.comparing(Person::getName);
        Comparator<Person> ageComparator = Comparator.comparing(Person::getAge);

        Collections.sort(people,nameComparator);
        people.stream().forEach(System.out::println);

        Collections.sort(people,ageComparator);
        people.stream().forEach(System.out::println);

        Comparator<Person> namComparator2 = (person1,person2) -> person1.getName().compareTo(person2.getName());
        Collections.sort(people,namComparator2);
        people.stream().forEach(System.out::println);

        Comparator<Person> ageComparator2 = (person1,person2) -> person1.getAge() - person2.getAge();
        Collections.sort(people,ageComparator2);
        people.stream().forEach(System.out::println);
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}
