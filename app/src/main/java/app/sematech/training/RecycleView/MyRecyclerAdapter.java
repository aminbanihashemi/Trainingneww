package app.sematech.training.RecycleView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import app.sematech.training.Carlist.CarItem;
import app.sematech.training.R;

/**
 * Created by abanihashemi on 8/5/2018.
 */

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.Holder> {
    Context mContext;
    List<CarItem> cars;

    public MyRecyclerAdapter(Context mContext, List<CarItem> cars) {
        this.mContext = mContext;
        this.cars = cars;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.cars_list_items, parent, false);
//        Holder h = new Holder(v);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        try {
            Glide.with(mContext).load(cars.get(position).getcImage()).into(holder.carImage);
            holder.carName.setText(cars.get(position).getcName());
            holder.carColor.setText(cars.get(position).getcColor());
            holder.carModel.setText(cars.get(position).getcModel());
        }catch (Exception e){
            Log.e("","");
        }
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        ImageView carImage;
        TextView carName, carModel, carColor;

        public Holder(View itemView) {
            super(itemView);
            carImage = (ImageView) itemView.findViewById(R.id.car_image);
            carName = (TextView) itemView.findViewById(R.id.car_name);
            carModel = (TextView) itemView.findViewById(R.id.car_model);
            carColor = (TextView) itemView.findViewById(R.id.car_color);

        }
    }
}
