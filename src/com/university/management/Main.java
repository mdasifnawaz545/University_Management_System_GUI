package com.university.management;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Main {
    public static void main(String[] args) {
        DBConnection connection=new DBConnection();
        Frame frame=new Frame();
        Login login = new Login(connection.connect);
        for(int i=0 ;;i++){
        try {
            Thread.sleep(30000);
        }catch (InterruptedException ie){
            System.out.println(ie);
        }
        if(login.validation){
            login.setVisible(false);
            MainFrame mainFrame=new MainFrame();
            break;
        }}


    }
}