package com.ahmedmoner.mvp_firebaseauthentication.Test.Models;

import android.app.Activity;

import com.google.firebase.auth.FirebaseUser;

public interface Contract {

    interface  Iview{
        public void onDataRecived(String name);
    }

    interface Ipresenter{
        public void onClickGetdataNam(String name);
    }

    interface Imodle{
        public String getNameFromadb();
    }


}
