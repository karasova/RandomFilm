package com.example.randomfilm;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    String[] movies;
    boolean[] used;
    int sum = 0;
    TextView films;
    int i = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        movies = getResources().getStringArray(R.array.Films);
        films=findViewById(R.id.film_title);
        used = new boolean[movies.length];
        Log.d("mytag", "function inCreate called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("mytag", "function inResume called");
    }


    public void onClick(View view)
    {
        if (sum == movies.length && view.getId() != R.id.drop)
        {
            films.setText("Все фильмы просмотрены");
            return;
        }

        if (view.getId() == R.id.rand)
        {
            i = (int)(Math.random() * movies.length);
            while (used[i])
            {
                i = (int)(Math.random() * movies.length);
            }
            used[i] = true;
            sum++;

            films.setText(movies[i]);
        }

        if (view.getId() == R.id.drop)
        {
            films.setText("Выберите фильм");
            for (int i = 0;i < movies.length;i++)
            {
                used[i] = false;
            }
            sum = 0;
        }
    }
}
