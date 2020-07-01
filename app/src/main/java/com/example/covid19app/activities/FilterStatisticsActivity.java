package com.example.covid19app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.example.covid19app.R;

public class FilterStatisticsActivity extends AppCompatActivity {

    private String status = "confirmed";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_statistics);

        final RadioGroup statusRadioGroup = findViewById(R.id.statusRadioGroup);
        Button showResultBtn = findViewById(R.id.showResultBtn);
        final EditText countryNameEd = findViewById(R.id.countryNameEd);

        statusRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId == R.id.confirmedRadioButton) {
                    status = "confirmed";
                } else if (checkedId == R.id.recoveredRadioBtn) {
                    status = "recovered";
                } else if (checkedId == R.id.deathsRadioBn) {
                    status = "deaths";
                }

            }
        });

        showResultBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String country = countryNameEd.getText().toString().trim();

                Intent intent = new Intent(getApplicationContext(), FilterResultsActivity.class);
                intent.putExtra("country", country);
                intent.putExtra("status", status);
                startActivity(intent);

            }
        });

    }


}
