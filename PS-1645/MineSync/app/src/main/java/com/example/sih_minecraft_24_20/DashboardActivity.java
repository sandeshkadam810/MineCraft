package com.example.sih_minecraft_24_20;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class DashboardActivity extends AppCompatActivity {
    TextView titleHome;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userId;
    String temp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        titleHome = findViewById(R.id.titleHome);
        CardView cardcolleague;
        CardView cardMyLog;
        CardView cardProfile;
        CardView cardScanner;
        ImageView qr;


        cardcolleague = findViewById(R.id.cardcolleague);
        cardMyLog = findViewById(R.id.cardMyLog);
        cardProfile = findViewById(R.id.cardProfile);
        cardScanner = findViewById(R.id.cardScanner);
        qr = findViewById(R.id.qr);


        fAuth = FirebaseAuth.getInstance();
        fStore= FirebaseFirestore.getInstance();
        userId = fAuth.getCurrentUser().getUid();

        DocumentReference documentReference = fStore.collection("users").document(userId);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {

                SharedPreferences sh = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);

                if(sh.getString("User_Type", "").equals("Admin"))
                {
                    titleHome.setText("Name: " + documentSnapshot.getString("Fullname"));
                    //qr.setEnabled(false);
                }
                else {
                    titleHome.setText("Welcome " + documentSnapshot.getString("Fullname"));

                    SharedPreferences.Editor myEdit = sh.edit();
                    myEdit.putString("Name", documentSnapshot.getString("Fullname") );
                    myEdit.commit();

                }
                temp = documentSnapshot.getString("Fullname");

            }
        });
//

        cardProfile.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(DashboardActivity.this, ProfileView.class));
            }
        });

        cardMyLog.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(DashboardActivity.this, UploadMain.class));
            }
        });

        cardScanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sh = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);

                if(sh.getString("User_Type", "").equals("Admin"))
                {
                    Toast.makeText(DashboardActivity.this, "Admin cannot access this particular field!", Toast.LENGTH_SHORT).show();

                }
                else {
                    Intent i = new Intent(DashboardActivity.this, QrScannerActivity.class);
                    i.putExtra("Title", temp);
                    startActivity(i);
                }

            }
        });

        qr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences sh = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);

                if(sh.getString("User_Type", "").equals("Admin"))
                {
                    Toast.makeText(DashboardActivity.this, "Admin cannot access this particular field!", Toast.LENGTH_SHORT).show();

                }
                else {
                    Intent i = new Intent(DashboardActivity.this, Qr.class);
                    i.putExtra("Title", temp);
                    startActivity(i);
                }

            }
        });



        cardcolleague.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                SharedPreferences sh = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);

                if(sh.getString("User_Type", "").equals("admin"))
                {
                    Toast.makeText(DashboardActivity.this, "Admin cannot access this particular field!", Toast.LENGTH_SHORT).show();

                }
                else {

                    Intent i = new Intent(DashboardActivity.this , colleague.class);
                    startActivity(i);

                }
            }
        });






    }
}