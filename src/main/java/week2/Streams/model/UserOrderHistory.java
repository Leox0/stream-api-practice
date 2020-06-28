package week2.Streams.model;

import java.util.List;

public class UserOrderHistory {
    private User user;
    private List<Item> items;

    public UserOrderHistory(User user, List<Item> items) {
        this.user = user;
        this.items = items;
    }

    public User getUser() {
        return user;
    }

    public List<Item> getItems() {
        return items;
    }
}
