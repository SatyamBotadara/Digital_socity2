package com.example.digital_socity.Register;

import    androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.digital_socity.ApiCalling.apicall;
import com.example.digital_socity.ApiCalling.getApi;
import com.example.digital_socity.ApiCalling.statuscode;
import com.example.digital_socity.databinding.ActivityRegisterBinding;
import com.example.digital_socity.login.LoginActivity;
import com.google.android.material.snackbar.Snackbar;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    private ActivityRegisterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Objects.requireNonNull(getSupportActionBar()).hide();

        binding.btnregister.setOnClickListener(view -> {

            binding.loginprogress.setVisibility(View.VISIBLE);

            String FirstName=binding.edtregisterFirstName.getText().toString();
            String LastName=binding.edtregisterLastName.getText().toString();
            String Email=binding.edtregisteremail.getText().toString();
            String contactno=binding.edtregistercontactno.getText().toString();
            Integer houseno=Integer.parseInt(binding.edtregisterhouseno.getText().toString());
            String password=binding.edtregisterpassword.getText().toString();

            apicall apicall=getApi.getApiInstance();
            Call<statuscode> call=apicall.addChairMain(FirstName,LastName,Email,password,houseno,contactno);
            call.enqueue(new Callback<statuscode>() {
                @Override
                public void onResponse(Call<statuscode> call, Response<statuscode> response) {
                    Integer status=Integer.parseInt(response.body().getStatus());

                    switch (status){
                        case 3:

                            Snackbar.make(binding.getRoot(),"Email id is alerady exits please login",Snackbar.LENGTH_SHORT).show();

                            binding.loginprogress.setVisibility(View.GONE);
                            break;
                        case 5:
                            Snackbar.make(binding.getRoot(),"Internal server error try again",Snackbar.LENGTH_SHORT).show();
                            binding.loginprogress.setVisibility(View.GONE);
                            break;
                        case 10:
                            Intent i=new Intent(RegisterActivity.this, LoginActivity.class);
                            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(i);
                            binding.loginprogress.setVisibility(View.GONE);
                            finish();
                            break;
                    }
                }

                @Override
                public void onFailure(Call<statuscode> call, Throwable t) {

                }
            });

        });

    }
}