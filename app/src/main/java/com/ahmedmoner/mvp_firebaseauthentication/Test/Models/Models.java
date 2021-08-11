package com.ahmedmoner.mvp_firebaseauthentication.Test.Models;

public class Models implements Contract.Imodle {
    String name ;

    public Models(String name) {
        this.name = name;
    }

    public Models() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getNameFromadb( ) {
       return name = getName();// // TODO: 8/11/2021 revision this 
    }
}
