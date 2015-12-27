package com.test.saltside;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

@SuppressWarnings("deprecation")
public class MainScreen extends ActionBarActivity {
	ItemAdapter adapter;
	ArrayList<ItemData> items;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ListView listView = (ListView) findViewById(R.id.listv);
		items = new ArrayList<ItemData>();
		adapter = new ItemAdapter(this, items);
		listView.setAdapter(adapter);
	}

	public void onStart() {
		super.onStart();
		// Create request queue
		RequestQueue requestQueue = Volley.newRequestQueue(this);
		// Create json array request
		JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
				Request.Method.POST,
				"https://gist.githubusercontent.com/maclir/f715d78b49c3b4b3b77f/raw/8854ab2fe4cbe2a5919cea97d71b714ae5a4838d/items.json", // "http://www.gtwebsolutions.net/kent/getoutlet.php",
				new Response.Listener<JSONArray>() {
					public void onResponse(JSONArray jsonArray) {
						// Successfully download json
						// So parse it and populate the listview
						for (int i = 0; i < jsonArray.length(); i++) {
							try {
								JSONObject jsonObject = jsonArray
										.getJSONObject(i);
								items.add(new ItemData(jsonObject.getString("title"), 
										jsonObject.getString("description"), 
										jsonObject.getString("image")));
							} catch (JSONException e) {
								e.printStackTrace();
							}
						}
						adapter.notifyDataSetChanged();
					}
				}, new Response.ErrorListener() {
					@Override
					public void onErrorResponse(VolleyError volleyError) {
						Log.e("Error", "Unable to parse json array");
					}
				});
		// add json array request to the request queue
		requestQueue.add(jsonArrayRequest);
	}

}
