package fragments;

import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.karaklicdm.myapplication.R;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Film;
import provider.BiografijaProvider;
import provider.GlumacProvider;
/**
 * Created by androiddevelopment on 27.10.17..
 */

public class DetailFragment extends Fragment {

    private int position = 0;
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (savedInstanceState != null){
            position = savedInstanceState.getInt("position",0);
        }

        ImageView imageView = (ImageView)getActivity().findViewById(R.id.iv_image);
        InputStream is = null;
        try {
            is = getActivity().getAssets().open(GlumacProvider.getGlumacById(position).getSlika());
            Drawable drawable = Drawable.createFromStream(is,null);
            imageView.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }

        TextView tvName = (TextView)getView().findViewById(R.id.tv_actor_name);
        tvName.setText(GlumacProvider.getGlumacById(position).getIme());

        TextView tvSurname = (TextView)getView().findViewById(R.id.tv_actor_surname);
        tvSurname.setText(GlumacProvider.getGlumacById(position).getPrezime());

        TextView tvBirthdate = (TextView)getView().findViewById(R.id.tv_actor_birthday);
        Date date = GlumacProvider.getGlumacById(position).getDatumRodjenja();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.mm.yyyy.");
        tvBirthdate.setText(sdf.format(date));

        TextView tvDeathdate = (TextView)getView().findViewById(R.id.tv_actor_deathday);
        date = GlumacProvider.getGlumacById(position).getDatumRodjenja();
        tvDeathdate.setText(sdf.format(date));


        List<String> biography = BiografijaProvider.getBiographyByActorId(position);
        ListView lvBiografija = (ListView)getView().findViewById(R.id.lv_actor_biography);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item,biography);
        lvBiografija.setAdapter(adapter);

        RatingBar rbMark = (RatingBar)getView().findViewById(R.id.rb_mark);
        rbMark.setRating( GlumacProvider.getGlumacById(position).getOcena());


        //adapter ako su stavke date nekimobjektom, automatski poziva toString metodu
        ListView lvFilms = (ListView)getView().findViewById(R.id.lv_actor_list_films);
        List<Film> films = GlumacProvider.getGlumacById(position).getFilmovi();
        List<String> filmString = new ArrayList<>();
        for (Film film:films){
            filmString.add(film.toString());
        }
        ArrayAdapter<String> adapter1 = new ArrayAdapter(getActivity(),R.layout.list_item,filmString);
        lvFilms.setAdapter(adapter1);



    }

    public void onSaveInstanceState(Bundle savedInstanceState) {

        super.onSaveInstanceState(savedInstanceState);

        // Shows a toast message (a pop-up message)
        //Toast.makeText(getActivity(), "DetailFragment.onSaveInstanceState()", Toast.LENGTH_SHORT).show();

        savedInstanceState.putInt("position", position);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.detail_fragment,container,false);
        return view;
    }

    public void setContent(final int position){
        this.position=position;
    }
    public void updateContent(final int position){
        this.position = position;
        ImageView imageView = (ImageView)getActivity().findViewById(R.id.iv_image);
        InputStream is = null;
        try {
            is = getActivity().getAssets().open(GlumacProvider.getGlumacById(position).getSlika());
            Drawable drawable = Drawable.createFromStream(is,null);
            imageView.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }

        TextView tvName = (TextView)getView().findViewById(R.id.tv_actor_name);
        tvName.setText(GlumacProvider.getGlumacById(position).getIme());

        TextView tvSurname = (TextView)getView().findViewById(R.id.tv_actor_surname);
        tvSurname.setText(GlumacProvider.getGlumacById(position).getPrezime());

        TextView tvBirthdate = (TextView)getView().findViewById(R.id.tv_actor_birthday);
        Date date = GlumacProvider.getGlumacById(position).getDatumRodjenja();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.mm.yyyy.");
        tvBirthdate.setText(sdf.format(date));

        TextView tvDeathdate = (TextView)getView().findViewById(R.id.tv_actor_deathday);
        date = GlumacProvider.getGlumacById(position).getDatumRodjenja();
        tvDeathdate.setText(sdf.format(date));

        TextView tvBiografija = (TextView)getView().findViewById(R.id.biografija);
        tvBiografija.setText("Biografija");


        List<String> biography = new ArrayList<>();

        biography= BiografijaProvider.getBiographyByActorId(position);
        ListView lvBiografija = (ListView)getView().findViewById(R.id.lv_actor_biography);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item,biography);
        lvBiografija.setAdapter(adapter);

        RatingBar rbMark = (RatingBar)getView().findViewById(R.id.rb_mark);
        rbMark.setRating( GlumacProvider.getGlumacById(position).getOcena());


        //adapter ako su stavke date nekim objektom, automatski poziva toString metodu
        ListView lvFilms = (ListView)getView().findViewById(R.id.lv_actor_list_films);
        List<Film> films = GlumacProvider.getGlumacById(position).getFilmovi();
        List<String> filmString = new ArrayList<>();
        ArrayAdapter<String> adapter1 = new ArrayAdapter(getActivity(),R.layout.list_item,films);
        lvFilms.setAdapter(adapter1);
    }
}
