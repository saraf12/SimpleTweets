package com.codepath.apps.mysimpletweets;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.codepath.apps.mysimpletweets.models.Tweet;
import com.squareup.picasso.Picasso;

import java.util.List;

// Taking the Tweet objects and turning them into views displayed in the list
public class TweetsArrayAdapter extends ArrayAdapter<Tweet> {
    private static class ViewHolder {
        TextView tvUserName;
        TextView tvBody;
        ImageView IvProfileImage;
    }

    public TweetsArrayAdapter(Context context, List<Tweet> tweets) {
        super(context, 0, tweets);
    }


    // Override and setup custom template
    // ViewHolder pattern

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 1. Get the tweet
        Tweet tweet = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag
        // 2. Find or inflate the template
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_tweets, parent, false);
            // 3. Find the subviews to fill with data in the
            viewHolder.tvUserName = (TextView) convertView.findViewById(R.id.tvUserName);
            viewHolder.tvBody = (TextView) convertView.findViewById(R.id.tvBody);
            viewHolder.IvProfileImage = (ImageView) convertView.findViewById(R.id.IvProfileImage);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        /* // 3. Find the subviews to fill with data in the
        ImageView IvProfileImage = (ImageView) convertView.findViewById(R.id.IvProfileImage);
        TextView tvUserName = (TextView) convertView.findViewById(R.id.tvUserName);
        TextView tvBody = (TextView) convertView.findViewById(R.id.tvBody);

        // 4. Populate data into the subviews
        tvUserName.setText(tweet.getUser().getScreenName());
        tvBody.setText(tweet.getBody());
        IvProfileImage.setImageResource(android.R.color.transparent);// clear out the old image for a recycled view
        Picasso.with(getContext()).load(tweet.getUser().getProfileImageUrl()).into(IvProfileImage);
        // 5. Return the view to be inserted into the list
        */
        // 4.Populate the data into the template view using the data object
        viewHolder.tvUserName.setText(tweet.getUser().getScreenName());
        viewHolder.tvBody.setText(tweet.getBody());
        viewHolder.IvProfileImage.setImageResource(android.R.color.transparent);// clear out the old image for a recycled view
        Picasso.with(getContext()).load(tweet.getUser().getProfileImageUrl()).into(viewHolder.IvProfileImage);
        // 5. Return the completed view to render on screen
        return convertView;
    }
}

