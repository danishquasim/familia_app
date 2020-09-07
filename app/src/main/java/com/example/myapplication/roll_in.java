package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class roll_in extends AppCompatActivity {
   TextView naam;
   TextView id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roll_in);
       naam = findViewById(R.id.acc_creator_name);
       id = findViewById(R.id.perm_family_id_no);
       show_the_data();
    }

    private void show_the_data() {
        Intent intent = getIntent();
        String creator_name = intent.getStringExtra("nme");
        String clan_id = intent.getStringExtra("familid");
        naam.setText(creator_name);
        id.setText(clan_id);
    }

}