package fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.karaklicdm.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import provider.GlumacProvider;

/**
 * Created by androiddevelopment on 27.10.17..
 */

public class MasterFragment extends Fragment{

    OnItemSelectedListener listener;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        List<String> listOfActorsNames = GlumacProvider.getGlumacImena();
        List<String> listOfActorsSurnames = GlumacProvider.getGlumacPrezimena();
        List<String> listOfNamesSurnames = new ArrayList<>();
        for (int i=0;i<listOfActorsNames.size();i++) {
            listOfNamesSurnames.add(listOfActorsNames.get(i) + " " + listOfActorsSurnames.get(i));
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), R.layout.list_item,listOfNamesSurnames);
        ListView lv = (ListView) getView().findViewById(R.id.listOfActores);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listener.onItemSelected(position);
            }
        });
      }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if (container == null)
            return null;

        View view = inflater.inflate(R.layout.master_fragment,container,false);

        return view;
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            listener = (OnItemSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnItemSelectedListener");
        }

    }

    public interface OnItemSelectedListener{
        public void onItemSelected(int position);
    }
}
