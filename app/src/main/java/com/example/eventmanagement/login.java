package com.example.eventmanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class login extends AppCompatActivity {

    EditText loginUsername, loginPassword; // Added these fields
    Button loginButton;
    TextView signupRedirectText;

//    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

       loginUsername = findViewById(R.id.login_username);
        loginPassword = findViewById(R.id.login_password);
        loginButton = findViewById(R.id.login_button);
        signupRedirectText=findViewById(R.id.signupRedirectText);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validatepassword() | !validateUsername()) {
                    // Do nothing if validation fails
                } else {
                    checkuser();
                }
            }
        });

        signupRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), signup.class));
            }
        });
    }

    public Boolean validateUsername() {
        String val = loginUsername.getText().toString();
        if (val.isEmpty()) {
            loginUsername.setError("Email cannot be empty");
            return false;
        } else {
            loginUsername.setError(null);
            return true;
        }
    }

    public Boolean validatepassword() {
        String pass =  loginPassword.getText().toString();
        if (pass.isEmpty()) {
            loginPassword.setError("password cannot be empty");
            return false;
        } else {
            loginPassword.setError(null);
            return true;
        }
    }

    public void checkuser() {
        String emailInput = loginUsername.getText().toString().trim();
        String passwordInput = loginPassword.getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUserDatabase = reference.orderByChild("username").equalTo(emailInput);

        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    for (DataSnapshot userSnapshot : snapshot.getChildren()) {
                        String passwordFromDb = userSnapshot.child("password").getValue(String.class);

                        if (passwordFromDb != null && passwordFromDb.equals(passwordInput)) {
                            // Passwords match, proceed with login
                            String nameFromDb = userSnapshot.child("name").getValue(String.class);
                            String emailFromDb = userSnapshot.child("email").getValue(String.class);
                            String contactFromDb = userSnapshot.child("contact").getValue(String.class);


                            // Navigate to dashboard activity
                            Intent intent = new Intent(getApplicationContext(), eventdashboard.class);
                            startActivity(intent);
                            finish(); // Close the login activity
                            return; // Exit the loop
                        } else {
                            // Passwords do not match, show error
                            loginPassword.setError("Invalid password");
                            loginPassword.requestFocus();
                            return; // Exit the loop
                        }
                    }
                } else {
                    // Handle case where user doesn't exist
                    loginUsername.setError("User doesn't exist");
                    loginUsername.requestFocus();
                }
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle database error
                Toast.makeText(login.this, "Database error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
 });
}
}







//package com.example.eventmanagement;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.Query;
//import com.google.firebase.database.ValueEventListener;
//
//import java.util.Objects;
//
//public class login extends AppCompatActivity {
//
//    EditText loginUsername, loginPassword;
//    Button loginButton;
//    TextView signupRedirectText;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//
//        loginUsername = findViewById(R.id.login_username);
//        loginPassword = findViewById(R.id.login_password);
//        loginButton = findViewById(R.id.login_button);
//        signupRedirectText = findViewById(R.id.signupRedirectText);
//
//        loginButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (!validateUsername() | !validatePassword()) {
//
//                } else {
//                    checkUser();
//                }
//            }
//        });
//
//        signupRedirectText.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(login.this, signup.class);
//                startActivity(intent);
//            }
//        });
//
//    }
//
//    public Boolean validateUsername() {
//        String val = loginUsername.getText().toString();
//        if (val.isEmpty()) {
//            loginUsername.setError("Username cannot be empty");
//            return false;
//        } else {
//            loginUsername.setError(null);
//            return true;
//        }
//    }
//
//    public Boolean validatePassword(){
//        String val = loginPassword.getText().toString();
//        if (val.isEmpty()) {
//            loginPassword.setError("Password cannot be empty");
//            return false;
//        } else {
//            loginPassword.setError(null);
//            return true;
//        }
//    }
//
//
//    public void checkUser(){
//        String userUsername = loginUsername.getText().toString().trim();
//        String userPassword = loginPassword.getText().toString().trim();
//
//        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
//        Query checkUserDatabase = reference.orderByChild("username").equalTo(userUsername);
//
//        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//
//                if (snapshot.exists()){
//
//                    loginUsername.setError(null);
//                    String passwordFromDB = snapshot.child(userUsername).child("password").getValue(String.class);
//
//                    if (passwordFromDB.equals(userPassword)) {
//                        loginUsername.setError(null);
//
//                        String nameFromDB = snapshot.child(userUsername).child("name").getValue(String.class);
//                        String emailFromDB = snapshot.child(userUsername).child("email").getValue(String.class);
//                        String usernameFromDB = snapshot.child(userUsername).child("username").getValue(String.class);
//
//                        Intent intent = new Intent(login.this, eventdashboard.class);
//
//                        intent.putExtra("name", nameFromDB);
//                        intent.putExtra("email", emailFromDB);
//                        intent.putExtra("username", usernameFromDB);
//                        intent.putExtra("password", passwordFromDB);
//
//                        startActivity(intent);
//                    } else {
//                        loginPassword.setError("Invalid Credentials");
//                        loginPassword.requestFocus();
//                    }
//                } else {
//                    loginUsername.setError("User does not exist");
//                    loginUsername.requestFocus();
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//    }
//}