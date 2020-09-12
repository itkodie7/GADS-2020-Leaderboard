package com.itkodie7.gadsleaderboard;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.itkodie7.gadsleaderboard.info.SkillIQLeadersInfo;
import com.itkodie7.gadsleaderboard.interfaces.SkillIq;

import java.util.List;

public class SkillIQFragment extends Fragment {

    public SkillIQFragment() {

    }
    private static final String BASE_URL = "https://gadsapi.herokuapp.com";

    RecyclerView mRecyclerView;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_skill_iq, container, false);

        mRecyclerView = view.findViewById(R.id.learning_skill_recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit= builder.build();
        SkillIq skilliqLeadersApi  =  retrofit.create(SkillIq.class);
        skilliqLeadersApi.getLearners().enqueue(new Callback<List<SkillIQLeadersInfo>>() {
            @Override
            public void onResponse(Call<List<SkillIQLeadersInfo>> call, Response<List<SkillIQLeadersInfo>> response) {
                Log.e("response",response.body().toString());
                mRecyclerView.setAdapter(new SkillIQRecyclerViewAdapter(getContext(),response.body()));
            }

            @Override
            public void onFailure(Call<List<SkillIQLeadersInfo>> call, Throwable t) {

            }
        });
        return view;
    }
}
