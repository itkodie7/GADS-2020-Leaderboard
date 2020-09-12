package com.itkodie7.gadsleaderboard;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class LeaderboardActivity extends AppCompatActivity{
        TabLayout mTabLayout;
        ViewPager2 mViewPager;
        private String[] mTabTitles;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_leaderboard);

            mTabTitles = getResources().getStringArray(R.array.tab_titles);
            mTabLayout = findViewById(R.id.tabs);
            mViewPager = findViewById(R.id.view_pager);
            Button submit = (Button)findViewById(R.id.submit_button);

            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent submitActivity = new Intent(com.itkodie7.gadsleaderboard.
                            LeaderboardActivity.this, ProjectSubmissionActivity.class);
                    startActivity(submitActivity);
                }
            });

            mTabLayout.addTab(mTabLayout.newTab());
            mTabLayout.addTab(mTabLayout.newTab());
            mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

            ViewPagerAdapter adapter = new ViewPagerAdapter(this, 2);
            mViewPager.setAdapter(adapter);

            new TabLayoutMediator(mTabLayout, mViewPager, new TabLayoutMediator.TabConfigurationStrategy() {
                        @Override
                        public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                            Log.e("Tab", String.valueOf(position));
                            tab.setText(mTabTitles[position]);
                        }
                    }
            ).attach();
        }


}
