package app.tokoonline;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class Store extends AppCompatActivity {

    TextView txtStore;
    GridView grdProduct;
    SimpleAdapter simpleAdapter;
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<HashMap<String, String>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtStore = (TextView) findViewById(R.id.txtStore);
        txtStore.setText("Lazday Indonesia");

        grdProduct = (GridView) findViewById(R.id.grdProduct);
        setProduct();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Lazday Indonesia");
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    private void setProduct(){

        for (int i = 1; i <= 6; i++) {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("price",  "Rp " + String.valueOf(i) + "0.000");
            map.put("seller",  "Lazday Indonesia");
            arrayList.add(map);
        }
        simpleAdapter = new SimpleAdapter(Store.this, arrayList, R.layout.adapter_product,
                new String[] { "price", "seller" },
                new int[] { R.id.txtPrice, R.id.txtSeller });

        grdProduct.setAdapter(simpleAdapter);
        grdProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), ((TextView) view.findViewById(R.id.txtPrice)).getText().toString(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
