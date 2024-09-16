package com.example.sih_minecraft_24_20;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class userType extends AppCompatActivity {

    CardView Admin_Card, User_Card;

 //Faltu commitww

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_type);

        final RelativeLayout relativeLayout;
        Admin_Card = findViewById(R.id.cardViewTeacher);
        User_Card = findViewById(R.id.cardViewStudent);


        Admin_Card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
                SharedPreferences.Editor myEdit = sharedPreferences.edit();
                myEdit.putString("User_Type", "User");
                myEdit.commit();
                Intent intent = new Intent(userType.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        User_Card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
                SharedPreferences.Editor myEdit = sharedPreferences.edit();
                myEdit.putString("User_Type", "Admin");
                myEdit.commit();
                Intent intent = new Intent(userType.this, LoginActivity.class);
                startActivity(intent);


            }
        });





    }


}