package com.ahmedmoner.mvp_firebaseauthentication.Test.Views;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ahmedmoner.mvp_firebaseauthentication.R;
import com.ahmedmoner.mvp_firebaseauthentication.Test.Models.Contract;
import com.ahmedmoner.mvp_firebaseauthentication.Test.Presenters.Presenter;

public class Register extends AppCompatActivity  implements Contract.Iview {
    TextView textView;
    Button button;
    EditText et_name;

    Presenter presenter ;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_register);
        initViews();

       presenter = new Presenter(this);
        button.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {

             presenter.onClickGetdataNam(et_name.getText().toString());
            }
        });
    }




    private void initViews() {
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        et_name = findViewById(R.id.et_name);
    }


    @Override
    public void onDataRecived(String name) {

        textView.setText(name);
    }
}