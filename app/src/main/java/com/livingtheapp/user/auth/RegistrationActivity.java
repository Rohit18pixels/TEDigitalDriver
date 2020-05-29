package com.livingtheapp.user.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.livingtheapp.user.R;
import com.livingtheapp.user.utils.AppUrl;

import org.json.JSONObject;

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_registration);

        getExecuteMethods();
    }

    void getExecuteMethods()
    {

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, AppUrl.getCountriesDataService,
                null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue queue = Volley.newRequestQueue(RegistrationActivity.this);
        request.setRetryPolicy(new DefaultRetryPolicy(20*2000, 2, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(request);
    }
}
