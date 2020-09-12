package com.itkodie7.gadsleaderboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.itkodie7.gadsleaderboard.info.LearningLeadersInfo;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class LearningLeadersRecyclerViewAdapter extends RecyclerView.Adapter<LearningLeadersRecyclerViewAdapter.ViewHolder> {
    Context mContext;
    private List<LearningLeadersInfo> mLearnersInfo;

    private View view;

    public LearningLeadersRecyclerViewAdapter(Context context , List<LearningLeadersInfo> learnersInfo) {
        this.mContext = context;
        this.mLearnersInfo = learnersInfo;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.leaderboard_format, parent, false);
        return new LearningLeadersRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        String imageUrl = mLearnersInfo.get(position).getBadgeUrl();
        String learnerDetails = mLearnersInfo.get(position).getHours() +
                " learning hours, " + mLearnersInfo.get(position).getCountry();

        Glide.with(mContext)
                .load(imageUrl)
                .into(holder.badge);
        holder.mLearnername.setText(mLearnersInfo.get(position).getName());
        holder.mLearnerDetails.setText(learnerDetails);
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
