package com.example.digital_socity.chairMain;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.digital_socity.ApiCalling.getApi;
import com.example.digital_socity.ApiCalling.statuscode;
import com.example.digital_socity.databinding.FragmentProfileBinding;
import com.google.android.material.snackbar.Snackbar;
import java.util.Objects;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class profileFragment extends Fragment {

    private FragmentProfileBinding binding;
    SharedPreferences preferences;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        binding=FragmentProfileBinding.inflate(getLayoutInflater());
        preferences=getContext().getSharedPreferences("digitalsocity",MainActivityChairMan.MODE_PRIVATE);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        binding.userid.setText(String.valueOf(preferences.getInt("id",-1)));
        binding.edtContectprofile.setText(preferences.getString("ContactNo","default"));
        binding.edthousenoprofile.setText(preferences.getString("HouseNo","default"));
        binding.edtFirstNameprofile.setText(preferences.getString("FirstName","default"));
        binding.edtLastnameprofile.setText(preferences.getString("LastName","default"));

        binding.btnuserupadte.setOnClickListener(view1 -> {


            String Firstname= Objects.requireNonNull(binding.edtFirstNameprofile.getText()).toString().trim();
            String Lastname= Objects.requireNonNull(binding.edtLastnameprofile.getText()).toString().trim();
            String ContactNo= Objects.requireNonNull(binding.edtContectprofile.getText()).toString().trim();
            String houseno= Objects.requireNonNull(binding.edthousenoprofile.getText()).toString().trim();

            if(Firstname.isEmpty() || Lastname.isEmpty() || ContactNo.isEmpty() || houseno.isEmpty())
            {

                Snackbar.make(binding.getRoot(),"Empty Field is not allowed",Snackbar.LENGTH_SHORT).show();
            }
            else
            {
                binding.updateprogress.setVisibility(View.VISIBLE);
                Call<statuscode> call=
                        getApi.getApiInstance().updateuser(Integer.parseInt(binding.userid.getText().toString()),
                                Firstname,
                                Lastname,
                                ContactNo,
                                houseno);

                call.enqueue(new Callback<statuscode>()
                {
                    @Override
                    public void onResponse(@NonNull Call<statuscode> call, @NonNull Response<statuscode> response)
                    {
                        assert response.body() != null;
                        int status=Integer.parseInt(response.body().getStatus());
                        switch (status)
                        {
                            case 5:Snackbar.make(binding.getRoot(),"Internal server error!",Snackbar.LENGTH_SHORT).show();
                                binding.updateprogress.setVisibility(View.GONE);
                                break;

                            case 10:Snackbar.make(binding.getRoot(),"Successfully updated",Snackbar.LENGTH_SHORT).show();
                                SharedPreferences.Editor editor=preferences.edit();
                                editor.putString("FirstName",Firstname);
                                editor.putString("LastName",Lastname);
                                editor.putString("HouseNo",houseno);
                                editor.putString("ContactNo",ContactNo);
                                editor.apply();
                                binding.updateprogress.setVisibility(View.GONE);
                                break;
                        }
                    }
                    @Override
                    public void onFailure(@NonNull Call<statuscode> call, @NonNull Throwable t)
                    {
                        Log.i("errornetworfail", t.toString());
                        Snackbar.make(binding.getRoot()," error!",Snackbar.LENGTH_SHORT).show();
                        binding.updateprogress.setVisibility(View.GONE);
                    }
                });
            }
        });

    }
}