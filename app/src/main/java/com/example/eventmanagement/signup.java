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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signup extends AppCompatActivity {

    EditText signupName, signupUsername, signupEmail, signupPassword;
    TextView loginRedirectText;
    Button signupButton;

//    FirebaseAuth mAuth;
    FirebaseDatabase database;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        signupName = findViewById(R.id.signup_name);
        signupEmail = findViewById(R.id.signup_email);
        signupUsername = findViewById(R.id.signup_username);
        signupPassword = findViewById(R.id.signup_password);
        loginRedirectText = findViewById(R.id.loginRedirectText);
        signupButton = findViewById(R.id.signup_button);
//        mAuth=FirebaseAuth.getInstance();

        reference = FirebaseDatabase.getInstance().getReference("users");
        signupButton.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {

                                                String name = signupName.getText().toString();
                                                String email = signupEmail.getText().toString();
                                                String username = signupUsername.getText().toString();
                                                String password = signupPassword.getText().toString();


                                                if (TextUtils.isEmpty(name)) {
                                                    Toast.makeText(signup.this, "enter name", Toast.LENGTH_SHORT).show();
                                                    return;
                                                }
                                                if (TextUtils.isEmpty(email)) {
                                                    Toast.makeText(signup.this, "enter Email", Toast.LENGTH_SHORT).show();
                                                    return;
                                                }
                                                if (TextUtils.isEmpty(username)) {
                                                    Toast.makeText(signup.this, "enter username", Toast.LENGTH_SHORT).show();
                                                    return;
                                                }
                                                if (TextUtils.isEmpty(password)) {
                                                    Toast.makeText(signup.this, "enter Password", Toast.LENGTH_SHORT).show();
                                                }


// Save user data to Realtime Database
                                                database = FirebaseDatabase.getInstance();
                                                reference = database.getReference("users");
                                                Helper helperClass = new Helper(name, email, username, password);
                                                reference.child(name).setValue(helperClass)
                                                        .addOnCompleteListener(task -> {
                                                            if (task.isSuccessful()) {
                                                                Toast.makeText(signup.this, "You have signed up successfully", Toast.LENGTH_SHORT).show();
                                                                Intent intent = new Intent(getApplicationContext(), login.class);
                                                                startActivity(intent);
                                                            } else {
                                                                Toast.makeText(signup.this, "Signup failed. Please try again.", Toast.LENGTH_SHORT).show();
                                                            }
                                                        });
                                            }


//                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            // User created successfully, now save data in Firebase Realtime Database
//
//                            String userId = mAuth.getCurrentUser().getUid(); // Get the unique ID of the user
//
//                            // Create a new user object to save in the database
//                            Helper userDetails = new Helper(name, email, username, password);
//
//                            // Save the user data to the Firebase Realtime Database
//                            databaseReference.child(userId).setValue(userDetails).addOnCompleteListener(new OnCompleteListener<Void>() {
//                                @Override
//                                public void onComplete(@NonNull Task<Void> task) {
//                                    if (task.isSuccessful()) {
//                                        // Show success message and navigate to login screen
//                                        Toast.makeText(signup.this, "Registration successful.", Toast.LENGTH_SHORT).show();
//                                        startActivity(new Intent(signup.this,eventdashboard.class));
//                                    } else {
//                                        // Show error message if database save fails
//                                        Toast.makeText(signup.this, "Failed to save user data.", Toast.LENGTH_SHORT).show();
//                                    }
//                                }
//                            });
//                        } else {
//                            // If authentication fails, show error message
//                            Toast.makeText(signup.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
//                Toast.makeText(signup.this, "You have signup successfully!", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(signup.this, login.class);
//                startActivity(intent);
//            }
//        });

                                        });
        loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(signup.this, login.class);
                startActivity(intent);
            }
   });
    }
}