package com.test.saltside;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class LandingScreen extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_landing);
		
		ItemData item = (ItemData)getIntent().getSerializableExtra("item_data");
		
		TextView title = (TextView)findViewById(R.id.title);
		TextView description = (TextView)findViewById(R.id.description);
		ImageView image = (ImageView)findViewById(R.id.image);
		
		title.setText(item.getTitle());
		description.setText(item.getDescription());
		
		Picasso.with(this)
		   .load(item.getImageURL())
		   .into(image);
	}
}
