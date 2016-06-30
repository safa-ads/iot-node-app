package com.example.dell.iotnodeapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.ui.BubbleIconFactory;
import com.google.maps.android.ui.IconGenerator;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,GoogleMap.OnMarkerClickListener  {

    private GoogleMap mMap;
    private Marker googleMarker;
    private Marker googleMarker2;
    private Marker googleMarker3;
    private  IconGenerator mIconGenerator;
    //private final IconGenerator mClusterIconGenerator = new IconGenerator(getApplicationContext());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        //icon generator
        mIconGenerator =   new IconGenerator(getApplicationContext());
        Bitmap icon_marker1 = mIconGenerator.makeIcon("C-Building, room:C5-302" );
        Bitmap icon_marker2 = mIconGenerator.makeIcon("D-Building, room:D2-209" );
        Bitmap icon_marker3 = mIconGenerator.makeIcon("B-Building, room:B5-102" );
        mIconGenerator.setColor(5);
        googleMap.setOnMarkerClickListener(this);

        LatLng GUC = new LatLng(29.9882, 31.4413);

        googleMarker = mMap.addMarker((new MarkerOptions().icon(BitmapDescriptorFactory.fromBitmap(icon_marker1)))
                        .position(GUC)


        );
         googleMarker2 = mMap.addMarker((new MarkerOptions().icon(BitmapDescriptorFactory.fromBitmap(icon_marker2)))
                         .position(new LatLng(29.988, 31.4413))

         );
         googleMarker3 = mMap.addMarker(((new MarkerOptions().icon(BitmapDescriptorFactory.fromBitmap(icon_marker3))))
                         .position(new LatLng(29.9882, 31.441))

       );
//        googleMarker3.showInfoWindow();
//        googleMarker.showInfoWindow();
//        googleMarker2.showInfoWindow();

        mMap.moveCamera(CameraUpdateFactory.newLatLng(GUC));
//        LatLng sydney = new LatLng(-34, 151);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        if (marker.equals(googleMarker) || marker.equals(googleMarker2) || marker.equals(googleMarker3) ) {
            //handle click here
            Intent intent = new Intent("com.example.dell.iotnodeapp.sensors");
            startActivity(intent);
        }
        return true;
    }


}
