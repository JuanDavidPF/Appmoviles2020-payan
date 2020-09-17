package com.example.apps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity {

    private NewTask newTaskFragment;
    private TaskList taskListFragment;
    private BottomNavigationView bottomNavigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigator = findViewById(R.id.bottomNavigator);

        newTaskFragment = NewTask.newInstance();
        taskListFragment = TaskList.newInstance();

        newTaskFragment.setListener(taskListFragment);

        showFragment(newTaskFragment);

        bottomNavigator.setOnNavigationItemSelectedListener(
                (itemSelected) -> {

                    switch (itemSelected.getItemId()) {

                        case R.id.newTaskOption:

                            showFragment(newTaskFragment);

                            break;

                        case R.id.taskListOption:
                            showFragment(taskListFragment);

                            break;

                    }//closes switch
                    return true;
                });//closes itemSelectedListener

    }

    public void showFragment(Fragment fragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer, fragment);
        fragmentTransaction.commit();

    }
}