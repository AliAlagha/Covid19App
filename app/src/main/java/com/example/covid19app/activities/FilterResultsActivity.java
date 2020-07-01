package com.example.covid19app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.covid19app.R;
import com.example.covid19app.helpers.AppController;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FilterResultsActivity extends AppCompatActivity {

    private TextView countryNameTv, filterSatusTv, casesTv;
    private String country;
    private String status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_results);

        countryNameTv = findViewById(R.id.countryNameTv);
        filterSatusTv = findViewById(R.id.filterSatusTv);
        casesTv = findViewById(R.id.casesTv);

        if (getIntent() != null) {
            Intent intent = getIntent();
            if (intent.hasExtra("country")
                    && intent.hasExtra("status")) {

                country = intent.getStringExtra("country");
                status = intent.getStringExtra("status");

                getStatisticsForCountry();

            }
        }

    }

    private void getStatisticsForCountry() {

        String url = "https://api.covid19api.com/total/dayone/country/" + country + "/status/" + status;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {

                            JSONArray jsonArray = new JSONArray(response);
                            if (jsonArray.length() >= 1) {

                                JSONObject jsonObject = jsonArray.getJSONObject(jsonArray.length() - 1);
                                String country = jsonObject.getString("Country");
                                String status = jsonObject.getString("Status");
                                String cases = jsonObject.getString("Cases");

                                countryNameTv.setText(country);
                                filterSatusTv.setText(status);
                                casesTv.setText(cases);

                            }


                        } catch (JSONException e) {

                            Toast.makeText(FilterResultsActivity.this
                                    , "حدث خطأ ما", Toast.LENGTH_SHORT).show();

                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(FilterResultsActivity.this
                        , "حدث خطأ ما", Toast.LENGTH_SHORT).show();

            }
        });

        AppController.getInstance().addToRequestQueue(stringRequest);

    }
}
