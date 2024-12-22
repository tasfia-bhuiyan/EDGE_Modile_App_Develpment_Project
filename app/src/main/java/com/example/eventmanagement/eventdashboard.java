package com.example.eventmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class eventdashboard extends AppCompatActivity {
    Button buttonLogout;
    CardView cardCreateEvent,cardLocation, cardGuests,cardContactUs,cardCurrentEvent,cardEventPicture;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_eventdashboard);

        buttonLogout=findViewById(R.id.buttonLogout);
        cardCreateEvent=findViewById(R.id.cardCreateEvent);
        cardLocation=findViewById(R.id.cardLocation);
        cardGuests=findViewById(R.id.cardGuests);
        cardContactUs=findViewById(R.id.cardContactUs);
        cardCurrentEvent=findViewById(R.id.cardCurrentEvent);
        cardEventPicture=findViewById(R.id.cardPicture);

        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(eventdashboard.this,login.class);
                startActivity(intent);
                finish();
            }
        });

        cardCreateEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(eventdashboard.this,createevent.class);
                startActivity(intent);

            }
        });

        cardLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("EventDashboard", "cardLocation clicked");
                Intent intent=new Intent(eventdashboard.this,location.class);
                startActivity(intent);
            }
        });

        cardGuests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(eventdashboard.this,guestlist.class);
                startActivity(intent);
            }
        });

        cardContactUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(eventdashboard.this,contactus.class);
                startActivity(intent);
            }
        });

        cardCurrentEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(eventdashboard.this,currentevent.class);
                startActivity(intent);
            }
        });

        cardEventPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(eventdashboard.this,eventpicture.class);
                startActivity(intent);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}