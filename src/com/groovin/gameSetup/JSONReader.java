package com.groovin.gameSetup;

import com.google.gson.Gson;
import com.groovin.items.Items;

import java.io.InputStreamReader;
import java.io.Reader;

public class JSONReader {


    public Items[] getItems() {
        Items[] items = {};
        Gson gson = new Gson();
        Reader reader = new InputStreamReader(Items.class.getResourceAsStream("/items.json"));
        items = gson.fromJson(reader, Items[].class);
        return items;
    }

}
