package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.karaklicdm.myapplication.R;

import java.util.ArrayList;

import model.NavigationItem;

/**
 * Created by KaraklicDM on 29.10.2017.
 */

public class DrawerAdapter extends BaseAdapter {
    // A reference to the context (i.e. the activity containing the adapter)
    Context context;
    ArrayList<NavigationItem>items;

    public DrawerAdapter(Context context, ArrayList<NavigationItem> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        if (view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.drawer_item,null);
        }

        TextView tvTitle = (TextView)view.findViewById(R.id.title);
        TextView tvSubtitle = (TextView)view.findViewById(R.id.subtitle);
        ImageView ivIcon = (ImageView)view.findViewById(R.id.icon);

        tvTitle.setText(items.get(position).getTitle());
        tvSubtitle.setText(items.get(position).getSubtitle());
        ivIcon.setImageResource(items.get(position).getIcon());

        return view;
    }
}
