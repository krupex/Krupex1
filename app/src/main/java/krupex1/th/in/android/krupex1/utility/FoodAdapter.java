package krupex1.th.in.android.krupex1.utility;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import krupex1.th.in.android.krupex1.R;

public class FoodAdapter extends BaseAdapter{




    private Context context;

    private String[] imageStrings, fooStrings, priceStings, detailStrings;

    public FoodAdapter(Context context, String[] imageStrings, String[] fooStrings, String[] priceStings, String[] detailStrings) {
        this.context = context;
        this.imageStrings = imageStrings;
        this.fooStrings = fooStrings;
        this.priceStings = priceStings;
        this.detailStrings = detailStrings;

    }

    @Override
    public int getCount() {
        return fooStrings.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(R.layout.listview_food, parent, false);


        TextView foodTextView = view.findViewById(R.id.tectFood);
        TextView priceTextView = view.findViewById(R.id.tetPrice);
        TextView detailTextView = view.findViewById(R.id.textDetail);
        ImageView imageView = view.findViewById(R.id.imvFood);

        foodTextView.setText(fooStrings[position]);
        priceTextView.setText(priceStings[position]);
        detailTextView.setText(detailStrings[position]);

        Picasso.get().load(imageStrings[position]).into(imageView);



        return null;
    }
}
