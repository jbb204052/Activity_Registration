package com.example.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.android.material.textfield.TextInputLayout;



public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.registration.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText txt_password = findViewById(R.id.txt_password);
        EditText txt_confirm_pass = findViewById(R.id.txt_confirm_pass);


        TextInputLayout pass_cont = findViewById(R.id.container_password);
        pass_cont.setEndIconOnClickListener(v -> {
            if (txt_password.getTransformationMethod() == null) {
                txt_password.setTransformationMethod(new PasswordTransformationMethod());
                txt_confirm_pass.setTransformationMethod(new PasswordTransformationMethod());
            } else {
                txt_password.setTransformationMethod(null);
                txt_confirm_pass.setTransformationMethod(null);
            }
        });



        Button btn_register = findViewById(R.id.btn_register);
        btn_register.setOnClickListener(v -> {
            register();
        });

    }

    private void register(){
        EditText txt_fname = findViewById(R.id.txt_fname);
        EditText txt_lname = findViewById(R.id.txt_lname);
        EditText txt_username = findViewById(R.id.txt_username);
        EditText txt_password = findViewById(R.id.txt_password);
        EditText txt_confirm_pass = findViewById(R.id.txt_confirm_pass);

        if (txt_fname.getText().toString().isEmpty()) {
            txt_fname.setError("First name is required");
        } else if (txt_lname.getText().toString().isEmpty()) {
            txt_lname.setError("Last name is required");
        } else if (txt_username.getText().toString().isEmpty()) {
            txt_username.setError("Username is required");
        } else if (txt_password.getText().toString().isEmpty()) {
            txt_password.setError("Password is required");
        } else if (txt_confirm_pass.getText().toString().isEmpty()) {
            txt_confirm_pass.setError("Confirm password is required");
        } else {
            if (txt_password.getText().toString().equals(txt_confirm_pass.getText().toString())) {
                txt_password.setError(null);
                txt_confirm_pass.setError(null);
                txt_fname.setError(null);
                txt_lname.setError(null);
                txt_username.setError(null);
                displayMessage();
            } else {
                txt_password.setError("Password does not match");
                txt_confirm_pass.setError("Password does not match");
            }
        }
    }

    public void displayMessage() {
        Intent intent = new Intent(this, Message.class);
        String fname = ((EditText) findViewById(R.id.txt_fname)).getText().toString();
        intent.putExtra(EXTRA_MESSAGE, fname);
        startActivity(intent);
    }
}