package com.example.eventmanagement;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class currentevent extends AppCompatActivity {

    private RecyclerView recyclerView;
    private EventAdapter eventAdapter;
    private List<Event> eventList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currentevent);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize event list and adapter
        eventList = new ArrayList<>();
        eventAdapter = new EventAdapter(eventList);
        recyclerView.setAdapter(eventAdapter);

        // Load event data
        loadEventData();
    }

    private void loadEventData() {
        eventList.add(new Event("Annual Sports Day", "01 Jan 2024", "Auditorium", "10:00 AM"));
        eventList.add(new Event("NASA Space Apps Challenge 2024", "05 Jan 2024", "AIUC Campus", "02:00 PM"));
        eventList.add(new Event("Power Puff Girls Programming Contest", "10 Jan 2024", "Lab-1", "09:00 AM"));
        eventList.add(new Event("Tech Fest 2024", "01 Jan 2024", "Auditorium", "10:00 AM"));
        eventList.add(new Event("Coding Hackathon", "05 Jan 2024", "Room 101", "02:00 PM"));
        eventList.add(new Event("AI Workshop", "10 Jan 2024", "Main Hall", "09:00 AM"));
        eventList.add(new Event("Winter Fest 2024", "01 Jan 2024", "FAZ,IIUC", "10:00 AM"));
        eventList.add(new Event("Programming Contest", "05 Jan 2024", "Room 101", "02:00 PM"));
        eventList.add(new Event("Victory Day Celebration", "10 Jan 2024", "IIUC Central Field", "09:00 AM"));




        eventAdapter.notifyDataSetChanged();
    }
}
