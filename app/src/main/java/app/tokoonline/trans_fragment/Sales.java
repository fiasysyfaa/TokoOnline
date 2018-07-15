package app.tokoonline.trans_fragment;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import app.tokoonline.R;
import app.tokoonline.Status;
import app.tokoonline.adapter.SalesAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class Sales extends Fragment {

    ListView lstSales;
    SalesAdapter salesAdapter;
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<HashMap<String, String>>();

    public Sales() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sales, container, false);

        lstSales = (ListView) view.findViewById(R.id.lstSales);
        setSales();

        return view;
    }

    private void setSales(){

        String [] product   = { "product1", "product2" };
        String [] title     = { "DVD tutorial android pemula", "DVD tutorial android menengah" };
        String [] date      = { "Now, 9 2017 - 10:30pm", "Nov, 11 2017 - 08:15pm" };

        // status
        String [] shipment  = { "dikirim", "dikirim" };
        String [] drop      = { "diterima", "ditolak" };
        String [] finish    = { "selesai", "pengembalian" };

        for (int i = 0; i < title.length ; i++) {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put( "product",  product[i] );
            map.put( "title",    title[i] );
            map.put( "date",     date[i] );
            map.put( "shipment", shipment[i] );
            map.put( "drop",     drop[i] );
            map.put( "finish",   finish[i] );
            arrayList.add(map);
        }

        salesAdapter = new SalesAdapter(getActivity(), arrayList, R.layout.adapter_trans,
                new String[] { "product", "title", "date", "shipment", "drop", "finish" },
                new int[] { R.id.imgProduct, R.id.txtTitle, R.id.txtDesc, R.id.imgFinish, R.id.imgDrop, R.id.imgFinish});

        lstSales.setAdapter(salesAdapter);
        lstSales.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), ((TextView) view.findViewById(R.id.txtDesc)).getText().toString(),
                        Toast.LENGTH_LONG).show();
                startActivity(new Intent(getActivity(), Status.class));
            }
        });
    }

}
