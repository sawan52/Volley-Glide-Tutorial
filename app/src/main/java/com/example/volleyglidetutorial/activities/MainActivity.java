package com.example.volleyglidetutorial.activities;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.volleyglidetutorial.R;
import com.example.volleyglidetutorial.adapters.RecyclerViewAdapter;
import com.example.volleyglidetutorial.model.Anime;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final String JSON_URL = "https://gist.githubusercontent.com/aws1994/f583d54e5af8e56173492d3f60dd5ebf/raw/c7796ba51d5a0d37fc756cf0fd14e54434c547bc/anime.json";

    private RecyclerView recyclerView;
    private JsonArrayRequest arrayRequest ;
    private RequestQueue requestQueue ;
    private List<Anime> listAnime = new ArrayList<>();
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog = new ProgressDialog(this);

        listAnime = new ArrayList<>();
        recyclerView = findViewById(R.id.recycler_view);

        jsonRequest();

    }

    private void jsonRequest() {

        progressDialog.setMessage("Loading...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();

        arrayRequest = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject = null;

                progressDialog.dismiss();

                for (int i = 0; i < response.length(); i++) {

                    try {
                        jsonObject = response.getJSONObject(i);

                        Anime anime = new Anime();
                        anime.setName(jsonObject.getString("name"));
                        anime.setRating(jsonObject.getString("Rating"));
                        anime.setDescription(jsonObject.getString("description"));
                        anime.setImage_url(jsonObject.getString("img"));
                        anime.setStudio(jsonObject.getString("studio"));
                        anime.setCategory(jsonObject.getString("categorie"));

                        listAnime.add(anime);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

                setUpRecyclerView(listAnime);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, "Some error occurred, Please try again!", Toast.LENGTH_SHORT).show();

            }
        });

        requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(arrayRequest);
    }

    private void setUpRecyclerView(List<Anime> listAnime) {

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, listAnime);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(adapter);

    }
}
