package com.example.lucifer.dagger2implementation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.squareup.picasso.Picasso;

import javax.inject.Inject;


import component.DaggerRandomUserComponent;
import component.RandomUserComponent;
import interfaces.RandomUsersApi;
import model.RandomUsers;
import module.ContextModule;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public RandomUsersApi randomUsersApi;
    public Picasso picasso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RandomUserComponent randomUserComponent= DaggerRandomUserComponent.builder()
                .contextModule(new ContextModule(this))
                .build();


        picasso=randomUserComponent.getPicasso();
        randomUsersApi=randomUserComponent.getRandomUsersService();


        Call<RandomUsers> result=randomUsersApi.getRandomUsers();
        result.enqueue(new Callback<RandomUsers>() {
            @Override
            public void onResponse(Call<RandomUsers> call, Response<RandomUsers> response) {
                System.out.println(response.body().getInfo());
            }

            @Override
            public void onFailure(Call<RandomUsers> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }
}
