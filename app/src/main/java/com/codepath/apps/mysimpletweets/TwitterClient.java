package com.codepath.apps.mysimpletweets;

import android.content.Context;

import com.codepath.oauth.OAuthBaseClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.scribe.builder.api.Api;
import org.scribe.builder.api.TwitterApi;

/*
 * 
 * This is the object responsible for communicating with a REST API. 
 * Specify the constants below to change the API being communicated with.
 * See a full list of supported API classes: 
 *   https://github.com/fernandezpablo85/scribe-java/tree/master/src/main/java/org/scribe/builder/api
 * Key and Secret are provided by the developer site for the given API i.e dev.twitter.com
 * Add methods for each relevant endpoint in the API.
 * 
 * NOTE: You may want to rename this object based on the service i.e TwitterClient or FlickrClient
 * 
 */
public class TwitterClient extends OAuthBaseClient {
	public static final Class<? extends Api> REST_API_CLASS = TwitterApi.class; // Change this
	public static final String REST_URL = "https://api.twitter.com/1.1"; // Change this, base API URL
	public static final String REST_CONSUMER_KEY = "fImEK7OEjB7SEDfPhg82oCJGm";       // Change this
	public static final String REST_CONSUMER_SECRET = "BqM7BODpPPEzwPr3kduJlxUfA3Ww6RO3FLllyoZsHfb9Jw03tq"; // Change this
	public static final String REST_CALLBACK_URL = "oauth://cpsimpletweets"; // Change this (here and in manifest)

	public TwitterClient(Context context) {
		super(context, REST_API_CLASS, REST_URL, REST_CONSUMER_KEY, REST_CONSUMER_SECRET, REST_CALLBACK_URL);
	}


	// METHOD = ENDPOINTS

	// HomeTimeLine = Gets us the home time line
	// GET statuses/home_timeline.json
	// Count:25
	// since_id:1
	public void getHomeTimeline(AsyncHttpResponseHandler handler){
		String apiUrl = getApiUrl("statuses/home_timeline.json");
		// Specify the params
		RequestParams params = new RequestParams();
		params.put("Count", 25);
		params.put("ince_id", 1);
		// Execute the request
		getClient().get(apiUrl, params, handler);
	}

	int i=25;
	public void getHomeTimeline2(AsyncHttpResponseHandler handler){
		String apiUrl = getApiUrl("statuses/home_timeline.json");
		// Specify the params
		RequestParams params = new RequestParams();
		i=i+25;
		params.put("Count", i);
		params.put("ince_id", 1);
		// Execute the request
		getClient().get(apiUrl, params, handler);
	}

	// COMPOSE TWEET
	public void getpostdirectmessage(AsyncHttpResponseHandler handler){
		String apiUrl = getApiUrl("direct_messages/new.json");
		// Specify the params
		RequestParams params = new RequestParams();
		params.has("user_id");
		params.has("screen_name");
		params.add("text", String.valueOf(140));

		// Execute the request
		getClient().get(apiUrl, params, handler);
	}


	/* 1. Define the endpoint URL with getApiUrl and pass a relative path to the endpoint
	 * 	  i.e getApiUrl("statuses/home_timeline.json");
	 * 2. Define the parameters to pass to the request (query or body)
	 *    i.e RequestParams params = new RequestParams("foo", "bar");
	 * 3. Define the request method and make a call to the client
	 *    i.e client.get(apiUrl, params, handler);
	 *    i.e client.post(apiUrl, params, handler);
	 */
}