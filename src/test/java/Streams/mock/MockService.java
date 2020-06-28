package Streams.mock;

import week2.Streams.model.Item;
import week2.Streams.model.Sex;
import week2.Streams.model.User;
import week2.Streams.model.UserOrderHistory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MockService {

    private List<User> users;
    private List<Item> items;
    private List<UserOrderHistory> userOrderHistoryList;

    public MockService() {
        users = mockUsers();
        items = mockItems();
        userOrderHistoryList = userOrderHistoryMock();
    }

    public List<User> getUsers() {
        return Collections.unmodifiableList(users);
    }

    public List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }

    public List<UserOrderHistory> getUserOrderHistoryList() {
        return Collections.unmodifiableList(userOrderHistoryList);
    }

    private List<User> mockUsers() {
        List<User> users = new ArrayList<>();
        /* 0 */
        users.add(new User("Adam", "Adamowicz", Sex.MALE));
        /* 1 */
        users.add(new User("Bogdan", "Adamowicz", Sex.MALE));
        /* 2 */
        users.add(new User("Agnieszka", "Janowska", Sex.FEMALE));
        /* 3 */
        users.add(new User("Michalina", "Jaruzelska", Sex.FEMALE));
        /* 4 */
        users.add(new User("Anna", "Grocka", Sex.MALE));
        /* 5 */
        users.add(new User("Adam", "Małysz", Sex.MALE));
        /* 6 */
        users.add(new User("Robert", "Makłowicz", Sex.MALE));
        /* 7 */
        users.add(new User("Magdalena", "Gessler", Sex.FEMALE));
        /* 8 */
        users.add(new User("Joanna", "Bazarowa", Sex.FEMALE));
        /* 9 */
        users.add(new User("Alicja", "Brzozowska", Sex.FEMALE));
        return users;
    }

    private List<Item> mockItems() {
        List<Item> items = new ArrayList<>();
        /* 0 */
        items.add(new Item("Lyszki", 20.0));
        /* 1 */
        items.add(new Item("Makaron Wifon", 14.34));
        /* 2 */
        items.add(new Item("Niwelator", 599.99));
        /* 3 */
        items.add(new Item("Mercedes GT AMG 4-door coupe", 1000000.0));
        /* 4 */
        items.add(new Item("Rolex Submarriner", 18943.0));
        /* 5 */
        items.add(new Item("Wino ABC", 16.50));
        /* 6 */
        items.add(new Item("Pizza Guiseppe", 8.70));
        /* 7 */
        items.add(new Item("Paluszki Frosta", 12.70));
        /* 8 */
        items.add(new Item("Podkładka pod myszkę", 45.99));
        /* 9  */
        items.add(new Item("Szafa PAX", 2700.10));
        /* 10 */
        items.add(new Item("Top Chipsy", 4.50));
        /* 11 */
        items.add(new Item("Ser gouda", 7.49));
        return items;
    }

    private List<UserOrderHistory> userOrderHistoryMock() {
        List<UserOrderHistory> userOrderHistoryList = new ArrayList<>();
        userOrderHistoryList.add(new UserOrderHistory(
                users.get(0),
                Arrays.asList(items.get(1), items.get(10))
        ));
        userOrderHistoryList.add(new UserOrderHistory(
                users.get(1),
                Arrays.asList(items.get(6), items.get(9), items.get(4), items.get(4))
        ));
/*        userOrderHistoryList.add(new UserOrderHistory(
                users.get(1),
                Arrays.asList(items.get(1), items.get(0), items.get(7), items.get(3))
        ));*/
        userOrderHistoryList.add(new UserOrderHistory(
                users.get(2),
                Arrays.asList(items.get(11), items.get(9), items.get(3), items.get(1))
        ));
        userOrderHistoryList.add(new UserOrderHistory(
                users.get(5),
                Arrays.asList(items.get(0), items.get(0), items.get(0), items.get(0))
        ));
        userOrderHistoryList.add(new UserOrderHistory(
                users.get(4),
                Arrays.asList(items.get(1), items.get(9), items.get(9), items.get(6))
        ));
/*        userOrderHistoryList.add(new UserOrderHistory(
                users.get(4),
                Arrays.asList(items.get(0), items.get(6))
        ));*/
        userOrderHistoryList.add(new UserOrderHistory(
                users.get(6),
                Arrays.asList(items.get(5), items.get(5), items.get(5))
        ));
        userOrderHistoryList.add(new UserOrderHistory(
                users.get(7),
                Arrays.asList(items.get(4), items.get(1), items.get(1), items.get(1), items.get(1), items.get(1))
        ));
        userOrderHistoryList.add(new UserOrderHistory(
                users.get(8),
                Arrays.asList(items.get(2), items.get(11), items.get(5))
        ));
        return userOrderHistoryList;
    }
}
