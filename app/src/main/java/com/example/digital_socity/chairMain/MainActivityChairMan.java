package com.example.digital_socity.chairMain;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.example.digital_socity.ApiCalling.Userprofile;
import com.example.digital_socity.ApiCalling.apicall;
import com.example.digital_socity.ApiCalling.getApi;
import com.example.digital_socity.R;
import com.example.digital_socity.databinding.ActivityMainChairManBinding;
import com.example.digital_socity.login.LoginActivity;
import com.google.android.material.snackbar.Snackbar;
import java.util.ArrayList;
import java.util.Objects;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityChairMan extends AppCompatActivity
{

    private ActivityMainChairManBinding binding;
    private ArrayList<memberRequestModel> list;

    @SuppressLint({"NonConstantResourceId", "CommitPrefEdits", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences preferences=getSharedPreferences("digitalsocity",MODE_PRIVATE);
        // variable declaration

        binding=ActivityMainChairManBinding.inflate(getLayoutInflater());
        binding.progressbarMainactivity.setVisibility(View.VISIBLE);
        setContentView(binding.getRoot());
        Objects.requireNonNull(getSupportActionBar()).hide();

        //get email from login activity
        String email=getIntent().getStringExtra("email");

        // check for the data store in shared preference

        if(preferences.contains("userdata"))
        {
            // user data set . we only have to fetch the data and display from sharedpreference

            Userprofile userprofile=new Userprofile();

            userprofile.setEmail(preferences.getString("Email","default"));
            userprofile.setContactNo(preferences.getString("ContactNo","default"));
            userprofile.setFirstName(preferences.getString("FirstName","default"));
            userprofile.setLastName(preferences.getString("LastName","default"));
            userprofile.setId(String.valueOf(preferences.getInt("id",0)));
            userprofile.setHouseNo(preferences.getString("HouseNo","default"));

            View view= binding.navigationdrawer.getHeaderView(0);
            TextView textView= view.findViewById(R.id.navigationheaderEmail);
            TextView textViewname= view.findViewById(R.id.headernavigationname);

            textView.setText(userprofile.getEmail());
            textViewname.setText(userprofile.getFirstName()+" "+userprofile.getLastName());
            binding.progressbarMainactivity.setVisibility(View.GONE);
        }
        else
        {
            // user data not set before we have to set new data

            // getemail of login user

            // call the api for getting the data of specific email

            apicall apicall=getApi.getApiInstance();
            Call<Userprofile> call=apicall.getuserdata(email);

            call.enqueue(new Callback<Userprofile>() {
                @SuppressLint("SetTextI18n")
                @Override
                public void onResponse(@NonNull Call<Userprofile> call, @NonNull Response<Userprofile> response) {
                    Userprofile userprofile=response.body();
                    View view= binding.navigationdrawer.getHeaderView(0);
                    TextView textView= view.findViewById(R.id.navigationheaderEmail);
                    TextView textViewname= view.findViewById(R.id.headernavigationname);

                    textView.setText(Objects.requireNonNull(userprofile).getEmail());
                    textViewname.setText(userprofile.getFirstName()+" "+userprofile.getLastName());
                    SharedPreferences.Editor editor=preferences.edit();

                    //set data into shared preference

                    editor.putBoolean("userdata",true);

                    editor.putInt("id",Integer.parseInt(userprofile.getId()));
                    editor.putString("Email",userprofile.getEmail());
                    editor.putString("FirstName",userprofile.getFirstName());
                    editor.putString("LastName",userprofile.getLastName());
                    editor.putString("HouseNo",userprofile.getHouseNo());
                    editor.putString("ContactNo",userprofile.getContactNo());
                    editor.apply();
                    binding.progressbarMainactivity.setVisibility(View.GONE);
                }

                @Override
                public void onFailure(@NonNull Call<Userprofile> call, @NonNull Throwable t)
                {
                    Snackbar.make(binding.getRoot(),"Server Error! try Again",Snackbar.LENGTH_SHORT).show();
                    binding.progressbarMainactivity.setVisibility(View.GONE);
                }

            });
        }

        // sharedpreference

        SharedPreferences sharedPreferences=getSharedPreferences("login",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();

        //  navigation declaration

        final NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentcontainerview);
        final NavController navController = Objects.requireNonNull(navHostFragment).getNavController();

        //navigation icon click listener

        binding.toolbar.setNavigationOnClickListener(view -> binding.getRoot().openDrawer(GravityCompat.START));

        //navigation menu item click listener

        binding.navigationdrawer.setNavigationItemSelectedListener(item -> {

            switch (item.getItemId())
            {
                case R.id.menuitemlogout: editor.remove("isLogin");
                                          editor.apply();
                                          preferences.edit().clear().apply();
                                          Intent i=new Intent(MainActivityChairMan.this, LoginActivity.class);
                                          startActivity(i);
                                          finish();
                                          break;

                case R.id.menuitemMemberRequest: navController.popBackStack();
                                                 binding.getRoot().closeDrawer(GravityCompat.START);
                                                 navController.navigate(R.id.request);
                                                 break;
                case R.id.menuitemprofile:  navController.popBackStack();
                                            navController.navigate(R.id.profileFragment);
                                            binding.getRoot().closeDrawer(GravityCompat.START);
                                            break;

                case R.id.menuitemComplaints: navController.popBackStack();
                                              navController.navigate(R.id.complainFragment);
                                              binding.getRoot().closeDrawer(GravityCompat.START);
                                              break;

                case R.id.menuitemEvent:
                                        navController.popBackStack();
                                        navController.navigate(R.id.eventFragment);
                                        binding.getRoot().closeDrawer(GravityCompat.START);
                                        break;

                case R.id.menuitemNotice:
                                        navController.popBackStack();
                                        navController.navigate(R.id.noticeFragment);
                                        binding.getRoot().closeDrawer(GravityCompat.START);
                                        break;
            }

            return false;
        });
    }

    @Override
    public void onBackPressed() {

        if(binding.getRoot().isDrawerOpen(GravityCompat.START)){
            binding.getRoot().closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
    }

}