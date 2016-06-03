package br.com.govigo.startlab;

import android.app.Fragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** A placeholder fragment containing a simple view. */
public class MainPlaceHolderFragment extends Fragment {
    private final String TAG = "MainPlaceHolderFragment";

    public MainPlaceHolderFragment() {
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        Log.d(TAG, "onCreateView");

        Resources res = getResources();
        String[] tempArray = res.getStringArray(R.array.lorem_array);

        List<String> MyItems = new ArrayList<String>(Arrays.asList(tempArray));
        View mView = inflater.inflate(R.layout.main_list, container, false);

        final ListView listView = (ListView) mView.findViewById(R.id.main_list);

        MainCustomAdapter mAdapter = new  MainCustomAdapter(getActivity(), MyItems);
        listView.setAdapter(mAdapter);

        listView.setOnItemClickListener(new detailListener());

        return mView;
    }

    public class detailListener implements AdapterView.OnItemClickListener
    {
        private final String TAG = "detailListener";

        public void onItemClick(AdapterView<?> parent, View view, int position, long id)
        {
            Log.d(TAG, "onItemClick");

            /* String test = (String) listView.getAdapter().getItem(arg2); */
            Log.i(TAG,  String.format("Selected Item in list: %02d",position));
            Toast.makeText(getActivity(), String.format("Selected Item in list: %02d",position) ,Toast.LENGTH_LONG);
        }
    }

}
