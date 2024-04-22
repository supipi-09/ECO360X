package ruh.group14.eco360X.db;

import ruh.group14.eco360X.model.User;

import java.util.ArrayList;

public class Database {
    public static ArrayList<User> userTable=new ArrayList<>();

    static {
        userTable.add(
                new User("Janith","Ranasinghe",
                        "janith@gmail.com","123")
        );
    }
}
