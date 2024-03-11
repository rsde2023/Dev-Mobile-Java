package com.example.databasesql;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ManagingDB extends AppCompatActivity {
    private Button b;
    private ListView lv;
    Database dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_managing_db);
        b = (Button) findViewById(R.id.button5);
        lv = (ListView) findViewById(R.id.list);
        dataBase = new Database(this);
        viewData();
        b.setOnClickListener(v -> {
            Intent int2 = new Intent(ManagingDB.this, MainActivity.class);
            startActivity(int2);
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                String[] items = {"modifier", "supprimer"};
                AlertDialog.Builder builder = new AlertDialog.Builder(ManagingDB.this);
                builder.setTitle("action");
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        if (which == 0) {
                            showUpdate(ManagingDB.this, lv, position);
                        } else {
                            delete(lv, position);
                        }
                    }
                });
                builder.show();

            }

        });
    }



    private void showUpdate(Activity ac, ListView lv, int p) {
        Dialog dialog=new Dialog(ac);
        dialog.setContentView(R.layout.update_db);
        dialog.setTitle("update");
        final EditText name=(EditText)dialog.findViewById(R.id.N_edittext);
        final EditText mail=(EditText)dialog.findViewById(R.id.E_edittext2);
        final EditText phone=(EditText)dialog.findViewById(R.id.T_edittext2);
        Button bt=(Button)dialog.findViewById(R.id.button2);
        final String[] chaine=lv.getAdapter().getItem(p).toString().split("");
        name.setText(chaine[1]);
        mail.setText(chaine[2]);
        phone.setText(chaine[3]);
        int width=(int)(ac.getResources().getDisplayMetrics().widthPixels*0.9);
        int height=(int)(ac.getResources().getDisplayMetrics().widthPixels*0.7);
        dialog.getWindow().setLayout(width,height);
        dialog.show();
        bt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int i=Integer.parseInt(chaine[0]);
                dataBase.update(name.getText().toString(),mail.getText().toString(),phone.getText().toString(),i);
                Toast.makeText(ManagingDB.this,"Mise à jour avec succés", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(ManagingDB.this,ManagingDB.class);
                startActivity(intent);
                viewData();

            }
        });


    }

    private void delete(ListView lv, int p) {
        String[] chaine=lv.getAdapter().getItem(p).toString().split("");
        int i=Integer.parseInt(chaine[0]);
        dataBase.delete(i);
        Toast.makeText(this,"suppression avec succés",Toast.LENGTH_SHORT).show();
        viewData();

    }
    private void viewData() {
        Cursor c =dataBase.getAllData();
        ArrayList<String> list= new ArrayList<>();
        if(c.getCount()==0){
            Toast.makeText(this, "la base est vide", Toast.LENGTH_SHORT).show();
        }
        else {
            while(c.moveToNext()){
                list.add(c.getString(0)+""+c.getString(1)+ ""+c.getString(2)+""+ c.getString(3));
                ListAdapter listAdapter=new ArrayAdapter<>(ManagingDB.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,list);
                lv.setAdapter(listAdapter);
            }
        }
    }

}