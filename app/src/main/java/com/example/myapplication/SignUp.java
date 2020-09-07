package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;

public class SignUp extends AppCompatActivity {

    //naming
    EditText familyhead ,name,familyid,password, emailid;
    Button regbutton ,prev_reg_button;
    FirebaseDatabase main;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        //connecting with xml
        familyhead =findViewById(R.id.editTextTextPersonName2);
        name =findViewById(R.id.editTextTextPersonName3);
        familyid =findViewById(R.id.editTextTextPersonName4);
        password =findViewById(R.id.editTextTextPassword2);
        emailid =findViewById(R.id.editTextTextPersonName6);
        regbutton =findViewById(R.id.button2);
        prev_reg_button =findViewById(R.id.button3);

        prev_reg_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(SignUp.this,MainActivity12.class);
                startActivity(intent);
                finish();
            }

        });
        //new data entry
       /* regbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                main= FirebaseDatabase.getInstance();
                reference = main.getReference("users");
                //inputs
                String familyead, nme, familid, pasword, emalid;
                familyead = familyhead.getEditableText().toString();
                nme = name.getEditableText().toString();
                familid = familyid.getEditableText().toString();
                pasword = password.getEditableText().toString();
                emalid = emailid.getEditableText().toString();
                registereduser newuser =new registereduser(familyead, nme, familid, pasword, emalid);
                reference.child(familid).setValue(newuser);
            }
        });//new entry end*/
        /*regbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               /* main = FirebaseDatabase.getInstance();
                reference = main.getReference("users");
                String familyead, nme, familid, pasword, emalid;
                familyead = familyhead.getEditableText().toString();
                nme = name.getEditableText().toString();
                familid = familyid.getEditableText().toString();
                pasword = password.getEditableText().toString();
                emalid = emailid.getEditableText().toString();
                registereduser helperclass = new registereduser(familyead, nme, familid, pasword, emalid);
                reference.child(familid).setValue(helperclass);
               // registerUser(null);
            }
        });*/
    }//oncreatelsat

    public boolean checkCondition_familyhead(){
        String value = familyhead.getEditableText().toString();
        if(value.isEmpty()){
            familyhead.setError("This field can't be empty");
            return false;
            //familyhead.setErrorEnabled(false);
        }
        else
        {
            familyhead.setError(null);
            return true;
        }

    }
    public boolean checkCondition_name(){
        String value = name.getEditableText().toString();
        if(value.isEmpty()){
            name.setError("This field can't be empty");
            return false;
        }
        else
        {
            name.setError(null);
            return true;
        }

    }
    public boolean checkCondition_id(){
        String value = familyid.getEditableText().toString();
        String noWhiteSpace = "\\S+";
        if(value.length()<5){
            familyid.setError("The ID must be of minimun length 5");
            return false;
        }
        else if(value.length()>=15){
            familyid.setError("The ID must be of less than length 15");
            return false;
        }
        else if(!value.matches(noWhiteSpace)){
            familyid.setError("No space allowed in ID");
            return false;
        }
        else
        {
            familyid.setError(null);
            return true;
        }

    }
    //public static final Pattern
    public boolean checkCondition_password(){
        String value = password.getEditableText().toString();
        /*String correct_pass = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+";
                //"^" +
                //"(?=.*[0-9])" +         //at least 1 digit
                //"(?=.*[a-z])" +         //at least 1 lower case letter
                //"(?=.*[A-Z])" +         //at least 1 upper case letter
               // "(?=.*[a-zA-Z])" +      //any letter
                //"(?=.*[@#$%^&+=])" +    //at least 1 special character//
               // "(?=\\s+$)" +           //no white spaces
                //".{4,}" +               //at least 4 characters
                //"$";
        if(value.isEmpty()){
            password.setError("The password can't be Empty");
            return false;
        }
        else if(!value.matches(correct_pass)){
            password.setError("Passcode is too weak");
            return false;
        }
        else*/
        //{
            password.setError(null);
            return true;
        //}

    }//this is blank have to write for password condition
    public boolean checkCondition_emailid(){
        String value = emailid.getEditableText().toString();
        String regix_pattern = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+";
        if(value.isEmpty()){
            emailid.setError("This field can't be empty");
            return false;
        }
        else if(!value.matches(regix_pattern)){
            emailid.setError("Invalid Email Address");
            return false;
        }
        else
        {
            emailid.setError(null);
            return true;
        }
    }
    public void registerUser(View view){
        if(!checkCondition_familyhead() | !checkCondition_name() | !checkCondition_id() | !checkCondition_password() | !checkCondition_emailid()){
            return ;
        }
            //get all values and store it
        main = FirebaseDatabase.getInstance();
        reference = main.getReference("users");
        String familyead, nme, familid, pasword, emalid;
        familyead = familyhead.getEditableText().toString();
        nme = name.getEditableText().toString();
        familid = familyid.getEditableText().toString();
        pasword = password.getEditableText().toString();
        emalid = emailid.getEditableText().toString();
        registereduser newuser =new registereduser(familyead, nme, familid, pasword, emalid);
        reference.child(familid).setValue(newuser);

    }
}