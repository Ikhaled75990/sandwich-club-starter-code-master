package com.udacity.sandwichclub.utils;


import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    private static final String NAME_KEY = "name";
    private static final String MAIN_NAME_KEY = "mainName";
    private static final String ALSO_KNOWN_AS_KEY = "alsoKnownAs";
    private static final String PLACE_OF_ORIGIN_KEY = "placeOfOrigin";
    private static final String DESCRIPTION_KEY = "description";
    private static final String IMAGE_KEY = "image";
    private static final String INGREDIENTS_KEY = "ingredients";


    public static Sandwich parseSandwichJson(String sandwichJson) throws JSONException {

        List<String> alsoKnownAsList = new ArrayList<>();

        List<String> ingredientsList = new ArrayList<>();



        JSONObject sandwichJsonResponse = new JSONObject(sandwichJson);
        JSONObject sandwichJsonObject = sandwichJsonResponse.getJSONObject(NAME_KEY);
        Sandwich sandwich = new Sandwich();


        sandwich.setMainName(sandwichJsonObject.getString(MAIN_NAME_KEY));


        JSONArray alsoKnownAsJsonArray = sandwichJsonObject.getJSONArray(ALSO_KNOWN_AS_KEY);
        for (int i = 0; i < alsoKnownAsJsonArray.length(); i++) {
            alsoKnownAsList.add(alsoKnownAsJsonArray.getString(i));
        }
        sandwich.setAlsoKnownAs(alsoKnownAsList);
        sandwich.setPlaceOfOrigin(sandwichJsonResponse.getString(PLACE_OF_ORIGIN_KEY));
        sandwich.setDescription(sandwichJsonResponse.getString(DESCRIPTION_KEY));
        sandwich.setImage(sandwichJsonResponse.getString(IMAGE_KEY));

        JSONArray ingredientsJsonArray = sandwichJsonObject.getJSONArray(INGREDIENTS_KEY);
        for (int i = 0; i < ingredientsJsonArray.length(); i++) {
            ingredientsList.add(ingredientsJsonArray.getString(i));
        }
        sandwich.setIngredients(ingredientsList);


        return sandwich;

    }

}
