package com.example.csc179_patient_tracker_app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class UpcomingAppointmentsActivity extends AppCompatActivity {
    private boolean editMode = false;
    private EditText doctorVisits;
    private EditText vaccinations;
    private Button saveEditButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_upcoming_appointments);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        doctorVisits = findViewById(R.id.doctor_visits_field);
        vaccinations = findViewById(R.id.vaccinations_field);
        saveEditButton = findViewById(R.id.save_edit_button);

        saveEditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editMode) {
                    readMode();
                } else {
                    editMode();
                }
            }
        });

        readMode();
    }

    private void readMode() {
        editMode = false;
        saveEditButton.setText("Edit");
        doctorVisits.setFocusable(false);
        vaccinations.setFocusable(false);
        doctorVisits.setFocusableInTouchMode(false);
        vaccinations.setFocusableInTouchMode(false);
        doctorVisits.setClickable(false);
        vaccinations.setClickable(false);
    }

    private void editMode() {
        editMode = true;
        saveEditButton.setText("Save");
        doctorVisits.setFocusable(true);
        vaccinations.setFocusable(true);
        doctorVisits.setFocusableInTouchMode(true);
        vaccinations.setFocusableInTouchMode(true);
        doctorVisits.setClickable(true);
        vaccinations.setClickable(true);
    }
}