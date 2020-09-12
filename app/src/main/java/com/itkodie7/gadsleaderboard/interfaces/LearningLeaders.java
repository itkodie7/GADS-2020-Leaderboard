package com.itkodie7.gadsleaderboard.interfaces;

import com.itkodie7.gadsleaderboard.info.LearningLeadersInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LearningLeaders {


    @GET("/api/hours")
    Call<List<LearningLeadersInfo>> getLearners();
}
