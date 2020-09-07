package com.example.myapplication;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import static android.app.ActivityOptions.makeSceneTransitionAnimation;

public class MainActivity12 extends AppCompatActivity {

    Button login ,newclan;
    //ImageView first;
    TextView secon;
    EditText third;
    EditText fourth;
    Button signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main12);
        signup = findViewById(R.id.sign_up);
        //hhookoko
        //first = findViewById(R.id.imageView);
        secon = findViewById(R.id.textView2);
        third = findViewById(R.id.fmaily_id_entered);
        fourth = findViewById(R.id.req_pass);
        login = findViewById(R.id.sign_in);
        newclan = findViewById(R.id.sign_up);
        signup.setOnClickListener(new View.OnClickListener(){
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity12.this, SignUp.class);
             // Pair[]  pairs= new Pair[5];
               //pairs[0] = new Pair<View,String>(first,"logo_image");
               /* pairs[0] = new Pair<View,String>(secon,"tag_line");
                pairs[1] = new Pair<View,String>(third,"family_id");
                pairs[2] = new Pair<View,String>(fourth,"password");
                pairs[3] = new Pair<View,String>(login,"signin");
                pairs[4] = new Pair<View,String>(newclan,"signup");*/
             /*Pair.create((View) secon, "logo_image");
             Pair.create((View) third, "tag_line");
             Pair.create((View) fourth, "password");
             Pair.create((View) login, "signin");
             Pair.create((View) newclan, "signup");*/



                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation( MainActivity12.this, android.util.Pair.create((View) secon, "logo_image"),
                        android.util.Pair.create((View) third, "tag_line"), android.util.Pair.create((View) fourth, "password"), android.util.Pair.create((View) login, "signin"),
                        android.util.Pair.create((View) newclan, "signup"));
                startActivity(intent,options.toBundle());
                finish();

            }
        });
    }
    public boolean validate_id(){
        String value = third.getEditableText().toString();
        String noWhiteSpace = "\\S+";
        if(value.length()<5){
            third.setError("The ID can't be empty");
            return false;
        }
        /*else if(value.length()>=15){
            third.setError("The ID must be of less than length 15");
            return false;
        }
       else if(!value.matches(noWhiteSpace)){
                third.setError("No space allowed in ID");
                return false;
        }*/
        else
        {
            third.setError(null);
            return true;
        }

    }
    public boolean validate_password(){
        String value = fourth.getEditableText().toString();
        /*
        if(value.isEmpty()){
            password.setError("The password can't be Empty");
            return false;
        }
        else if(!value.matches(correct_pass)){
            password.setError("Passcode is too weak");
            return false;
        }
        else*/
        if(value.isEmpty())
        {
            fourth.setError("The Passcode can't be empty");
            return false;
        }
        else
        {
        fourth.setError(null);
        return true;
        }

    }

    //login button call
    public void login_user(View view){
        if(!validate_id() | !validate_password()){
            return ;
        }
        else
        {
            is_user();
        }
    }

    private void is_user() {
        final String user_entered_id = third.getEditableText().toString().trim();
        //final String user_entered_pass = fourth.getEditableText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");

        Query check_id = reference.orderByChild("familid").equalTo(user_entered_id);

        check_id.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    third.setError(null);
                    String pass_from_db = dataSnapshot.child(user_entered_id).child("pasword").getValue(String.class);
                    String user_entered_pass = fourth.getEditableText().toString().trim();
                    if(pass_from_db.equals(user_entered_pass)){
                        String id_stored_db = dataSnapshot.child(user_entered_id).child("familid").getValue(String.class);
                        String name_stored_db = dataSnapshot.child(user_entered_id).child("nme").getValue(String.class);

                        Intent intent = new Intent(MainActivity12.this, roll_in.class);

                        intent.putExtra("familid",id_stored_db); //pass to profile screen
                        intent.putExtra("nme",name_stored_db); //pass to profile screen

                        startActivity(intent);
                    }
                    else
                    {
                        fourth.setError("Wrong Password");
                        fourth.requestFocus();
                    }
                }
                else {
                    third.setError("No such clan with Id exists");
                    third.requestFocus();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}