package com.example.databasesql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private Button b1,b2;
    private EditText nom, mail ,phone;
    Database dbb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.ajouter_base_button2);
        b2=(Button)findViewById(R.id.voir_BASE_button1);
        nom=(EditText)findViewById(R.id.nom_edittext3);
        mail=(EditText)findViewById(R.id.mail_edittext1);
        phone=(EditText)findViewById(R.id.tel_edittext2);
        dbb= new Database(this);
        b1.setOnClickListener(v ->{
            if(!nom.getText().toString().equalsIgnoreCase("")&&
                    !mail.getText().toString().equalsIgnoreCase("")&&
            !phone.getText().toString().equalsIgnoreCase("")
            ){
                Boolean insereted=dbb.insertdata(nom.getText().toString(),mail.getText().toString(),phone.getText().toString());
                if(insereted){
                    Toast.makeText(this, "intertion avec succés", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(this, "échec d'intertion", Toast.LENGTH_SHORT).show();
                }
            }
            else{
                Toast.makeText(this, "tous les champs doivent etre remplis", Toast.LENGTH_SHORT).show();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1=new Intent(MainActivity.this,ManagingDB.class);
                startActivity(int1);

            }
        });

    }

}