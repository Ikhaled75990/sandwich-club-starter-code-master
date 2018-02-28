package com.udacity.sandwichclub;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.udacity.sandwichclub.model.Sandwich;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ikki on 27/02/2018.
 */

public class SandwichAdapter extends ArrayAdapter<Sandwich> {

    public SandwichAdapter(Context context, ArrayList<Sandwich> sandwiches){
        super(context, 0, sandwiches);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.activity_detail, parent, false
            );
        }

        if (position < getCount()) {
            Sandwich currentSandwich = getItem(position);



            TextView originTv = (TextView) listItemView.findViewById(R.id.origin_tv);
            originTv.setText(currentSandwich.getPlaceOfOrigin());

            TextView descriptionTv = (TextView) listItemView.findViewById(R.id.description_tv);
            descriptionTv.setText(currentSandwich.getDescription());

            TextView alsoKnownTv = (TextView) listItemView.findViewById(R.id.also_known_tv);
            alsoKnownTv.setText((CharSequence) currentSandwich.getAlsoKnownAs());

            TextView ingredientsTv = (TextView) listItemView.findViewById(R.id.ingredients_tv);
            ingredientsTv.setText((CharSequence) currentSandwich.getIngredients());
    }
    return listItemView;
    }

}
