package tk.cavinc.connexion.services;

import android.app.Service;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;


import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import tk.cavinc.connexion.utils.App;
import tk.cavinc.connexion.utils.ConstantManager;


//http://qaru.site/questions/62333/android-locationmanager-vs-google-play-services
//https://startandroid.ru/ru/uroki/vse-uroki-spiskom/291-urok-138-opredelenie-mestopolozhenija-gps-koordinaty.html
//https://habr.com/post/201648/

public class CheckCoordinateService extends Service {
    public static String LOCATION_CHANGE_ACTION = "tk.cavinc.connexion.coordinate.ACTION";
    public static String LOCATION_CHANGE_STATUS = "tk.cavinc.connexion.change.ACTION";

    private static final String TAG = "CCS";
    private final LocationManager locationManager;
    private boolean work = true;

    @SuppressWarnings("MissingPermission")
    public CheckCoordinateService() {
        locationManager = (LocationManager) App.getContext().getSystemService(LOCATION_SERVICE);

        List<String> listProvider = locationManager.getProviders(true);

        for (String l:listProvider) {
            Log.d(TAG," PROVIDER : "+l);
            if (l.equals("gps")) {
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                        1000 * 10, 10, locationListener);
            }
            if (l.equals("network")) {
                locationManager.requestLocationUpdates(
                        LocationManager.NETWORK_PROVIDER, 1000 * 10, 10,
                        locationListener);
            }
        }

        Log.d(TAG,LocationManager.GPS_PROVIDER);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        checkEnabled();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (work) {
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.d(TAG,"SERVICE DEST");
        locationManager.removeUpdates(locationListener);
    }

    private LocationListener locationListener = new LocationListener() {
        public static final String TAG = "LOCATION LISTENER";

        @Override
        public void onLocationChanged(Location location) {
            Log.d(TAG,"LOCATION CHANGED");
            showLocation(location);
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
            Log.d(TAG,"STATUS CHANGED");
            if (provider.equals(LocationManager.GPS_PROVIDER)) {
                Log.d(TAG,"Status: " + String.valueOf(status));
            } else if (provider.equals(LocationManager.NETWORK_PROVIDER)) {
                Log.d(TAG,"Status: " + String.valueOf(status));
            }
        }

        @SuppressWarnings("MissingPermission")
        @Override
        public void onProviderEnabled(String provider) {
            Log.d(TAG,"PROVIDER ENABLE");
            checkEnabled();
            showLocation(locationManager.getLastKnownLocation(provider));
        }

        @Override
        public void onProviderDisabled(String provider) {
            Log.d(TAG,"PROVIDER DISABLE");
            checkEnabled();
        }
    };

    private void checkEnabled() {
        Log.d(TAG,"GPS PROVIDER : "+locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER));
        Log.d(TAG,"NETWORK : "+locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER));
        Intent intent = new Intent(LOCATION_CHANGE_STATUS);
        intent.putExtra("GPS",locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER));
        intent.putExtra("NETWORK",locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER));
        sendBroadcast(intent);
        /*
        if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) | !locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
            Intent intent = new Intent(
                    android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        */
    }

    private String formatLocation(Location location) {
        if (location == null)
            return "";
        return String.format(
                "Coordinates: lat = %1$.4f, lon = %2$.4f, time = %3$tF %3$tT",
                location.getLatitude(), location.getLongitude(), new Date(
                        location.getTime()));
    }


    private void showLocation(Location location) {
        if (location == null)
            return;
        Intent intent = new Intent(LOCATION_CHANGE_ACTION);

        if (location.getProvider().equals(LocationManager.GPS_PROVIDER)) {
            Log.d(TAG,formatLocation(location));
            intent.putExtra(ConstantManager.LAT,location.getLatitude());
            intent.putExtra(ConstantManager.LOT,location.getLongitude());
        } else if (location.getProvider().equals(
                LocationManager.NETWORK_PROVIDER)) {
            Log.d(TAG,formatLocation(location));
            intent.putExtra(ConstantManager.LAT,location.getLatitude());
            intent.putExtra(ConstantManager.LOT,location.getLongitude());
        }
        sendBroadcast(intent);
    }
}
