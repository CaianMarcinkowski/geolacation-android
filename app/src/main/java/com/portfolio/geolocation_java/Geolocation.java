package com.portfolio.geolocation_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Toast;

// Created by Caian Marcinkowski Ferreira
// Git: https://github.com/CaianMarcinkowski

public class Geolocation extends AppCompatActivity {
      
      @Override
      protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            getSupportActionBar().hide();
            setContentView(R.layout.activity_geolocation);
      }
      
      public void SearchGeolocation(View v) {
            
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                    ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                  
                  ActivityCompat.requestPermissions(Geolocation.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
                  ActivityCompat.requestPermissions(Geolocation.this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
                  ActivityCompat.requestPermissions(Geolocation.this, new String[]{Manifest.permission.ACCESS_NETWORK_STATE}, 1);
                  
                  return;
            }
            
            LocationManager locationManager = (LocationManager) getSystemService(Geolocation.this.LOCATION_SERVICE);
            LocationListener locationListener = new LocationListener();
            
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
            
            if (locationManager.isProviderEnabled(locationManager.GPS_PROVIDER)) {
                  String message = "Latitude: " + locationListener.getLatitude() + "/n" +
                          "Longitude: " + locationListener.getLongitude();
                  
                  Toast.makeText(Geolocation.this, message, Toast.LENGTH_LONG);
            } else {
                  Toast.makeText(Geolocation.this, "GPS not enabled!", Toast.LENGTH_LONG);
            }
            
            WebView webView = findViewById(R.id.wvMap);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.loadUrl("https://www.google.com/maps/search/?api=1&query=" + locationListener.getLatitude() + "," + locationListener.getLongitude());
      }
}