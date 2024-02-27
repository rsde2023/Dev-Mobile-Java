package com.example.implicitintents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText zone1,zone2,zone3;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    static final int REQUEST_VIDEO_CAPTURE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        zone1=findViewById(R.id.website_edittext1);
        zone2=findViewById(R.id.location_edittext2);
        zone3=findViewById(R.id.share_edittext3);
        Button cambtn,vidcambtn;
        cambtn = findViewById(R.id.open_website_button4);
        vidcambtn = findViewById(R.id.open_website_button5);
        cambtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dispatchTakePictureIntent();
            }
        });
        vidcambtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dispatchTakeVideoIntent();
            }
        });
    }







    public void openWebsite(View view) {

        String url=zone1.getText().toString();
     Uri webPage= Uri.parse(url);
        Intent intent1=new Intent(Intent.ACTION_VIEW,webPage);
        if(intent1.resolveActivity(getPackageManager())!=null){
            startActivity(intent1);
        }
        else{
            Log.d("error","can't handle this ");
        }


    }

    public void openLocation(View view) {
        String adr=zone2.getText().toString();
        Uri adresse=Uri.parse("geo:0,0?q="+adr);
        Intent intent2=new Intent(Intent.ACTION_VIEW,adresse);
        if(intent2.resolveActivity(getPackageManager())!=null){
            startActivity(intent2);
        }
        else{
            Log.d("error","can't handle this ");
        }
    }
    public void shareText(View view) {
        String str=zone3.getText().toString();
        String mimeType="text/plain";
        ShareCompat.IntentBuilder.from(this).setType(mimeType).setChooserTitle("share text with").setText(str).startChooser();
    }


        private void dispatchTakePictureIntent() {
            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if(takePictureIntent.resolveActivity(getPackageManager())!=null){
                startActivity(takePictureIntent);
            }
            else{
                Log.d("error","can't handle this ");
            }
        }
    private void dispatchTakeVideoIntent() {
        Intent takeVideoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        if (takeVideoIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takeVideoIntent, REQUEST_VIDEO_CAPTURE);
        }
        else {
            Log.d("error","can't handle this ");
        }
    }
        }



