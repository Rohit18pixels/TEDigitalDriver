package com.livingtheapp.user.auth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.livingtheapp.user.R;
import com.livingtheapp.user.utils.AppUrl;
import com.livingtheapp.user.utils.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class RegistrationActivity extends AppCompatActivity {

    ArrayList<ModalCountries> arrayList = new ArrayList<>();
    private TextView txtCountryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_registration);



        initView();

    }

    void initView()
    {
        findViewById(R.id.txtCountryList).setOnClickListener(v -> listCountries());

    }

    void getExecuteMethods()
    {

        String URL_ = "http://living.indo3dworld.com/api/getCountriesDataService";
        Utils.customProgress(this,"Please Wait ...");
        arrayList.clear();



        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST,
                URL_,
                null, response -> {

            System.out.println("Responce..."+response);

            try {
                if(response.getBoolean("status"))
                {
                    System.out.println("Responce..."+response);
                    JSONArray jsonArray = response.getJSONArray("data");

                    System.out.println("Responce..."+jsonArray.length());

                    for (int i=0; i<jsonArray.length();i++)
                    {
                        Utils.customProgressStop();
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
                Utils.customProgressStop();
                e.printStackTrace();
            }


        }, error -> {
            Utils.customProgressStop();

                });

        RequestQueue queue = Volley.newRequestQueue(RegistrationActivity.this);
        request.setRetryPolicy(new DefaultRetryPolicy(20*2000, 2,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(request);
    }


    void listCountries()
    {

        if(Utils.isNetworkAvailable(this))
            getExecuteMethods();


        System.out.println("srra"+arrayList.size());

        AlertDialog.Builder builder = new AlertDialog.Builder(RegistrationActivity.this);
        ViewGroup viewGroup = findViewById(android.R.id.content);
        View dialogView = LayoutInflater.from(this).inflate(R.layout.custom_view_countrieslist, viewGroup, false);

        RecyclerView rvList = dialogView.findViewById(R.id.rvList);
        rvList.setLayoutManager(new LinearLayoutManager(RegistrationActivity.this,RecyclerView.VERTICAL,false));
        CountryListAdapter adapter = new CountryListAdapter(arrayList);
        rvList.setAdapter(adapter);

        builder.setView(dialogView);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    class CountryListAdapter extends RecyclerView.Adapter<CountryListAdapter.ViewHolder>
    {
        ArrayList<ModalCountries> arrayList;
        public CountryListAdapter(ArrayList<ModalCountries> arrayList) {

            this.arrayList = arrayList;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_country_list, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

            ModalCountries modalCountries =  arrayList.get(position);
            holder.txtCountry.setText("+"+modalCountries.getCallingCode()+" "+modalCountries.getCountryName());
        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView txtCountry;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                txtCountry = itemView.findViewById(R.id.txtCountry);
            }
        }
    }
}

