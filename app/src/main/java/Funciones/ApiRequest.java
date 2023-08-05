package Funciones;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.BreynnerPerez.juegossena.MainActivity2;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ApiRequest {
    public ApiRequest(){}
    private final OkHttpClient client = new OkHttpClient();
    JSONArray jsonArray;

    public JSONArray getjsonArray() {
        return jsonArray;
    }

    public void setMijSON(JSONArray jsonArray) {
        jsonArray = jsonArray;
    }

    public String makePost(String busqueda){
        MediaType MEDIA_TYPE_TEXT = MediaType.parse("text/plain");
        String requestBody = "search \""+busqueda+"\"; fields name;";

        Request request = new Request.Builder()
                .url("https://api.igdb.com/v4/games")
                .addHeader("Client-ID", "hmp51xkhjo5fmf6i7ti635c31r65hd")
                .addHeader("Authorization", "Bearer 2i4yosv2m9dj2o1w9u35f62j5i7rj7")
                .post(RequestBody.create(MEDIA_TYPE_TEXT, requestBody))
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                if (!response.isSuccessful()) {
                    throw new IOException("Unexpected code " + response);
                } else {
                    // do something with the response
                    //String rta = new String (String.valueOf(response));
                    Log.e("datos ebn la clase api request ",""+response.body());
                    /*
                    try {
                        jsonArray = new JSONArray(rta);
                        Log.e("json clase api", jsonArray.toString());
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                    String requestBody = new String(String.valueOf(response));

                     */
                }
            }
        });
        return requestBody;
    }

}
