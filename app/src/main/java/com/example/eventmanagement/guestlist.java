package com.example.eventmanagement;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class guestlist extends AppCompatActivity {

    private RecyclerView guestRecyclerView;
    private GuestAdapter guestAdapter;
    private EditText searchGuests;
    private List<Guest> guestList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guestlist);

        // Initialize views
        searchGuests = findViewById(R.id.search_guests);
        guestRecyclerView = findViewById(R.id.guest_recycler_view);

        // Initialize guest list
        guestList = new ArrayList<>();
        populateGuestList();

        // Setup RecyclerView
        guestAdapter = new GuestAdapter(guestList);
        guestRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        guestRecyclerView.setAdapter(guestAdapter);

        // Search functionality
        searchGuests.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                guestAdapter.filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    // Dummy data
    private void populateGuestList() {
        guestList.add(new Guest("lami@gmail.com", "Female"));
        guestList.add(new Guest("hridy@gmail.com", "Female"));
        guestList.add(new Guest("jothamarodi@gmail.com", "Male"));
        guestList.add(new Guest("julianaanyango@gmail.com", "Female"));
        guestList.add(new Guest("calvinceotieno@gmail.com", "Male"));
        guestList.add(new Guest("jaro@gmail.com", "Male"));
        guestList.add(new Guest("fred@gmail.com", "Male"));
        guestList.add(new Guest("calebotieno@gmail.com", "Male"));
        guestList.add(new Guest("benardokumu@gmail.com", "Male"));
        guestList.add(new Guest("mina@gmail.com", "Female"));
        guestList.add(new Guest("nuzhat@gmail.com", "Female"));
    }
}
