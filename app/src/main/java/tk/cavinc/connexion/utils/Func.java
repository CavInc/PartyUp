package tk.cavinc.connexion.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by cav on 26.04.20.
 */

public class Func {

    public static Date strToDate(String dateS, String mask){
        if (dateS.equals(" ")) return null;
        DateFormat format = new SimpleDateFormat(mask);
        try {
            return format.parse(dateS);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static String dateToStr(Date dateS,String mask){
        DateFormat format = new SimpleDateFormat(mask);
        return format.format(dateS);
    }

    public static Bitmap getPicSize(String mCurrentPhotoPath){
        int targetW = 400;
        int targetH = 300;

        // Читаем с inJustDecodeBounds=true для определения размеров
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        bmOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(mCurrentPhotoPath, bmOptions);

        int photoW = bmOptions.outWidth;
        int photoH = bmOptions.outHeight;

        // Determine how much to scale down the image
        int scaleFactor = Math.min(photoW/targetW, photoH/targetH);

        // Decode the image file into a Bitmap sized to fill the View
        bmOptions.inJustDecodeBounds = false;
        bmOptions.inSampleSize = scaleFactor;
        bmOptions.inPurgeable = true;
        bmOptions.inPreferredConfig = Bitmap.Config.RGB_565;

        Bitmap bitmap = BitmapFactory.decodeFile(mCurrentPhotoPath, bmOptions);

        return bitmap;

    }
}