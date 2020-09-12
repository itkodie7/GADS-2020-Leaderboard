package com.itkodie7.gadsleaderboard.interfaces;

import com.itkodie7.gadsleaderboard.info.SkillIQLeadersInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SkillIq {


    @GET("/api/skilliq")
    Call<List<SkillIQLeadersInfo>> getLearners();
}
