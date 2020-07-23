package com.example.pruebapoomovil_munozxavier.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Paises {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("alpha2Code")
    @Expose
    private String alpha2Code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public void setAlpha2Code(String alpha2Code) {
        this.alpha2Code = alpha2Code;
    }

    public Paises(JSONObject a) throws JSONException {
        name =  a.getString("name").toString();
        alpha2Code = "http://www.geognos.com/api/en/countries/flag/"+ a.getString("alpha2Code").toString()+".png" ;
    }

    public static ArrayList<Paises> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Paises> paises = new ArrayList<>();
        for (int i = 0; i < datos.length() && i<20; i++) {
            paises.add(new Paises(datos.getJSONObject(i)));
        }
        return paises;
    }
}
