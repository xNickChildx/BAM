package com.example.bam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.LinearLayout;

public class Sports extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sports_layout);
        TheMachine sports = new TheMachine("sports");
        LinearLayout buttonContainer = (LinearLayout) findViewById(R.id.dunno);
        for (Topic t : sports.topics) {

            Button i = new Button(this);
            i.setText(t.title.toString());
            buttonContainer.addView(i);
        }
    }

}
