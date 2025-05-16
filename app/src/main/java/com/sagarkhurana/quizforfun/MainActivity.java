package com.sagarkhurana.quizforfun;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.sagarkhurana.quizforfun.data.User;
import com.sagarkhurana.quizforfun.other.SharedPref;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvUsername = findViewById(R.id.tvUsernameHome);
        CardView cvStartQuiz = findViewById(R.id.cvStartQuiz);
        CardView cvRule = findViewById(R.id.cvRule);
        CardView cvHistory = findViewById(R.id.cvHistory);
        CardView cvEditPassword = findViewById(R.id.cvEditPassword);
        CardView cvLogout = findViewById(R.id.cvLogout);
        MaterialButton btnBackToLogin = findViewById(R.id.btnBackToLogin);

        SharedPref sharedPref = SharedPref.getInstance();
        boolean isGuest = sharedPref.isGuest(this);
        User user = sharedPref.getUser(this);

        if (isGuest || user == null) {
            tvUsername.setText("Hello, Guest");
            cvHistory.setVisibility(View.GONE);
            cvEditPassword.setVisibility(View.GONE);
            cvLogout.setVisibility(View.GONE);
            btnBackToLogin.setVisibility(View.VISIBLE);
        } else {
            tvUsername.setText("Hello, " + user.getUsername());
            btnBackToLogin.setVisibility(View.GONE);
        }

        cvStartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, QuizOptionActivity.class));
            }
        });

        cvRule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RuleActivity.class));
            }
        });

        cvHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isGuest) {
                    Toast.makeText(MainActivity.this, "History is not available in guest mode", Toast.LENGTH_SHORT).show();
                    return;
                }
                startActivity(new Intent(MainActivity.this, HistoryActivity.class));
            }
        });

        cvEditPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isGuest) {
                    Toast.makeText(MainActivity.this, "Password editing is not available in guest mode", Toast.LENGTH_SHORT).show();
                    return;
                }
                startActivity(new Intent(MainActivity.this, EditPasswordActivity.class));
            }
        });

        cvLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isGuest) {
                    Toast.makeText(MainActivity.this, "Guest mode ended", Toast.LENGTH_SHORT).show();
                }
                sharedPref.clearSharedPref(MainActivity.this);
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnBackToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Guest mode ended", Toast.LENGTH_SHORT).show();
                sharedPref.clearSharedPref(MainActivity.this);
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });
    }
}