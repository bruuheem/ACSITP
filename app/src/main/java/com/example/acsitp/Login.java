package com.example.acsitp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.acsitp.databinding.ActivityLoginBinding;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login extends AppCompatActivity {

    ActivityLoginBinding binding;
    DatabaseHelper databaseHelper;

    private static final String EMAIL_PATTERN =
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    public static boolean isValidEmail(String email) {
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper = new DatabaseHelper(this);
        binding.loginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String email = binding.loginEmail.getText().toString();
                String password = binding.loginPassword.getText().toString();

                if ( email.equals("") || password.equals("")) {
                    Toast.makeText(Login.this, "All fields are required ", Toast.LENGTH_SHORT).show();
                } else if (isValidEmail(email)== false ) {
                    Toast.makeText(Login.this, "Invalid email", Toast.LENGTH_SHORT).show();

                } else if (password.length() < 8 ) {
                    Toast.makeText(Login.this, "Password should be more than 8 letters", Toast.LENGTH_SHORT).show();

                }

            else{
                    Boolean checkCredentials = databaseHelper.checkEmailPassword(email, password);

                    if ( checkCredentials == true){
                        Toast.makeText(Login.this, "Login Succesfully ", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), Home.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(Login.this, "Incorrect Email or Password ", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });
        binding.SignUpRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, SignUp.class);
                startActivity(intent);
            }
        });
    }
}