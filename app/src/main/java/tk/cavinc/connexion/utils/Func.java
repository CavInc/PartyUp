package tk.cavinc.connexion.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
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

    // MD5 строки
    public static String MD5(String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes("UTF-8"));
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    // битмап в строку
    public static String imgToStr(Bitmap bitmap){
        if (bitmap == null) {
            return "";
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,baos);
        byte[] byteArrayItem = baos.toByteArray();
        return Base64.encodeToString(byteArrayItem,Base64.NO_WRAP+Base64.NO_PADDING);
    }

    // возвращает даные о картинке в битма
    public static Bitmap getBitmapInFile(String url) throws IOException {
        //Bitmap bit= BitmapFactory.decodeStream(new URL(url).openStream());
        Bitmap bit = BitmapFactory.decodeFile(url);
        return bit;
    }

    // вернуть строку из url картинки
    public static String getUtlToStr(String url,boolean resize) {
        String ret = "none";
        if (url == null) {
            return ret;
        }
        try {
            if (resize) {
                ret = imgToStr(getPicSize(url));
            } else {
                ret = imgToStr(getBitmapInFile(url));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }
}
