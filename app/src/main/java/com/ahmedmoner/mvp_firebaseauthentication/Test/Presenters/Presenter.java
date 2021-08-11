package com.ahmedmoner.mvp_firebaseauthentication.Test.Presenters;


import android.util.Log;

import com.ahmedmoner.mvp_firebaseauthentication.Test.Models.Contract;
import com.ahmedmoner.mvp_firebaseauthentication.Test.Models.Models;

public class Presenter implements Contract.Ipresenter {

    private static final String TAG = "class Presenter";
    Contract.Imodle imodle;
    Contract.Iview iview;

    public Presenter(Contract.Iview newiview) {
        imodle = new Models();// TODO: 8/11/2021 بما ان الاموديل مستعمل الانترفيس يبقي الانتر فيس الاوبجكت منه يبقي باستعمال الكلاس الالي استخدمه
        iview = newiview;
    }



    @Override
    public void onClickGetdataNam(String name) {
       // name = imodle.getNameFromadb();
        iview.onDataRecived(name);
        Log.d(TAG, "onClickGetdataNam: "+name);
     }
}
