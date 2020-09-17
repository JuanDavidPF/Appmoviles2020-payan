package com.example.apps;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


public class TaskList extends Fragment implements NewTask.OnTaskAddedListener {


    //state
    private String task;
    private EditText taskListET;


    public TaskList() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static TaskList newInstance() {
        TaskList fragment = new TaskList();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    //el fragment se infla
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_task_list, container, false);
        taskListET = layout.findViewById(R.id.taskListET);
        taskListET.setText(task);
        return layout;
    }

    @Override
    public void onTaskAdded(String task) {
        this.task = task;
    }
}