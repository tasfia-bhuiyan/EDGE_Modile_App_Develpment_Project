package com.example.eventmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class createevent extends AppCompatActivity {
    AutoCompleteTextView atotxt;
    Button btn;
    ArrayList<String> spins=new ArrayList<>();
    ArrayList<String>listvalues=new ArrayList<>();
    ArrayList<String>autovalues=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_createevent);
        atotxt=findViewById(R.id.autotxt);
        autovalues.add("Birthday");

        autovalues.add("Wedding");
        autovalues.add(" Party");
        autovalues.add("Concert");
        autovalues.add("Dinner");
        autovalues.add("Engagement");

        ArrayAdapter<String>autoaddapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,autovalues);
        atotxt.setAdapter(autoaddapter);
        btn=findViewById(R.id.create);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), weddingactivity.class);
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