package com.exam.brnquiz;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;


public class QuestionFragment extends Fragment {

    private TextView questionText;
    private ListView optionsList;

    private Question currentQuestion;

    public QuestionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_question, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        questionText = view.findViewById(R.id.questionText);
        optionsList = view.findViewById(R.id.optionsList);


        List<String> answers = Arrays.asList("Bogota", "Medellin", "Cali", "Cartagena");
        currentQuestion = new Question("What is the capital of Colombia?", answers, 0);

        questionText.setText(currentQuestion.getQuestion());


        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                getContext(),
                android.R.layout.simple_list_item_1,
                currentQuestion.getAnswers()
        );

        optionsList.setAdapter(adapter);
    }
}
