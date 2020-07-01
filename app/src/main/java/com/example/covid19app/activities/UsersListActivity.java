package com.example.covid19app.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.covid19app.R;
import com.example.covid19app.adapters.QuestionsAdapter;
import com.example.covid19app.adapters.UsersAdapter;
import com.example.covid19app.models.Question;
import com.example.covid19app.models.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class UsersListActivity extends AppCompatActivity {

    private RecyclerView usersRecyclerView;
    private UsersAdapter usersAdapter;
    private List<User> users = new ArrayList<>();
    private FirebaseFirestore firebaseFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_list);

        usersRecyclerView = findViewById(R.id.usersRecyclerView);

        firebaseFirestore = FirebaseFirestore.getInstance();

        usersRecyclerViewSetup();

        getUsers();

    }

    private void getUsers() {

        firebaseFirestore.collection("users")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {

                                User user = document.toObject(User.class);
                                user.setUid(document.getId());
                                Toast.makeText(UsersListActivity.this
                                        , user.getUid(), Toast.LENGTH_SHORT).show();
                                users.add(user);

                            }

                            usersAdapter.notifyDataSetChanged();

                        } else {

                            Toast.makeText(UsersListActivity.this, "فشل جلب البيانات", Toast.LENGTH_SHORT).show();

                        }
                    }
                });

    }

    private void usersRecyclerViewSetup() {

        usersAdapter = new UsersAdapter(getApplicationContext(), users);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext()
                , LinearLayoutManager.VERTICAL, false);
        usersRecyclerView.setLayoutManager(linearLayoutManager);
        usersRecyclerView.setAdapter(usersAdapter);

    }

}
