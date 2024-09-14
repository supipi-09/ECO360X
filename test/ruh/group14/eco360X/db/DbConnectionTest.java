package ruh.group14.eco360X.db;


import java.sql.Connection;

class DbConnectionTest {

    public static void main(String[] args) {
        new DbConnectionTest().getInstance();
    }

    void getInstance() {
        try {
            Connection con1 = DbConnection.getInstance().getConnection();
            Connection con2 = DbConnection.getInstance().getConnection();
            if(con2==con1){
                System.out.println("true");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}