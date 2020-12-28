package com.skuad.skuadrestaurantsapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.skuad.skuadrestaurantsapp.R;
import com.skuad.skuadrestaurantsapp.adapter.RestaurantsResultsAdapter;
import com.skuad.skuadrestaurantsapp.api.API;
import com.skuad.skuadrestaurantsapp.responsepojo.RestaurantsResultsResponse;
import com.wang.avi.AVLoadingIndicatorView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestaurantsActivity extends AppCompatActivity {

    AVLoadingIndicatorView avi_indicator;
    RecyclerView rv_restaurantsresults;
    TextView tv_norecords;
    EditText edit_search;

    private final String TAG = "RestaurantsActivity";
    private List<RestaurantsResultsResponse.ResultsBean> restaurantsResultsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);

        avi_indicator = findViewById(R.id.avi_indicator);
        rv_restaurantsresults = findViewById(R.id.rv_restaurantsresults);
        tv_norecords = findViewById(R.id.tv_norecords);
        edit_search = findViewById(R.id.edit_search);
        avi_indicator.setVisibility(View.GONE);
        getRestaurantsResultsResponse();


        edit_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                Log.w(TAG,"beforeTextChanged-->"+s.toString());
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.w(TAG,"onTextChanged-->"+s.toString());


            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.w(TAG,"afterTextChanged-->"+s.toString());
                  placesSearchResponseCall(s.toString());

            }
        });



    }

    private void getRestaurantsResultsResponse() {
        avi_indicator.setVisibility(View.VISIBLE);
        avi_indicator.smoothToShow();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        API service = retrofit.create(API.class);

        service.getRestaurantsResultsResponse().enqueue(new Callback<RestaurantsResultsResponse>() {
            @Override
            public void onResponse(@NotNull Call<RestaurantsResultsResponse> call, @NotNull Response<RestaurantsResultsResponse> response) {
                avi_indicator.smoothToHide();
                Log.w(TAG,"url  :%s"+ call.request().url().toString());


                Log.w(TAG,"RestaurantsResultsResponse" + new Gson().toJson(response.body()));


                 if(response.body().getResults() != null){
                    restaurantsResultsList =  response.body().getResults();

                     if (restaurantsResultsList.size() > 0 ) {
                         rv_restaurantsresults.setVisibility(View.VISIBLE);
                         tv_norecords.setVisibility(View.GONE);
                         setViewPlacesResulsts();
                     }else{
                         rv_restaurantsresults.setVisibility(View.GONE);
                         tv_norecords.setVisibility(View.VISIBLE);
                     }


                 }


            }

            @Override
            public void onFailure(@NotNull Call<RestaurantsResultsResponse> call, @NotNull Throwable t) {
                avi_indicator.smoothToHide();
                t.printStackTrace();
            }
        });
    }

    private void setViewPlacesResulsts() {
        rv_restaurantsresults.setLayoutManager(new LinearLayoutManager(this));
        rv_restaurantsresults.setItemAnimator(new DefaultItemAnimator());
        RestaurantsResultsAdapter restaurantsResultsAdapter = new RestaurantsResultsAdapter(getApplicationContext(), restaurantsResultsList);
        rv_restaurantsresults.setAdapter(restaurantsResultsAdapter);

    }


    private void placesSearchResponseCall(String places) {
        avi_indicator.setVisibility(View.VISIBLE);
        avi_indicator.smoothToShow();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        API service = retrofit.create(API.class);

        String key = API.key;
        service.getRestaurantsSearchResultsResponse(places, key).enqueue(new Callback<RestaurantsResultsResponse>() {
            @Override
            public void onResponse(@NotNull Call<RestaurantsResultsResponse> call, @NotNull Response<RestaurantsResultsResponse> response) {
                avi_indicator.smoothToHide();
                Log.w(TAG,"url  :%s"+ call.request().url().toString());


                Log.w(TAG,"placesSearchResponseCall" + new Gson().toJson(response.body()));

                if(response.body().getResults() != null){
                    restaurantsResultsList =  response.body().getResults();

                    if (restaurantsResultsList.size() > 0 ) {
                        rv_restaurantsresults.setVisibility(View.VISIBLE);
                        tv_norecords.setVisibility(View.GONE);
                        setViewPlacesResulsts();
                    }else{
                        rv_restaurantsresults.setVisibility(View.GONE);
                        tv_norecords.setVisibility(View.VISIBLE);
                    }


                }


            }

            @Override
            public void onFailure(@NotNull Call<RestaurantsResultsResponse> call, @NotNull Throwable t) {
                avi_indicator.smoothToHide();
                t.printStackTrace();
            }
        });
    }



}