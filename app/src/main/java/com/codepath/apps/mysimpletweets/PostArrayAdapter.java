package com.codepath.apps.mysimpletweets;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import com.codepath.apps.mysimpletweets.models.Post;

import java.util.List;

public class PostArrayAdapter extends ArrayAdapter<Post> {
    private static class ViewHolder {
        EditText Lvtext;
        Button btsave;
       // Button btcancel;
    }

    public PostArrayAdapter(Context context, List<Post> post) {
        super(context, 0, post);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 1. Get the tweet
        Post post = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag
        // 2. Find or inflate the template
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_tweets, parent, false);
            // 3. Find the subviews to fill with data in the
            viewHolder.Lvtext = (EditText) convertView.findViewById(R.id.Lvtext);
            viewHolder.btsave = (Button) convertView.findViewById(R.id.btsave);
            //viewHolder.btcancel = (Button) convertView.findViewById(R.id.btcancel);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.Lvtext.setText(post.getText());
        viewHolder.btsave.setText(post.getSend());
        // 5. Return the completed view to render on screen
        return convertView;
    }
}
