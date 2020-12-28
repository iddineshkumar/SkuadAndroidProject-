package com.skuad.skuadrestaurantsapp.api;




import com.skuad.skuadrestaurantsapp.responsepojo.RestaurantsResultsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface API {
    //  https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=47.6204,-122.3491&radius=2500&type=restaurant&key=AIzaSyBnEVruXG2tdtbadZtqLwt9EmFI6XYEOV0

    String BASE_URL = "https://maps.googleapis.com/maps/api/place/nearbysearch/";
    String key = "AIzaSyBnEVruXG2tdtbadZtqLwt9EmFI6XYEOV0";

    @GET("json?location=47.6204,-122.3491&radius=2500&type=restaurant&key=AIzaSyBnEVruXG2tdtbadZtqLwt9EmFI6XYEOV0")
    Call<RestaurantsResultsResponse> getRestaurantsResultsResponse();


    /*https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=47.6204,-122.3491&radius=2500&type=restaurant&keyword=:keyword&key=AIzaSyBnEVruXG2tdtbadZtqLwt9EmFI6XYEOV0*/

    @GET("json?location=47.6204,-122.3491&radius=2500&type=restaurant/")
    Call<RestaurantsResultsResponse> getRestaurantsSearchResultsResponse(@Query("keyword") String input, @Query("key") String key);


}