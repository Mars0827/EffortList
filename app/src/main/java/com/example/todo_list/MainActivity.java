package com.example.todo_list;

import android.annotation.SuppressLint;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.todo_list.First_fragment;
import com.example.todo_list.R;

public class MainActivity extends AppCompatActivity {

    private ImageButton homeButton, anotherButton;
    private View circle;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeButton = findViewById(R.id.homeButton);
        homeButton.setColorFilter(getResources().getColor(android.R.color.white), PorterDuff.Mode.SRC_IN);

        anotherButton = findViewById(R.id.imageButton3);
        anotherButton.setColorFilter(getResources().getColor(android.R.color.white), PorterDuff.Mode.SRC_IN);

        circle = findViewById(R.id.yellow_circle);

        // Check if the fragment is already added
        if (savedInstanceState == null) {
            // Create an instance of the fragment
            Fragment fragment = new First_fragment();

            // Get the FragmentManager and start a transaction
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            // Add the fragment to the 'fragment_container'
            fragmentTransaction.add(R.id.fragment_container, fragment);
            fragmentTransaction.commit();
        }

        anotherButton.setOnClickListener(v -> {
            // Create an instance of the fragment
            Fragment fragment = new First_fragment();

            // Get the FragmentManager and start a transaction
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            // Replace the existing fragment with the new fragment
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.addToBackStack(null); // Add transaction to the back stack so the user can navigate back
            fragmentTransaction.commit();
        });
    }
}
