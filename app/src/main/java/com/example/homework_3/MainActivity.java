package com.example.homework_3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ProgressBar pbProgress;
    TextView txtProgress;
    private Handler handler = new Handler();
    int proggresStaus;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtProgress =(TextView) findViewById(R.id.txtProgress);
        pbProgress = (ProgressBar) findViewById(R.id.pbProgress);

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Uyarı !");
        alert.setMessage("Diğer sayfaya geçmek ister misiniz");
        alert.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                startActivity(new Intent(MainActivity.this , SecondActivity.class));
            }
        });
        alert.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(proggresStaus < 100){
                    proggresStaus++;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            pbProgress.setProgress(proggresStaus);
                            txtProgress.setText(" "+proggresStaus);
                            if (proggresStaus == 100){
                                alert.show();
                            }
                        }
                    });

                    try {
                        Thread.sleep(100);
                    }
                    catch (InterruptedException e){
                        e.printStackTrace();
                    }

                }
            }
        }).start();







    }
}