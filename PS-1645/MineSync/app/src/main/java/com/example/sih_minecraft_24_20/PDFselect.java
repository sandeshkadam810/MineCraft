package com.example.sih_minecraft_24_20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PDFselect extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfselect);

        listView = findViewById(R.id.listView);

        // Only one document type: "Logbook"
        int[] imageID = {R.drawable.log_book}; // Add an appropriate drawable resource for "Logbook"
        String[] name = {"Logbook"};

        ArrayList<ListClass> classArrayList = new ArrayList<>();

        // Only one item to add
        ListClass listelement = new ListClass(name[0], imageID[0]);
        classArrayList.add(listelement);

        CustomListAdapter listAdapter = new CustomListAdapter(PDFselect.this, classArrayList);

        listView.setAdapter(listAdapter);
        listView.setClickable(true);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(PDFselect.this, RetrievePDFActivity.class);
                intent.putExtra("TypeofDoc", name[i]); // Will always be "Logbook" in this case
                startActivity(intent);
            }
        });
    }
}
