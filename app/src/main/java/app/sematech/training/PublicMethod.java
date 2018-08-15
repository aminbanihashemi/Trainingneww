package app.sematech.training;

import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class PublicMethod {
    public static Double convertFahrenheittoCelsiusMethod(String high) {
        Double celsius;
        return celsius = (5.0 / 9.0) * (Integer.parseInt(high) - 32.0);
    }

    public static void switchClassMethod(String high, ImageView img) {

        switch (high) {
            case "0":
                Picasso.get().load(R.drawable.tornado_0).into(img);
                break;
            case "1":
                Picasso.get().load(R.drawable.tornado_0).into(img);
                break;
            case "2":
                Picasso.get().load(R.drawable.hurricane_02).into(img);
                break;
            case "3":
                Picasso.get().load(R.drawable.storm_3).into(img);
                break;
            case "4":
                Picasso.get().load(R.drawable.storm_4).into(img);
                break;
            case "5":
                Picasso.get().load(R.drawable.storm_4).into(img);
                break;
            case "6":
                Picasso.get().load(R.drawable.storm_4).into(img);
                break;
            case "7":
                Picasso.get().load(R.drawable.storm_4).into(img);
                break;
            case "8":
                Picasso.get().load(R.drawable.temperature_8).into(img);
                break;
            case "9":
                Picasso.get().load(R.drawable.storm_4).into(img);
                break;
            case "10":

                break;
            case "11":
                Picasso.get().load(R.drawable.rain_11_12).into(img);
                break;
            case "12":
                Picasso.get().load(R.drawable.rain_11_12).into(img);
                break;
            case "13":

                break;
            case "14":

                break;
            case "15":

                break;
            case "16":
                Picasso.get().load(R.drawable.snow_16).into(img);
                break;
            case "17":
                Picasso.get().load(R.drawable.hail).into(img);
                break;
            case "18":
                Picasso.get().load(R.drawable.sleet).into(img);
                break;
            case "19":

                break;
            case "20":
                Picasso.get().load(R.drawable.foggy).into(img);
                break;
            case "21":

                break;
            case "22":

                break;
            case "23":

                break;
            case "24":
                Picasso.get().load(R.drawable.windy_24).into(img);
                break;
            case "25":

                break;
            case "26":
                Picasso.get().load(R.drawable.cloudy_26).into(img);
                break;
            case "27":
                Picasso.get().load(R.drawable.cloud_27_29).into(img);
                break;
            case "28":
                Picasso.get().load(R.drawable.cloudy_28_30).into(img);
                break;
            case "29":
                Picasso.get().load(R.drawable.cloud_27_29).into(img);
                break;
            case "30":
                Picasso.get().load(R.drawable.cloudy_28_30).into(img);
                break;
            case "31":
                Picasso.get().load(R.drawable.moon_31).into(img);
                break;
            case "32":
                Picasso.get().load(R.drawable.sun_32).into(img);
                break;
            case "33":

                break;
            case "34":

                break;
            case "35":

                break;
            case "36":
                Picasso.get().load(R.drawable.temperature_36).into(img);
                break;
            case "37":

                break;
            case "38":

                break;
            case "39":

                break;
            case "40":

                break;
            case "41":

                break;
            case "42":

                break;
            case "43":
                Picasso.get().load(R.drawable.snowflake_43).into(img);
                break;
            case "44":

                break;
            case "45":

                break;
            case "46":

                break;
            case "47":

                break;
            case "3200":

                break;

        }
    }

}
