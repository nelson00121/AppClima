package ClimaCo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Clima {
    public static String API_KEY = "ee5f93b87921904567499ac76724c6cf\n";
    public static String API_LINK = "http://api.openweathermap.org/data/2.5/weather";

    public static String apiResquest(String lat, String ing){
        StringBuilder sb = new StringBuilder(API_LINK);
        sb.append(String.format("?lat=%s&lon=%s&APPID=%s&units=metric",lat,ing,API_KEY));
        return sb.toString();
    }

    public static String unixTimeStampToDateTime(double unixTimeStamp){

        DateFormat dateFormat = new SimpleDateFormat("hh:mm");
        Date date = new Date();
        date.setTime((long)unixTimeStamp*100);
        return dateFormat.format(date);
    }

    public static String getImage(String icon){

        return String.format("http://api.openweathermap.org/img/w/es.png");
    }
    public static String getDateNow(){
        DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy HH:mm");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
