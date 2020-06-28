package week2.Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> users = generateUsers();

        List<String> listOfPhoneNumbersOfFemaleGmailUsers = users.stream()
                .filter(e -> e.getEmail().contains("@gmail"))
                .filter(e -> e.getName().endsWith("a") && !e.getName().equalsIgnoreCase("kuba"))
                .map(Person::getPhoneNumber)
                .collect(Collectors.toList());

        listOfPhoneNumbersOfFemaleGmailUsers.forEach(System.out::println);


        Map<String, List<Person>> collect = users.stream()
                .collect(Collectors.groupingBy(e -> e.getEmail().substring(e.getEmail().indexOf("@"))));


        Integer a[] = {1, 2, 3, 4, 5, 6};

        Integer integer = Integer.valueOf("505939534");


    }

    private static List<Person> generateUsers() {
        List<Person> users = new ArrayList<>();
        users.add(new Person("Adam", "Adamowicz", "505939534", "adam.adamowicz@gmail.com"));
        users.add(new Person("Kuba", "Kubowski", "505939534", "kuba.kubowski@gmail.com"));
        users.add(new Person("Ola", "Olawska", "545788556", "ola.olawska@gmail.com"));
        users.add(new Person("Michał", "Michawski", "353756345", "michal.michawski@o2.com"));
        users.add(new Person("Piotr", "Piotrowicz", "234423656", "piotr.piotrowicz@wp.pl"));
        users.add(new Person("Zuzanna", "zuzowska", "865634234", "zuzanna.zuzowska123@wp.com"));
        return users;
    }
}
