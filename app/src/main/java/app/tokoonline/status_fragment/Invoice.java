package app.tokoonline.status_fragment;


import android.graphics.Paint;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import app.tokoonline.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Invoice extends Fragment {

    TextView txtHistory;
    LinearLayout linearHist;
    ListView lstHistory;
    SimpleAdapter simpleAdapter;
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<HashMap<String, String>>();


    public Invoice() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_invoice, container, false);

        txtHistory = (TextView) view.findViewById(R.id.txtHistory);
        linearHist = (LinearLayout) view.findViewById(R.id.linearHist);
        lstHistory = (ListView) view.findViewById(R.id.lstHistory);
        setHistory();

        txtHistory.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        txtHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (linearHist.getVisibility() == View.GONE){
                    linearHist.setVisibility(View.VISIBLE);
                    txtHistory.setCompoundDrawablesWithIntrinsicBounds(0, 0, android.R.drawable.arrow_up_float, 0 );
                } else {
                    linearHist.setVisibility(View.GONE);
                    txtHistory.setCompoundDrawablesWithIntrinsicBounds(0, 0, android.R.drawable.arrow_down_float, 0 );
                }
            }
        });

        return view;
    }

    private void setHistory(){

        for (int i = 1; i <= 24; i++) {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("date",  "Agust, " + String.valueOf(i) + " 2017");
            arrayList.add(map);
        }
        simpleAdapter = new SimpleAdapter(getActivity(), arrayList, R.layout.adapter_history,
                new String[] { "date" },
                new int[] { R.id.txtDate});

        lstHistory.setAdapter(simpleAdapter);
//        Utility.setListViewHeightBasedOnChildren(lstHistory);

    }

}
