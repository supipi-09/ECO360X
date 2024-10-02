package ruh.group14.eco360X.db;

import ruh.group14.eco360X.model.User;

import java.util.ArrayList;

public class Database {
    public static ArrayList<User> userTable = new ArrayList<>();

    static {
        userTable.add(
                new User("Janith", "Ranasinghe",
                        "Kosgame", "200117001804", "janith@gmail.com", "123")
        );
        userTable.add(
                new User("Thejana", "Hirumal",
                        "Kandy", "200017001804", "thejana@gmail.com", "234")
        );
    }
}
