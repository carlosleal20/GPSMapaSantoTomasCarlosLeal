package com.example.gpsmapa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener {
    EditText txtLatitud, txtLongitud;
    GoogleMap mMap;

    // Coordenadas de las 13 sedes de la UST
    LatLng[] sedeLocations = {
            new LatLng(-18.4905823, -70.3192151),  // Arica
            new LatLng(-20.2397711, -70.1474536),  // Iquique
            new LatLng(-23.6347266, -70.3966275), // Antofagasta
            new LatLng(-29.9075923,-71.3181128), // La Serena
            new LatLng(-33.0370878, -71.5194853), //Viña del Mar
            new LatLng(-33.5029323, -70.8230044), //Santiago
            new LatLng(-35.4287059, -71.7335432), //Talca
            new LatLng(-36.8275799, -73.066932), //Concepcion
            new LatLng(-37.4720519, -72.3565698), //Los Angeles
            new LatLng(-38.7346547, -72.6045528), //Temuco
            new LatLng(-39.8174128, -73.2357077), //Valdivia
            new LatLng(-40.5717867, -73.1402901), //Osorno
            new LatLng(-41.4727985, -73.1158325), //Puerto Montt
    };
    String[] sedeNames = {
            "Arica",
            "Iquique",
            "Antofagasta",
            "La Serena",
            "Viña del Mar",
            "Santiago",
            "Talca",
            "Concepcion",
            "Los Angeles",
            "Temuco",
            "Valdivia",
            "Osorno",
            "Puerto Montt"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtLatitud=findViewById(R.id.txt_Latitud);
        txtLongitud=findViewById(R.id.txt_Longitud);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.maps);
        mapFragment.getMapAsync(this);
    }
    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap=googleMap;
        this.mMap.setOnMapClickListener(this);
        this.mMap.setOnMapLongClickListener(this);

        for (int i = 0; i < sedeLocations.length; i++) {
            LatLng sedeLocation = sedeLocations[i];
            String sedeName = sedeNames[i];
            mMap.addMarker(new MarkerOptions().position(sedeLocations[i]).title("Sede " + (i + 1)));
        }

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-33.4691195, -70.641997), 5));


    }
    @Override
    public void onMapClick(@NonNull LatLng latLng) {
        txtLatitud.setText(""+latLng.latitude);
        txtLongitud.setText(""+latLng.longitude);
    }

    @Override
    public void onMapLongClick(@NonNull LatLng latLng) {
        txtLatitud.setText(""+latLng.latitude);
        txtLongitud.setText(""+latLng.longitude);
    }

}