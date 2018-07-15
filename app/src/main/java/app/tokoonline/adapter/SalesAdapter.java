package app.tokoonline.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

import app.tokoonline.R;

/**
 * Created by Irsyad on 11/13/2017.
 */

public class SalesAdapter extends SimpleAdapter {
    LayoutInflater inflater;
    Context context;
    ArrayList<HashMap<String, String>> arrayList;

    public SalesAdapter(Context context, ArrayList<HashMap<String, String>> data, int resource, String[] from, int[] to) {
        super(context, data, resource, from, to);
        this.context = context;
        this.arrayList = data;
        inflater.from(context);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);

        ImageView imgProduct = (ImageView) view.findViewById(R.id.imgProduct);
        Picasso.get().
                load( Uri.parse( "android.resource://app.tokoonline/drawable/" + arrayList.get(position).get("product")) )
                .resize(300, 300)
                .centerCrop()
                .into(imgProduct);

        // status
        ImageView imgCar    = (ImageView) view.findViewById(R.id.imgCar);
        ImageView imgDrop   = (ImageView) view.findViewById(R.id.imgDrop);
        ImageView imgFinish = (ImageView) view.findViewById(R.id.imgFinish);

        String shipment = "";
        switch (arrayList.get(position).get("shipment")){
            case "dikirim": shipment = "ic_trans_car2";
                break;
            case "belum dikirim": shipment = "ic_trans_car1";
                break;
        }
        Picasso.get().
                load( Uri.parse( "android.resource://app.tokoonline/mipmap/" + shipment) )
                .resize(300, 300).centerCrop()
                .into(imgCar);

        String drop = "";
        switch (arrayList.get(position).get("drop")){
            case "diterima": drop = "ic_trans_drop2";
                break;
            case "ditolak": drop = "ic_trans_drop1";
                break;
        }
        Picasso.get().
                load( Uri.parse( "android.resource://app.tokoonline/mipmap/" + drop) )
                .resize(300, 300).centerCrop()
                .into(imgDrop);

        String finish = "";
        switch (arrayList.get(position).get("finish")){
            case "selesai": finish = "ic_trans_finish2";
                break;
            case "pengembalian": finish = "ic_trans_finish1";
                break;
        }
        Picasso.get().
                load( Uri.parse( "android.resource://app.tokoonline/mipmap/" + finish) )
                .resize(300, 300).centerCrop()
                .into(imgFinish);

        return view;
    }
}
