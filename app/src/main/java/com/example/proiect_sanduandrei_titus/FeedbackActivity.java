package com.example.proiect_sanduandrei_titus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class FeedbackActivity extends AppCompatActivity {
    private Intent intent;
    private Spinner spnChooseAttraction;
    private Button btnSubmit;
    private TextInputEditText tietName;
    private TextInputEditText tietEmail;
    private RatingBar rbUserRating;
    public static final String FEEDBACK_KEY="feedback_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        initComponents();
        intent=getIntent();
    }

    private void initComponents(){
        spnChooseAttraction=findViewById(R.id.spn_feedback_choose_attraction);
        addSpinnerAdapter();
        btnSubmit=findViewById(R.id.btn_feedback_submit);
        btnSubmit.setOnClickListener(getSubmitFeedbackClickListener());
        tietName=findViewById(R.id.tiet_feedback_add_name);
        tietEmail=findViewById(R.id.tiet_feedback_add_email);
        rbUserRating=findViewById(R.id.rb_user_rating);
    }

    private void addSpinnerAdapter(){
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(getApplicationContext(),
                R.array.attractions_list, android.R.layout.simple_spinner_dropdown_item);
        spnChooseAttraction.setAdapter(adapter);
    }

    private View.OnClickListener getSubmitFeedbackClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isValid()){
                    Feedback feedback=buildFeedback();
                    intent.putExtra(FEEDBACK_KEY,feedback);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        };
    }

    private Feedback buildFeedback() {
        String name=tietName.getText().toString();
        String email=tietEmail.getText().toString();
        String attraction=(String) spnChooseAttraction.getSelectedItem();
        float ratingValue=rbUserRating.getRating();
        return new Feedback(name,email,attraction,ratingValue);
    }

    private boolean isValid() {
        if(tietName.getText()==null || tietName.getText().toString().trim().length()<3){
            Toast.makeText(getApplicationContext(), R.string.invalid_name, Toast.LENGTH_LONG).show();
            return false;
        }
        if(tietEmail.getText()==null || tietEmail.getText().toString().trim().length()<10
        || !tietEmail.getText().toString().trim().contains("@")){
            Toast.makeText(getApplicationContext(), R.string.invalid_email, Toast.LENGTH_LONG).show();
            return false;
        }
        if (rbUserRating.getRating() < 1) {
            Toast.makeText(getApplicationContext(), R.string.invalid_rating, Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }
}