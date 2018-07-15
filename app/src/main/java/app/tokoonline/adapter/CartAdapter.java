package app.tokoonline.adapter;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;

import app.tokoonline.R;
import app.tokoonline.model.CartModel;

/**
 * Created by Lazday Indonesia
 * On 11/13/2017.
 */

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder>{

    private ArrayList<CartModel> cart;
    Context context;
    public CartAdapter(Context context, ArrayList<CartModel> cart) {
        this.cart       = cart;
        this.context    = context;
    }

    @Override
    public CartAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_cart, null);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
//        holder.btnPay.setText(String.valueOf(cart.get(position).getProduct_id()));

//        Log.d("GET_TITLE", cart.get(position).getTitle());
//        Log.d("GET_ID", String.valueOf(cart.get(position).getProduct_id()));


        // region spinner AMOUNT
        final ArrayList<String> count = new ArrayList<>();
        for (int i=1; i <= 500; i++){
            count.add( String.valueOf(i) );
        }
        ArrayAdapter<String> arrayAdapter;
        // Application of the Array to the Spinner
        arrayAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, count);
        holder.spnTotal.setAdapter(arrayAdapter);
        holder.spnTotal.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        }); // endregion

        holder.btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkout();
            }
        });


        holder.btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cart.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, cart.size());
                holder.itemView.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cart.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView btnDel;
        Spinner spnTotal;
        Button btnPay;

        public ViewHolder(View itemView) {
            super(itemView);
            spnTotal    = (Spinner) itemView.findViewById(R.id.spnTotal);
            btnPay      = (Button) itemView.findViewById(R.id.btnPay);
            btnDel      = (ImageView) itemView.findViewById(R.id.btnDel);
        }
    }

    private void checkout() {
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_checkout);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(true);
        dialog.show();

        Button btnPay   = (Button) dialog.findViewById(R.id.btnPay);
        Spinner spinner = (Spinner) dialog.findViewById(R.id.spinner);
        // Array of choices
        String colors[] = {"JNE","J&T Express","POS Indonesia"};
        // Application of the Array to the Spinner
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, colors);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        spinner.setAdapter(spinnerArrayAdapter);
        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }
}
