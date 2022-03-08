package com.yavuzselim.kenny;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView skortext;
    TextView timetext;
    int skor;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;
    ImageView imageView10;
    ImageView imageView11;
    ImageView imageView12;
    ImageView imageView13;
    ImageView imageView14;
    ImageView imageView15;
    ImageView imageView16;
    ImageView imageView17;
    ImageView imageArray[];
    Handler handler;
    Runnable runnable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        skortext = findViewById(R.id.skortext);
        timetext = findViewById(R.id.timetext);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        imageView7 = findViewById(R.id.imageView7);
        imageView8 = findViewById(R.id.imageView8);
        imageView9 = findViewById(R.id.imageView9);
        imageView10 = findViewById(R.id.imageView10);
        imageView11 = findViewById(R.id.imageView11);
        imageView12 = findViewById(R.id.imageView12);
        imageView13 = findViewById(R.id.imageView13);
        imageView14 = findViewById(R.id.imageView14);
        imageView15 = findViewById(R.id.imageView15);
        imageView16 = findViewById(R.id.imageView16);
        imageView17 = findViewById(R.id.imageView17);


        imageArray = new ImageView[]{
                imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8,
                imageView9, imageView10, imageView11, imageView12, imageView13, imageView14,
                imageView15, imageView16, imageView17
        };


        skor = 0;
        hideimage();

        new CountDownTimer(16000, 1000) {


            @Override
            public void onTick(long millisUntilFinished) {
                timetext.setText("zaman:"+millisUntilFinished/1000);

            }

            @Override
            public void onFinish() {
                Toast.makeText(getApplicationContext(),"game over",Toast.LENGTH_LONG).show();
                timetext.setText("oyun bitti");
                handler.removeCallbacks(runnable);
                for (ImageView image:imageArray){
                    image.setVisibility(View.INVISIBLE);
                }

                AlertDialog.Builder alert=new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("uyarı mesajı");
                alert.setMessage("oyun yeniden başlatılsınmı");
                alert.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent=getIntent();
                        finish();
                        startActivity(intent);
                    }
                });

                alert.setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"oyun bitti",Toast.LENGTH_LONG).show();


                    }
                });
               alert.show();
            }
        }.start();


    }
    

    public void skorart(View view) {
        skor++;
        skortext.setText("skor:" + skor);
    }


    public void hideimage() {
        handler=new Handler();
        runnable=new Runnable() {
            @Override
            public void run() {
                for (ImageView image:imageArray){
                    image.setVisibility(View.INVISIBLE);
                }

                Random random=new Random();
                int i= random.nextInt(16);
                imageArray[i].setVisibility(View.VISIBLE);
                handler.postDelayed(this,400);

            }

        };
        handler.post(runnable);


    }


}

