package com.BreynnerPerez.juegossena;

import retrofit2.Retrofit;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity2 extends AppCompatActivity {

    private EditText searchEditText;
    private RecyclerView recyclerView;
    private GameAdapter gameAdapter;

    private static final String BASE_URL = " https://www.igdb.com/api";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchEditText = findViewById(R.id.searchEditText);
        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        gameAdapter = new GameAdapter();
        recyclerView.setAdapter(gameAdapter);

        // Configure Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GameApiService apiService = retrofit.create(GameApiService.class);

        searchEditText.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                String query = searchEditText.getText().toString();
                if (!query.isEmpty()) {
                    // Make API request
                    Call<GameResponse> call = apiService.searchGames(query);
                    call.enqueue(new Callback<GameResponse>() {
                        @Override
                        public void onResponse(Call<GameResponse> call, Response<GameResponse> response) {
                            if (response.isSuccessful()) {
                                List<Game> games = response.body().getResults();
                                gameAdapter.setGames(games);
                            }
                        }
                        @Override
                        public void onFailure(Call<GameResponse> call, Throwable t) {
                            Log.e("MainActivity", "Error fetching games", t);
                        }
                    });
                }
                return true;
            }
            return false;
        });
    }
}


