package com.itkodie7.gadsleaderboard;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {
    int mTotalTabs;

    public ViewPagerAdapter(@NonNull FragmentActivity fm, int totalTabs) {
        super(fm);
        this.mTotalTabs = totalTabs;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                LearningLeadersFragment learningLeadersFragment = new LearningLeadersFragment();
                return learningLeadersFragment;
            case 1:
                SkillIQFragment skilliQFragment = new SkillIQFragment();
                return skilliQFragment;
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return mTotalTabs;
    }
}
