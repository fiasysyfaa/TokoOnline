package app.tokoonline;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


public class trifia extends ArrayAdapter<hellodude>
{
    private Activity context;
    List<hellodude> items;


    public trifia(Activity context, List<hellodude> items) {
        super( context, R.layout.adapter_product, items );
        this.context = context;
        this.items = items;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate( R.layout.activity_detail, null, true );

        TextView textViewName = (TextView) listViewItem.findViewById( R.id.name );
        TextView textViewCat = (TextView) listViewItem.findViewById( R.id.price);

        hellodude item = items.get( position );
        textViewName.setText( item.getNamabarang() );
        textViewCat.setText( item.getHargabarang() );


        return listViewItem;
    }

}