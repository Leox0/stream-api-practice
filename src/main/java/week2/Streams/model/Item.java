package week2.Streams.model;

import java.util.Objects;

public class Item {
    private String name;
    private Double value;

    public Item(String name, Double value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(name, item.name) &&
                Objects.equals(value, item.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value);
    }
}
