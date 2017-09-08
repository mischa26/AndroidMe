package com.hyperdev.androidme.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hyperdev.androidme.R;
import com.hyperdev.androidme.data.BodyPartFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BodyPartFragment blankFragment = new BodyPartFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.blankFragmentContainer, blankFragment)
                .commit();
    }
}
