package com.example.appdemo;


import android.annotation.SuppressLint;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.text.DateFormat;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        String kernelVersion = System.getProperty("os.version");
        ApplicationInfo info=getApplicationInfo();
        final int target=info.targetSdkVersion;

        File arq;
        String filePath = "/storage/emulated/0/TesteFile.txt";
        arq = new File(filePath);
        Long ultDt = arq.lastModified();
        DateFormat df = DateFormat.getDateTimeInstance();
        String newDate = df.format(ultDt);

        textView.setText("My Plataforn: "+myPlataforn() + "\nData: " +newDate + "\nSDK Version: "+target+
                "\nKernel Version: "+kernelVersion);
    }

    public static String myPlataforn(){

        String plataforma = "";

        if(Build.FINGERPRINT.contains("generic"))
        {
            plataforma = "Emulador";
        }else if(Build.FINGERPRINT.contains("vbox"))
        {
            plataforma = "VirtualBox";
        }else if(Build.FINGERPRINT.contains("generic_x86"))
        {
            plataforma = "Emulator x86";
        }else if(Build.BRAND.contains("google") && Build.MODEL.startsWith("Pixel"))
        {
            plataforma = "Dispositivo pixel";
        }else if (Build.MANUFACTURER.equalsIgnoreCase("samsung"))
        {
            plataforma = "Dispositivo Sansung";
        }else if (Build.MANUFACTURER.equalsIgnoreCase("xiaomi"))
        {
            plataforma = "Dispositivo Xiomi";
        }
        System.out.println("PLATAFORMA: "+plataforma);
        return plataforma;
    }
}