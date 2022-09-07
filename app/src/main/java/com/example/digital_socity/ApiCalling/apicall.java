package com.example.digital_socity.ApiCalling;

import  retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface apicall {

    @FormUrlEncoded
    @POST("register.php")
    Call<statuscode> addChairMain(@Field("FirstName") String FirstName,
                      @Field("LastName") String LastName,
                      @Field("Email") String Email,
                      @Field("Password") String Password,
                      @Field("HouseNo") Integer HouseNo,
                      @Field("ContactNo") String ContactNo);

    @FormUrlEncoded
    @POST("login.php")
    Call<statuscode> isLogin(
            @Field("Email") String Email,
            @Field("Password") String Password
    );

    @FormUrlEncoded
    @POST("userprofile.php")
    Call<Userprofile> getuserdata(
            @Field("Email") String Email
    );

    @FormUrlEncoded
    @POST("updateuser.php")
    Call<statuscode> updateuser(
            @Field("id") Integer id,
            @Field("FirstName") String FirstName,
            @Field("LastName") String LastName,
            @Field("ContactNo") String ContactNo,
            @Field("HouseNo") String HouseNo
    );


}
