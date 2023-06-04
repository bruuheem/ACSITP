package com.example.acsitp;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class MaladieAdapter extends  ArrayAdapter<Maladie> {
    private static final String TAG = MaladieAdapter.class.getSimpleName();
    List<Maladie> maladieList;

    public MaladieAdapter(Context context, int resource, List<Maladie> objects) {
        super(context, resource, objects);

        maladieList = objects;
    }
    @Override
    public int getCount() {
        return maladieList.size();
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        Maladie currentmaladie = maladieList.get(position);

        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.maladie_card, parent, false);
        }

        TextView nameTextView = (TextView) listItemView.findViewById(R.id.titleTextView);
        nameTextView.setText(currentmaladie.getName());

        TextView ageTextView = (TextView) listItemView.findViewById(R.id.descriptionTextView);
        ageTextView.setText(currentmaladie.getDescription());


        return listItemView;}

}
