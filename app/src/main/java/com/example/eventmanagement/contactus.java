
package com.example.eventmanagement;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class contactus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactus);

//        Intent intent = new Intent(eventdashboard.this, contactus.class);
//        startActivity(intent);

        // Find the phone TextView
        TextView phoneTextView = findViewById(R.id.contact_phone);

        // Set an OnClickListener to trigger the phone call
        phoneTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Define the phone number
                String phoneNumber = "+1234567890"; // Ensure it's the correct number format

                // Create the Intent to dial the phone number
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + phoneNumber));

                // Start the phone dialer
                startActivity(intent);
            }
        });


    }
}
