package Streams;

import Streams.mock.MockService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import week2.Streams.model.Item;
import week2.Streams.model.User;
import week2.Streams.model.UserOrderHistory;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class StreamApiTest {

    private MockService mockService;

    @BeforeEach
    void setUp() {
        mockService = new MockService();
    }

    @Test
    void ktoJezdziMercedesem() {
        Set<User> mercedes = whoHaveMercedes();
        System.out.println("Mercedesa posiadają: ");
        System.out.println(mercedes);
    }

    private Set<User> whoHaveMercedes() {
        return mockService.getUserOrderHistoryList()
                .stream()
                .filter(getItem("mercedes"))
                .map(UserOrderHistory::getUser)
                .collect(Collectors.toSet());
    }

    @Test
    void ktoZajadaPizze() {
        Set<User> pizza = mockService.getUserOrderHistoryList()
                .stream()
                .filter(getItem("pizza"))
                .map(UserOrderHistory::getUser)
                .collect(Collectors.toSet());

        System.out.println("Pizze posiadają: ");
        System.out.println(pizza);
    }

    private Predicate<UserOrderHistory> getItem(String itemToFind) {
        return e -> e.getItems()
                .stream()
                .anyMatch(item -> item.getName()
                        .toLowerCase()
                        .contains(itemToFind));
    }

    @Test
    void ktoWydalNajmniej() throws Exception { ////////do implementacji


        Map<User, List<UserOrderHistory>> userToUserOrderHistory = mockService.getUserOrderHistoryList()
                .stream()
                .collect(Collectors.groupingBy(UserOrderHistory::getUser));


        System.out.println("dd");

    }

    @Test
    void ktoPijeZaDuzoWina() {
    }

    @Test
    void coMaAdamMalysz(){
        List<Item> adamMalysz = mockService.getUserOrderHistoryList()
                .stream()
                .filter(e -> e.getUser().getName().equalsIgnoreCase("Adam"))
                .filter(e -> e.getUser().getSurname().equalsIgnoreCase("Małysz"))
                .map(UserOrderHistory::getItems)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        System.out.println(adamMalysz);
    }

    void testOptional() throws Exception {
        Optional<Item> optionalItem = mockService.getUserOrderHistoryList()
                .stream()
                .filter(e -> e.getUser().getName().equalsIgnoreCase("Adam"))
                .filter(e -> e.getUser().getSurname().equalsIgnoreCase("Małysz"))
                .map(UserOrderHistory::getItems)
                .flatMap(Collection::stream)
                .findFirst();

        Double itemValue = optionalItem.map(Item::getValue).orElseThrow(() -> new Exception("Item is not available"));
        System.out.println(itemValue);

    }
    @Test
    void ktoKupilNajwiecejRzeczy() {


    }

    @Test
    void ktoKupilNajwiecejRoznychRzeczy() {
    }

    @Test
    void ktoKupilNajwiecejTychSamychPrzedmiotowiCoToBylZaPrzedmiot() {
    }

    @Test
    void ileKosztowalaSzafaPax() {

        Double pax = mockService.getItems()
                .stream()
                .filter(e -> e.getName().toLowerCase().contains("pax"))
                .map(Item::getValue)
                .findAny()
                .get();
        System.out.println(pax);

    }

    @Test
    void ktoraPlecWydalaNajmniejNaZakupy() {
    }

    @Test
    void ktoraPlecKupilaNajmniejPrzedmiotow() {
    }

    @Test
    void zestawIleOsobMialoPoIlePrzedmiotow() {
    }

    @Test
    void czyJestKtosKtoNicNieKupil() {
        List<User> users = mockService.getUserOrderHistoryList()
                .stream()
                .map(UserOrderHistory::getUser)
                .distinct()
                .collect(Collectors.toList());

        List<User> usersWithoutProducts = mockService.getUsers()
                .stream()
                .filter(e -> !users.contains(e))
                .collect(Collectors.toList());

        System.out.println(usersWithoutProducts);

    }

    @Test
    void czyJestJakisNieKupionyPrzedmiot() {
        List<Item> buyedProduct = mockService.getUserOrderHistoryList()
                .stream()
                .map(UserOrderHistory::getItems)
                .distinct()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        //System.out.println(buyedProduct);

//II metod
/*        List<Item> buyedProduct = mockService.getUserOrderHistoryList()
                .stream()
                .flatMap(e -> e.getItems().stream())
                .distinct()
                .collect(Collectors.toList());*/


        List<Item> freeProduct = mockService.getItems()
                .stream()
                .filter(e -> !buyedProduct.contains(e))
                .collect(Collectors.toList());
        System.out.println(freeProduct);

    }

    @Test
    void wyswietlWszystkiePrzedmiotyBezPowtorzenDlaOsobKtoreZlozylyWiecejNizJednoZamowienie() {
    }


}