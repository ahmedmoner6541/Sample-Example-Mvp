package com.ahmedmoner.mvp_firebaseauthentication.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ahmedmoner.mvp_firebaseauthentication.Core.Register.RegistrationContract;
import com.ahmedmoner.mvp_firebaseauthentication.Core.Register.RegistrationPresenter;
import com.ahmedmoner.mvp_firebaseauthentication.R;
import com.google.firebase.auth.FirebaseUser;

public class RegistrationActivity extends AppCompatActivity implements
        View.OnClickListener,
        RegistrationContract.View {

    TextView tvLogin;
    Button btnRegistration;
    EditText edtEmail, edtPassword;
    private RegistrationPresenter mRegisterPresenter;
    ProgressDialog mPrgressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        initViews();
    }
    private void initViews() {
        btnRegistration =  findViewById(R.id.btn_register);
        btnRegistration.setOnClickListener(this);
        tvLogin = findViewById(R.id.tv_login);
        tvLogin.setOnClickListener(this);
        edtEmail =  findViewById(R.id.email_register);
        edtPassword =  findViewById(R.id.password_register);

        mRegisterPresenter = new RegistrationPresenter(this);

        mPrgressDialog = new ProgressDialog(this);
        mPrgressDialog.setMessage("Please wait, Adding profile to database.");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_register:
                checkRegistrationDetails();
                break;
            case R.id.tv_login:
                moveToLoginActivity();
                break;
        }
    }

    private void moveToLoginActivity() {
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
    }

    private void checkRegistrationDetails() {
        // TODO: 8/10/2021 لو الميلل والباسوورد مش فارغين
        if(!TextUtils.isEmpty(edtEmail.getText().toString()) && !TextUtils.isEmpty(edtPassword.getText().toString())){
            initLogin(edtEmail.getText().toString(), edtPassword.getText().toString());
        }else{
            // TODO: 8/10/2021  و فارغيينن اظهر دول
            if(TextUtils.isEmpty(edtEmail.getText().toString())){
                edtEmail.setError("Please enter a valid email");
            }if(TextUtils.isEmpty(edtPassword.getText().toString())){
                edtPassword.setError("Please enter password");
            }
        }
    }

    // TODO: 8/10/2021 اظهر البروجريس علي ما تسجل دخول من الداله الregister اللي بداخل البريزنتر
    private void initLogin(String email, String password) {
        mPrgressDialog.show();
        mRegisterPresenter.register(this, email, password);
    }

    @Override
    public void onRegistrationSuccess(FirebaseUser firebaseUser) {
        mPrgressDialog.dismiss();
        Toast.makeText(getApplicationContext(), "Successfully Registered" , Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRegistrationFailure(String message) {
        mPrgressDialog.dismiss();
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}