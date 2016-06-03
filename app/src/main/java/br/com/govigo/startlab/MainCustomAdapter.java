package br.com.govigo.startlab;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MainCustomAdapter extends BaseAdapter {
    private Context mContext;
    private List<String> mList;
    private final String TAG = "MainCustomAdapter";

    class Holder {
        TextView NAME;
        TextView ID;
        public Holder(View mView) {
            this.NAME = (TextView) mView.findViewById(R.id.textView);
            this.ID = (TextView) mView.findViewById(R.id.textNumber);
        }
    }

    public MainCustomAdapter (Context ctxt ,List<String> stringList) {
        this.mContext = ctxt;
        this.mList = stringList;
        Log.d(TAG, "onCreate." );
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public String getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Holder holder;
        View row = convertView;

        if (row == null) {    // 1st time
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.main_list_detail, parent, false);
            holder = new Holder(row);
            row.setTag(holder);
        } else {
            holder = (Holder) row.getTag();   // Recycling
            Log.d(TAG, "getView recycling." );
        }

        Log.d(TAG, "getView: "+String.format( "%2d - %s", position,mList.get(position) ));

        //Set text for TextView
        holder.NAME.setText( mList.get(position));
        holder.ID.setText(String.format( "%02d", position ));

        return row;
    }
}


