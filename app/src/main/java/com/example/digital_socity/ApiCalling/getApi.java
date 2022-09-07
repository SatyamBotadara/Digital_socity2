package com.example.digital_socity.ApiCalling;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class getApi {
    public static apicall getApiInstance(){
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("https://botadarasatyam.000webhostapp.com/ ")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return  retrofit.create(apicall.class);


    }
}
