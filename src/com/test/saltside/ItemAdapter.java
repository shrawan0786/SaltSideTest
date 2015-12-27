package com.test.saltside;

import java.util.List;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ItemAdapter extends BaseAdapter implements OnClickListener {
    private Context context;

    private List<ItemData> itemList;

    public ItemAdapter(Context context, List<ItemData> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    public int getCount() {
        return itemList.size();
    }

    public Object getItem(int position) {
        return itemList.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("InflateParams") 
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ItemData entry = itemList.get(position);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_layout, null);
        }
        TextView title = (TextView) convertView.findViewById(R.id.title);
        title.setText(entry.getTitle());

        TextView description = (TextView) convertView.findViewById(R.id.description);
        description.setText(entry.getDescription());

        // Set the onClick Listener on this view
        convertView.setOnClickListener(this);
        convertView.setTag(entry);

        return convertView;
    }

    @Override
    public void onClick(View view) {
        ItemData entry = (ItemData) view.getTag();
        Intent intent = new Intent(context, LandingScreen.class);
        intent.putExtra("item_data", entry);
        context.startActivity(intent);
    }

}