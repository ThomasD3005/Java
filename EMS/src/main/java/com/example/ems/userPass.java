package com.example.ems;

import java.util.HashMap;

public class userPass {

    HashMap<String,String>  usersAndPass = new HashMap<String,String>();

    public userPass() {

        usersAndPass.put("Username", "Password");
        usersAndPass.put("Mike", "Williams");
        usersAndPass.put("Irish", "Whiskey");
    }

    protected HashMap<String, String> usersAndPass() {
        return usersAndPass;
    }
}
