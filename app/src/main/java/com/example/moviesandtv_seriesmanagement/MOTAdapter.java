package com.example.moviesandtv_seriesmanagement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import static java.lang.String.valueOf;


public class MOTAdapter extends ArrayAdapter<MoviesAndSeries> {

    private Context ctx;
    private int songResourceId;
    private List<MoviesAndSeries> data;

    public MOTAdapter(@NonNull Context context, int resource, @NonNull List<MoviesAndSeries> objects) {
        super(context, resource, objects);
        this.ctx = (MoviesAndSeriesList) context;
        this.songResourceId = resource;
        this.data = objects;
    }

    @NonNull
    @Override
    public int getCount() {
        return data.size();
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater li = (LayoutInflater)
                this.ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View v = li.inflate( this.songResourceId, null);


        MoviesAndSeries m = this.data.get(position);
        TextView tv1 = v.findViewById(R.id.textViewName);
        tv1.setText(m.getName());
        TextView tv2 = v.findViewById(R.id.textViewMOT);
        tv2.setText(m.getMovieOrTV());
        TextView tv3 = v.findViewById(R.id.textViewSeason2);
        tv3.setText(m.getSeason());
       // TextView tv4 = v.findViewById(R.id.textViewRatingBar);
       // tv4.setText(valueOf(m.getRatingBar1()));
        return v;
    }
}
