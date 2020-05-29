package com.livingtheapp.user.auth;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.livingtheapp.user.R;
import com.livingtheapp.user.utils.AppUrl;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class RegistrationActivity extends AppCompatActivity {

    ArrayList<ModalCountries> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_registration);

        arrayList = new ArrayList<>();
        getExecuteMethods();
    }

    void getExecuteMethods()
    {

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST,
                AppUrl.getCountriesDataService,
                null, response -> {

            try {
                if(response.getBoolean("status"))
                {
                    JSONArray jsonArray = response.getJSONArray("data");
                    for (int i=0; i<jsonArray.length();i++)
                    {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        ModalCountries modal = new ModalCountries();
                        modal.setId(jsonObject.getString("id"));
                        modal.setCountryName(jsonObject.getString("countryName"));
                        modal.setCountryStatus(jsonObject.getString("countryStatus"));
//                        modal.countryFlag(jsonObject.getString("countryStatus"));
                        modal.setCountryCode(jsonObject.getString("countryCode"));
                        modal.setCallingCode(jsonObject.getString("callingCode"));

                        arrayList.add(modal);

                    }


                }
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }, error -> {

                });

        RequestQueue queue = Volley.newRequestQueue(RegistrationActivity.this);
        request.setRetryPolicy(new DefaultRetryPolicy(20*2000, 2, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(request);
    }


    void listCountries()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(RegistrationActivity.this);
        ViewGroup viewGroup = findViewById(android.R.id.content);
        View dialogView = LayoutInflater.from(v.getContext()).inflate(R.layout.custom, viewGroup, false);
        builder.setView(dialogView);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
