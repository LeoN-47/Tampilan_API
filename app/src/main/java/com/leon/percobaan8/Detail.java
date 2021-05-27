package com.leon.percobaan8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Detail extends AppCompatActivity {

    String id;
    TextView txt_title, txt_body;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        txt_title = findViewById(R.id.tampilan_title);
        txt_body = findViewById(R.id.tampilan_body);

        Intent intent = getIntent();
        id = intent.getStringExtra("Idlist");
        onLoadDetailData(id);
        Log.d("CekId", id);
        getDataDetail();



    }

    private void onLoadDetailData(String id){

    }

    private void getDataDetail(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JSONPlaceholder jsonPlaceholder = retrofit.create(JSONPlaceholder.class);
        Call<List<Post_Detail>> call = jsonPlaceholder.getcomments(id);

        call.enqueue(new Callback<List<Post_Detail>>() {
            @Override
            public void onResponse(Call<List<Post_Detail>> call, Response<List<Post_Detail>> response) {
                if (response.isSuccessful()){
                    Log.d("contoh", response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<List<Post_Detail>> call, Throwable t) {
                Log.d("cekerror", t.toString());
            }
        });

    }

}