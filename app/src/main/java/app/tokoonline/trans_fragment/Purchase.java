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

/**
 * A simple {@link Fragment} subclass.
 */
public class Purchase extends Fragment {

    ListView lstPurchase;
    SimpleAdapter simpleAdapter;
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<HashMap<String, String>>();

    public Purchase() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_purchase, container, false);

        lstPurchase = (ListView) view.findViewById(R.id.lstPurchase);
        setPurchase();

        return view;
    }

    private void setPurchase(){

        for (int i = 1; i <= 4; i++) {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("price",  "Rp 118.000");
            arrayList.add(map);
        }
        simpleAdapter = new SimpleAdapter(getActivity(), arrayList, R.layout.adapter_trans,
                new String[] { "price" },
                new int[] { R.id.txtDesc});

        lstPurchase.setAdapter(simpleAdapter);
        lstPurchase.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), ((TextView) view.findViewById(R.id.txtDesc)).getText().toString(),
                        Toast.LENGTH_LONG).show();
                startActivity(new Intent(getActivity(), Status.class));
            }
        });
    }

}
