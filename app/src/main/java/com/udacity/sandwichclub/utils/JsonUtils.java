package com.udacity.sandwichclub.utils;


import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;

import com.udacity.sandwichclub.R;
import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static final String LOG_TAG = JsonUtils.class.getSimpleName();

    private JsonUtils(){

    }



    public static Sandwich parseSandwichJson(String sandwichJson) {

        if (TextUtils.isEmpty(sandwichJson)) {
            return null;
        }

        ArrayList<String> alsoKnownAs = new ArrayList<>();
        ArrayList<String> ingredients = new ArrayList<>();






        try {

            JSONObject sandwichJsonResponse = new JSONObject(sandwichJson);


            JSONArray sandwichArray = sandwichJsonResponse.getJSONArray("sandwich_details");

            for (int i = 0; i < sandwichArray.length(); i++) {
                JSONObject currentSandwich = sandwichArray.getJSONObject(i);
                JSONObject name = currentSandwich.getJSONObject("name");

                String mainName = name.getString("mainName");
                String placeOfOrigin = name.getString("placeOfOrigin");
                String description = name.getString("description");
                String image = name.getString("image");

                alsoKnownAs.add(name.getString("alsoKnownAs"));

                ingredients.add(name.getString("ingredients"));

                return new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image
                , ingredients);



            }

        } catch (JSONException e) {
            Log.e(LOG_TAG, "Problem parsing the sandwich JSON results", e);
        }


        return null;
    }

}
