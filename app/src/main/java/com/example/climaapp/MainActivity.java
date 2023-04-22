package com.example.climaapp;


import static android.webkit.ConsoleMessage.MessageLevel.LOG;

import androidx.annotation.ContentView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ThemedSpinnerAdapter;
import androidx.core.app.ActivityCompat;
import androidx.loader.content.AsyncTaskLoader;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Process;
import android.provider.SyncStateContract;
import android.util.Log;
import android.widget.*;
import android.Manifest.permission;
import android.provider.*;

import android.os.Bundle;

import com.example.climaapp.Helper.Helper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.PicassoProvider;

import java.lang.reflect.Type;
import java.util.List;
import com.example.*;
import java.*;

import ClimaCo.Clima;
import Coordenada.Coordenada;
import Coordenada.OpenWeatherMap;


public class MainActivity extends AppCompatActivity implements LocationListener {

    TextView txtcity, txtPrimeraActualizacion, txtDescripcion, txtHumedad, txtTiempo, txtCelcius;
    ImageView ImagenView;
    LocationManager locationManager;
    String provider;
    static double lan, lng;
    OpenWeatherMap openWeatherMap = new OpenWeatherMap();

    int MY_PERMISSION = 0;


    @SuppressLint("ServiceCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Control
        txtcity = (TextView) findViewById(R.id.txtCity);
        txtPrimeraActualizacion = (TextView) findViewById(R.id.txtPrimeraActualizacion);
        txtDescripcion = (TextView) findViewById(R.id.txtDescripcion);
        txtHumedad = (TextView) findViewById(R.id.txtHumedad);
        txtTiempo = (TextView) findViewById(R.id.txtTiempo);
        txtCelcius = (TextView) findViewById(R.id.txtCelcius);
        ImagenView = (ImageView) findViewById(R.id.ImagenView);

        //CARDILADAD
        locationManager = (LocationManager) getSystemService(Context.LOCALE_SERVICE);
        provider = locationManager.getBestProvider(new Criteria(), false);

        if (ActivityCompat.checkSelfPermission(this, permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(MainActivity.this, new String[]{
                    permission.INTERNET,
                    permission.ACCESS_COARSE_LOCATION,
                    permission.ACCESS_FINE_LOCATION,
                    permission.ACCESS_NETWORK_STATE,
                    permission.SYSTEM_ALERT_WINDOW,
                    permission.WRITE_EXTERNAL_STORAGE,

            }, MY_PERMISSION);

        }

        Location location = locationManager.getLastKnownLocation(provider);
        if (location == null) {
            Log.e("TAG", "NO LOCALIZADO");

        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        locationManager.removeUpdates(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (ActivityCompat.checkSelfPermission(this, permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{
                    permission.INTERNET,
                    permission.ACCESS_COARSE_LOCATION,
                    permission.ACCESS_FINE_LOCATION,
                    permission.ACCESS_NETWORK_STATE,
                    permission.SYSTEM_ALERT_WINDOW,
                    permission.WRITE_EXTERNAL_STORAGE,

            }, MY_PERMISSION);
        }
        locationManager.requestLocationUpdates(provider, 400, 1, this);
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        lan = location.getLatitude();
        lng= location.getLongitude();
        new GetClima().execute(Clima.apiResquest(String.valueOf(lan),String.valueOf(lng)));

    }

    @Override
    public void onLocationChanged(@NonNull List<Location> locations) {
        LocationListener.super.onLocationChanged(locations);
    }

    @Override
    public void onFlushComplete(int requestCode) {
        LocationListener.super.onFlushComplete(requestCode);
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        LocationListener.super.onStatusChanged(provider, status, extras);
    }

    @Override
    public void onProviderEnabled(@NonNull String provider) {
        LocationListener.super.onProviderEnabled(provider);
    }

    @Override
    public void onProviderDisabled(@NonNull String provider) {
        LocationListener.super.onProviderDisabled(provider);



    }
    private class GetClima extends AsyncTask<String,Void,String> {
        ProgressDialog PD = new ProgressDialog(MainActivity.this);
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            PD.setTitle("Por Favor Espere");
            PD.show();
        }
        @Override
        protected String doInBackground(String... strings) {
            String stream = null;
            String urlString = strings[0];
            Helper http = new Helper();
            stream = http.getHTTPData(urlString);


            return stream;

        }
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (s.contains("Error ")) {
                PD.dismiss();
                return;
            }
            Gson gson = new Gson();
            Type mType = new TypeToken<OpenWeatherMap>() {
            }.getType();
            openWeatherMap = gson.fromJson(s, mType);
            PD.dismiss();
            txtcity.setText(String.format("%s,%s", openWeatherMap.getName(), openWeatherMap.getSys().getPaís()));
            txtPrimeraActualizacion.setText(String.format("Actualizacion: %s", Clima.getDateNow()));
            txtDescripcion.setText(String.format("%s", openWeatherMap.getClima().get(0).getDescripcion()));
            txtHumedad.setText(String.format("%d%%", openWeatherMap.getInicio().getHumedad()));
            txtTiempo.setText(String.format("%s/% s", Clima.unixTimeStampToDateTime(openWeatherMap.getSys().getAmanecer()), Clima.unixTimeStampToDateTime(openWeatherMap.getSys().getSunset())));
            txtCelcius.setText(String.format("%.2f °C", openWeatherMap.getInicio().getTemp()));
        }
    }
}