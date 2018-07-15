package app.tokoonline.home_fragment;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import app.tokoonline.Detail;
import app.tokoonline.Login;
import app.tokoonline.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Product extends Fragment {


    GridView grdProduct;
    SimpleAdapter simpleAdapter;
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<HashMap<String, String>>();

    public Product() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_product, container, false);

        grdProduct = (GridView) view.findViewById(R.id.grdProduct);
        setProduct();

        return view;
    }

    private void setProduct(){

        for (int i = 1; i <= 10; i++) {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("price",  "Rp " + String.valueOf(i) + "0.000");
            map.put("seller",  "Lazday Indonesia");
            arrayList.add(map);
        }
        simpleAdapter = new SimpleAdapter(getActivity(), arrayList, R.layout.adapter_product,
                new String[] { "price", "seller" },
                new int[] { R.id.txtPrice, R.id.txtSeller });

        grdProduct.setAdapter(simpleAdapter);
        grdProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), ((TextView) view.findViewById(R.id.txtPrice)).getText().toString(),
                        Toast.LENGTH_LONG).show();
                startActivity(new Intent(getActivity(), Detail.class));
            }
        });
    }

}
