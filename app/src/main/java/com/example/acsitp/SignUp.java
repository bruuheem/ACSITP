package com.example.acsitp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.acsitp.databinding.ActivitySignUpBinding;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class SignUp extends AppCompatActivity {

    ActivitySignUpBinding binding;
    DatabaseHelper  databaseHelper;
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
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper = new DatabaseHelper(this);



        binding.signupButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String email = binding.signupEmail.getText().toString();
                String password = binding.signupPassword.getText().toString();
                String confirmPassword = binding.signupConfirmPassword.getText().toString();

                if (email.equals("") || password.equals("") || confirmPassword.equals("")){
                    Toast.makeText(SignUp.this, "All fields are required", Toast.LENGTH_SHORT).show();}
                else{

                    if (isValidEmail(email) == false){
                        Toast.makeText(SignUp.this, "Invalid email", Toast.LENGTH_SHORT).show();
                    } else if (password.length() < 8) {
                        Toast.makeText(SignUp.this, "Password should be more than 8 letters", Toast.LENGTH_SHORT).show();


                    } else{
                        if (password.equals(confirmPassword)){
                            Boolean checkUserEmail = databaseHelper.checkEmail(email);
                            if(checkUserEmail == false){
                                Boolean insert = databaseHelper.insertData(email, password);

                                if (insert == true){
                                    Toast.makeText(SignUp.this, "Sign up succesfully", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(), Login.class);
                                    startActivity(intent);
                                }else{
                                    Toast.makeText(SignUp.this, "Signup failed", Toast.LENGTH_SHORT).show();
                            }
                        }else {
                                Toast.makeText(SignUp.this, "You already have an account", Toast.LENGTH_SHORT).show();
                            }
                    }else{
                            Toast.makeText(SignUp.this, "Invalid passwords", Toast.LENGTH_SHORT).show();

                        }
                }
            }}
        });
        binding.LoginRedirectText.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });
    }
}