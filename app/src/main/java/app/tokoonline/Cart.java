package app.tokoonline;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

import app.tokoonline.adapter.CartAdapter;
import app.tokoonline.model.CartModel;

public class Cart extends AppCompatActivity {

    SwipeRefreshLayout swipe;
    RecyclerView recyclerView;
    ArrayList<CartModel> carts;
    CartAdapter cartAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        swipe           = (SwipeRefreshLayout) findViewById(R.id.swipe);
        recyclerView    = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        carts           = new ArrayList<>();
        setCart();

        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                carts.clear(); recyclerView.setAdapter(null);
                setCart();
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Keranjang");
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    private void setCart(){
        for (int i=0; i < 3; i++) {
            CartModel model = new CartModel();
            carts.add(model);
        }

        cartAdapter = new CartAdapter(Cart.this, carts);
        cartAdapter.notifyDataSetChanged();
        Log.d("_COUNT", String.valueOf(cartAdapter.getItemCount()) );
        recyclerView.setAdapter(cartAdapter);

        swipe.setRefreshing(false);
    }
}
