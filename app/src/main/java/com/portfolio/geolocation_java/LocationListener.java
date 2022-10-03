package com.portfolio.geolocation_java;

import android.location.Location;
import android.os.Bundle;

import androidx.annotation.NonNull;

// Created by Caian Marcinkowski Ferreira
// Git: https://github.com/CaianMarcinkowski

public class LocationListener implements android.location.LocationListener {
      
      private static double latitude, longitude;
      
      @Override
      public void onLocationChanged(@NonNull Location location) {
            this.latitude = location.getLatitude();
            this.longitude = location.getLongitude();
      }
      
      public static double getLatitude() {
            return latitude;
      }
      
      public static double getLongitude() {
            return longitude;
      }
      
      @Override
      public void onStatusChanged(String provider, int status, Bundle extras) {
            android.location.LocationListener.super.onStatusChanged(provider, status, extras);
      }
      
      @Override
      public void onProviderEnabled(@NonNull String provider) {
            android.location.LocationListener.super.onProviderEnabled(provider);
      }
      
      @Override
      public void onProviderDisabled(@NonNull String provider) {
            android.location.LocationListener.super.onProviderDisabled(provider);
      }
}
