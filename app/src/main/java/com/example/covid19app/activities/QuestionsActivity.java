package com.example.covid19app.activities;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covid19app.R;
import com.example.covid19app.adapters.QuestionsAdapter;
import com.example.covid19app.models.Question;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class QuestionsActivity extends AppCompatActivity {

    private RecyclerView questionsRecyclerView;
    private QuestionsAdapter questionsAdapter;
    private List<Question> questions = new ArrayList<>();
    private FirebaseFirestore firebaseFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        questionsRecyclerView = findViewById(R.id.questionsRecyclerView);

        firebaseFirestore = FirebaseFirestore.getInstance();

        questionsRecyclerViewSetup();

        getQuestions();

    }

    private void getQuestions() {

        firebaseFirestore.collection("questions")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {

                                Question question = document.toObject(Question.class);
                                questions.add(question);

                            }

                            questionsAdapter.notifyDataSetChanged();

                        } else {

                            Toast.makeText(QuestionsActivity.this, "فشل جلب البيانات", Toast.LENGTH_SHORT).show();

                        }
                    }
                });

    }

    private void questionsRecyclerViewSetup() {

        questionsAdapter = new QuestionsAdapter(getApplicationContext(), questions);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext()
                , LinearLayoutManager.VERTICAL, false);
        questionsRecyclerView.setLayoutManager(linearLayoutManager);
        questionsRecyclerView.setAdapter(questionsAdapter);

    }



}
