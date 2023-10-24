package com.example.gpsmapa;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class ArchivoMultimedia extends AppCompatActivity{
    private videoView videito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_archivo_multimedia)

        videito = findViewById(R.id.videoView);

        videito videoView = findViewById(R.id.videoView);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.SantoTomas; // Reemplaza "nombre_del_video" con el nombre de tu archivo de video sin la extensión
        Uri videoUri = Uri.parse(videoPath);
        videoView.setVideoURI(videoUri);
        videoView.start();
    }
}