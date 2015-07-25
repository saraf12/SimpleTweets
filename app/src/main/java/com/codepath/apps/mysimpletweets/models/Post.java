package com.codepath.apps.mysimpletweets.models;

import org.json.JSONException;
import org.json.JSONObject;

public class Post {
    public String getText() {
        return text;
    }

    private String text;
    private int send;
    private int cancel;
    // private sender_id sender_id;
    // private screen_name screen_name;


    public int getSend() {
        return send;
    }

    public static Post fromJSON(JSONObject jsonObject) {
        Post post = new Post();
        try {
            post.text = jsonObject.getString("text");
            post.send = jsonObject.getInt("sender_id");


            // tweet.user = User.fromJSON(jsonObject.getJSONObject("user"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // Return the tweet object
        return post;
    }
}
