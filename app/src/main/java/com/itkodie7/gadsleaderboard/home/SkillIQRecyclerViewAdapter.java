package com.itkodie7.gadsleaderboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.itkodie7.gadsleaderboard.info.SkillIQLeadersInfo;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class SkillIQRecyclerViewAdapter extends RecyclerView.Adapter<SkillIQRecyclerViewAdapter.ViewHolder> {
    Context mContext;
    private List<SkillIQLeadersInfo> mLearnersInfo;

    private View view;

    public SkillIQRecyclerViewAdapter(Context context , List<SkillIQLeadersInfo> learnersInfo) {
        this.mContext = context;
        this.mLearnersInfo = learnersInfo;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.leaderboard_format, parent, false);
        return new SkillIQRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        String imageUrl = mLearnersInfo.get(position).getBadgeUrl();
        String studentDetails = mLearnersInfo.get(position).getScore() +
                " skill IQ Score, " + mLearnersInfo.get(position).getCountry();

        Glide.with(mContext)
                .load(imageUrl)
                .into(holder.badge);
        holder.mLearnername.setText(mLearnersInfo.get(position).getName());
        holder.mLearnerDetails.setText(studentDetails);
    }

    @Override
    public int getItemCount() {
        return mLearnersInfo.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView badge;
        TextView mLearnername;
        TextView mLearnerDetails;

        public ViewHolder(View itemView) {
            super(itemView);

            badge = (ImageView) itemView.findViewById(R.id.badge);
            mLearnername =(TextView) itemView.findViewById(R.id.name);
            mLearnerDetails =(TextView) itemView.findViewById(R.id.details);
        }
    }
}
