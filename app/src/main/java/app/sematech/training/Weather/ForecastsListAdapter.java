package app.sematech.training.Weather;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import app.sematech.training.PublicMethod;
import app.sematech.training.R;
import app.sematech.training.Weather.models.Forecast;

/**
 * Created by abanihashemi on 7/28/2018.
 */

public class ForecastsListAdapter extends BaseAdapter {
    Context mContext;
    List<Forecast> forecasts;

    @Override
    public int getCount() {
        return forecasts.size();
    }

    public ForecastsListAdapter(Context mContext, List<Forecast> forecasts) {

        List<Forecast> temp = forecasts.subList(1, forecasts.size() - 1);

        this.mContext = mContext;
        this.forecasts = temp;
    }

    @Override
    public Object getItem(int position) {
        return forecasts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        String code;
        View v = LayoutInflater.from(mContext).inflate(R.layout.forecast_list_item, viewGroup, false);
        TextView date = (TextView) v.findViewById(R.id.date);
        TextView high = (TextView) v.findViewById(R.id.high);
        TextView low = (TextView) v.findViewById(R.id.low);
        TextView text = (TextView) v.findViewById(R.id.text);
        ImageView image = (ImageView) v.findViewById(R.id.image_weather);

        Forecast thisForecast = (Forecast) getItem(position);

        code = thisForecast.getCode();
        text.setText(thisForecast.getText());
        date.setText(thisForecast.getDay());
        high.setText(Math.round(PublicMethod.convertFahrenheittoCelsiusMethod(thisForecast.getHigh())) + "");
        low.setText(Math.round(PublicMethod.convertFahrenheittoCelsiusMethod(thisForecast.getLow())) + "");
        text.setText(thisForecast.getText());

        PublicMethod.switchClassMethod(code,image);

        return v;
    }
}


