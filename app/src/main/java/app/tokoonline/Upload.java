package app.tokoonline;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Upload extends AppCompatActivity {

    private EditText Name, Price, Stock, Categories, Description;

    DatabaseReference dbolshop;


    Button btnPay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);

        Name = (EditText)findViewById( R.id.edt_name );
        Price = (EditText)findViewById( R.id.edt_price);
        Stock = (EditText)findViewById( R.id.edt_stock );
        Categories = (EditText)findViewById( R.id.edt_categories);
        Description = (EditText)findViewById( R.id.edt_description );
        btnPay = (Button)findViewById( R.id.btn_sell );

        dbolshop = FirebaseDatabase.getInstance().getReference("barang");
        btnPay.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertbarang();
            }
        } );

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Jual Barang");
    }

    private void insertbarang(){
        String nama = Name.getText().toString().trim();
        String price= Price.getText().toString().trim();
        String stock = Stock.getText().toString().trim();
        String categories = Categories.getText().toString().trim();
        String description = Description.getText().toString().trim();

        //checking if the value is provided
        if (!TextUtils.isEmpty(nama)) {

            //getting a unique id using push().getKey() method
            //it will create a unique id and we will use it as the Primary Key for our Artist
            String id = dbolshop.push().getKey();

            //creating an Artist Object
            hellodude item = new hellodude (nama, price,stock,categories,description);

            //Saving the Artist
            dbolshop.child(id).setValue(item);

            //setting edittext to blank again
            Name.setText("");
            Price.setText("");
            Stock.setText("");
            Categories.setText("");
            Description.setText("");

            //displaying a success toast
            Toast.makeText(this, "Success To Upload the Product", Toast.LENGTH_LONG).show();
        } else {
            //if the value is not given displaying a toast
            Toast.makeText(this, "Failed to Upload Product", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
