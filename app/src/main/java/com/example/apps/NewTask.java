package com.example.apps;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class NewTask extends Fragment {



    //referencia al observador
    private OnTaskAddedListener listener;


    public NewTask() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static NewTask newInstance() {
        NewTask fragment = new NewTask();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    //el fragment se infla
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_new_task, container, false);

        Button addTaskBtn = layout.findViewById(R.id.addTaskBtn);
        EditText newTaskET = layout.findViewById(R.id.newTaskET);

        addTaskBtn.setOnClickListener(

                (view) -> {

                    String task = newTaskET.getText().toString();
                    listener.onTaskAdded(task);

                });

        return layout;
    }//closes onCreateView

    public void setListener(OnTaskAddedListener listener) {
        this.listener = listener;
    }


    public interface OnTaskAddedListener {

        void onTaskAdded(String task);

    }

}//cierra la clase newTask