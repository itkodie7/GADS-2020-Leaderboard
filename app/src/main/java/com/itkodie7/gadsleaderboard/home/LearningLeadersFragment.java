package com.itkodie7.gadsleaderboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.itkodie7.gadsleaderboard.info.LearningLeadersInfo;
import com.itkodie7.gadsleaderboard.interfaces.LearningLeaders;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LearningLeadersFragment extends Fragment {

    public LearningLeadersFragment() {

    }

    private static final String BASE_URL = "https://gadsapi.herokuapp.com";

    RecyclerView mRecyclerView;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_learning_leaders, container, false);

        mRecyclerView = view.findViewById(R.id.learning_leaders_recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        LearningLeaders learningLeadersApi = retrofit.create(LearningLeaders.class);
        learningLeadersApi.getLearners().enqueue(new Callback<List<LearningLeadersInfo>>() {
            @Override
            public void onResponse(Call<List<LearningLeadersInfo>> call, Response<List<LearningLeadersInfo>> response) {
                mRecyclerView.setAdapter(new LearningLeadersRecyclerViewAdapter(getContext(), response.body()));
            }

            @Override
            public void onFailure(Call<List<LearningLeadersInfo>> call, Throwable t) {

            }
        });
        return view;
    }
}
