package com.candralab.listview;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ListView;

public class CountryActivity extends Activity {

	private ListView lvcountry;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.country_activity);

		lvcountry = (ListView) findViewById(R.id.listCountry);

		List<Country> lsCountry = new ArrayList<Country>();

		lsCountry
				.add(new Country(BitmapFactory.decodeResource(getResources(),
						R.drawable.indonesia), "Indonesia", "Jakarta",
						"246 juta jiwa "));
		lsCountry.add(new Country(BitmapFactory.decodeResource(getResources(),
				R.drawable.saudi), "Saudi Arabia ", "Riyadh", "28 juta jiwa"));
		lsCountry.add(new Country(BitmapFactory.decodeResource(getResources(),
				R.drawable.inggris), "Inggris", "London", "53 juta jiwa"));
		lsCountry.add(new Country(BitmapFactory.decodeResource(getResources(),
				R.drawable.us), "Amerika serikat", "Washingthon DC",
				"313 juta jiwa"));
		lsCountry.add(new Country(BitmapFactory.decodeResource(getResources(),
				R.drawable.china), "China", "Beijing", "1.35 Milyar jiwa"));

		CountryAdapter adapter = new CountryAdapter(this, lsCountry);
		lvcountry.setAdapter(adapter);
	}
}