package com.example.covid19app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.covid19app.R;
import com.example.covid19app.helpers.AppController;

import org.json.JSONException;
import org.json.JSONObject;

public class VirusStatisticsActivity extends AppCompatActivity {

    private static String apiLink = "https://api.covid19api.com/summary";
    private TextView newConfirmedTv;
    private TextView totalConfirmedTv;
    private TextView newDeathsTv;
    private TextView totalDeathsTv;
    private TextView newRecoveredTv;
    private TextView totalRecoveredTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_virus_statistics);

        newConfirmedTv = findViewById(R.id.newConfirmedTv);
        totalConfirmedTv = findViewById(R.id.totalConfirmedTv);
        newDeathsTv = findViewById(R.id.newDeathsTv);
        totalDeathsTv = findViewById(R.id.totalDeathsTv);
        newRecoveredTv = findViewById(R.id.newRecoveredTv);
        totalRecoveredTv = findViewById(R.id.totalRecoveredTv);
        Button filterStatisticsBtn = findViewById(R.id.filterStatisticsBtn);

        filterStatisticsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),FilterStatisticsActivity.class);
                startActivity(intent);
            }
        });

        getStatistics();

    }

    private void getStatistics() {

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, apiLink
                , null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {

                    JSONObject globalStatisticsJsonObject = response.getJSONObject("Global");
                    String newConfirmed = globalStatisticsJsonObject.getString("NewConfirmed");
                    newConfirmedTv.setText(newConfirmed + " حالة");
                    String totalConfirmed = globalStatisticsJsonObject.getString("TotalConfirmed");
                    totalConfirmedTv.setText(totalConfirmed+ " حالة");
                    String newDeaths = globalStatisticsJsonObject.getString("NewDeaths");
                    newDeathsTv.setText(newDeaths+ " حالة");
                    String totalDeaths = globalStatisticsJsonObject.getString("TotalDeaths");
                    totalDeathsTv.setText(totalDeaths+ " حالة");
                    String newRecovered = globalStatisticsJsonObject.getString("NewRecovered");
                    newRecoveredTv.setText(newRecovered+ " حالة");
                    String totalRecovered = globalStatisticsJsonObject.getString("TotalRecovered");
                    totalRecoveredTv.setText(totalRecovered+ " حالة");

                } catch (JSONException e) {
                    Toast.makeText(VirusStatisticsActivity.this, "حدث  خطأ ما"
                            , Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(VirusStatisticsActivity.this, error.getMessage()
                        , Toast.LENGTH_SHORT).show();

            }
        });

        AppController.getInstance().addToRequestQueue(jsonObjectRequest);

    }

}
