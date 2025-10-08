import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

class Person {
    private final String name;
    private final int age;
    private final String city;

    public Person(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getCity() { return city; }

    @Override
    public String toString() {
        return name + " (" + age + ", " + city + ")";
    }
}

public class Task1Demo {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 30, "New York"));
        people.add(new Person("Bob", 25, "Los Angeles"));
        people.add(new Person("Charlie", 35, "New York"));
        people.add(new Person("Diana", 28, "Chicago"));
        people.add(new Person("Ethan", 40, "New York"));
        people.add(new Person("Fiona", 22, "Boston"));

        System.out.println("Original List");
        for (Person person : people) {
            System.out.println(person);
        }

        people.sort(new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return Integer.compare(p1.getAge(), p2.getAge());
            }
        });

        System.out.println("\nSorted by Age (Ascending)");
        for (Person person : people) {
            System.out.println(person);
        }

        String targetCity = "New York";
        Iterator<Person> iterator = people.iterator();
        while (iterator.hasNext()) {
            if (!iterator.next().getCity().equalsIgnoreCase(targetCity)) {
                iterator.remove();
            }
        }

        System.out.println("\nFiltered (Only " + targetCity + ")");
        for (Person person : people) {
            System.out.println(person);
        }
    }
}
