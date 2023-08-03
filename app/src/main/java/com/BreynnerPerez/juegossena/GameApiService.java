package com.BreynnerPerez.juegossena;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GameApiService {
    @GET("games")
    Call<GameResponse> searchGames(@Query("search") String query);
}
