package com.example.digital_socity.login;

import  androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import com.example.digital_socity.ApiCalling.apicall;
import com.example.digital_socity.ApiCalling.getApi;
import com.example.digital_socity.ApiCalling.statuscode;
import com.example.digital_socity.Register.RegisterActivity;
import com.example.digital_socity.chairMain.MainActivityChairMan;
import com.example.digital_socity.databinding.ActivityLoginBinding;
import com.google.android.material.snackbar.Snackbar;
import java.util.Objects;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    @Override
    protected void onResume() {
        super.onResume();
        binding.loginprogress.setVisibility(View.GONE);
    }

    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Objects.requireNonNull(getSupportActionBar()).hide();

        binding.btnLogin.setOnClickListener(view -> {




            String Email= Objects.requireNonNull(binding.edtEmail.getText()).toString();
            String password= Objects.requireNonNull(binding.edtPassword.getText()).toString();

            Email=Email.trim();
            password=password.trim();

            if(Email.isEmpty()||password.isEmpty())
            {
                if(Email.isEmpty()){
                    Snackbar.make(binding.getRoot(),"Empty Email is not allowed",Snackbar.LENGTH_SHORT).show();
                }
                else if(password.isEmpty()){
                    Snackbar.make(binding.getRoot(),"Empty password is not allowed",Snackbar.LENGTH_SHORT).show();
                }

            }
            else{
                binding.loginprogress.setVisibility(View.VISIBLE);
                binding.getRoot().setAlpha(0.4f);
            // call the api
            apicall api=getApi.getApiInstance();
            Call<statuscode> call=api.isLogin(Email,password);

                String finalEmail = Email;
                call.enqueue(new Callback<statuscode>() {
                @Override
                public void onResponse(Call<statuscode> call, Response<statuscode> response) {
                    Integer status=Integer.parseInt(response.body().getStatus());
                    binding.loginprogress.setVisibility(View.GONE);
                    switch (status) {
                        case 1:
                            // invalid email id
                            binding.getRoot().setAlpha(1f);
                            Snackbar.make(binding.getRoot(), "Invalid Email id Please Check!", Snackbar.LENGTH_SHORT).show();
                            break;
                        case 2:
                            // invalid password
                            binding.getRoot().setAlpha(1f);
                            Snackbar.make(binding.getRoot(), "Invalid Password Please Check!", Snackbar.LENGTH_SHORT).show();
                            break;
                        case 4:
                            binding.getRoot().setAlpha(1f);
                            Snackbar.make(binding.getRoot(), "server error try again after some time! Imform Developer", Snackbar.LENGTH_SHORT).show();
                            break;
                        case 5:
                            binding.getRoot().setAlpha(1f);
                            Snackbar.make(binding.getRoot(), "Internal database Error! Imform Developer", Snackbar.LENGTH_SHORT).show();
                            break;
                        case 10:
                            SharedPreferences sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putBoolean("isLogin", true);
                            editor.apply();

                            Intent i = new Intent(LoginActivity.this, MainActivityChairMan.class);
                            i.putExtra("email", finalEmail);
                            startActivity(i);

                            finish();

                            break;
                    }
                }

                @Override
                public void onFailure(Call<statuscode> call, Throwable t) {
                    Snackbar.make(binding.getRoot(),"Internal Network issue!",Snackbar.LENGTH_SHORT).show();
                }
            });
            //end of else
            }

        });

        binding.registertext.setOnClickListener(view -> {

            binding.loginprogress.setVisibility(View.VISIBLE);
            Intent i=new Intent(LoginActivity.this, RegisterActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);

        });

    }
}