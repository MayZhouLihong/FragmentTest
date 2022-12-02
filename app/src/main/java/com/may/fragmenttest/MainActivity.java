package com.may.fragmenttest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    boolean isGreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(this);
        replaceFragment(new AnotherRightFragment());
    }

    @Override
    public void onClick(View view) {
        Fragment fragment;
        if (isGreen) {
            fragment = new AnotherRightFragment();
        } else {
            fragment = new RightFragment();
        }
        replaceFragment(fragment);
        isGreen = !isGreen;
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.right_fragment, fragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }
}