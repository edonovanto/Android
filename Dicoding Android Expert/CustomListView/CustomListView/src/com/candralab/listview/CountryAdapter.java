package com.candralab.listview;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CountryAdapter extends BaseAdapter {
	private Context mContext;
	private List<Country> mListInfo;

	public CountryAdapter(Context context, List<Country> list) {
		mContext = context;
		mListInfo = list;

	}

	@Override
	public int getCount() {
		return mListInfo.size();
	}

	@Override
	public Object getItem(int pos) {
		return mListInfo.get(pos);
	}

	@Override
	public long getItemId(int pos) {
		return pos;
	}

	@Override
	public View getView(int pos, View convertView, ViewGroup parent) {
		// get selected entry
		Country entry = mListInfo.get(pos);

		// inflating list view layout if null
		if (convertView == null) {
			LayoutInflater inflater = LayoutInflater.from(mContext);
			convertView = inflater.inflate(R.layout.country_row, null);
		}

		// set image icon
		ImageView imgIcon = (ImageView) convertView.findViewById(R.id.imgIcon);
		imgIcon.setImageBitmap(entry.getFlagIcon());

		// set nama
		TextView tvName = (TextView) convertView.findViewById(R.id.tvNama);
		tvName.setText(entry.getNama());

		TextView tvPhone = (TextView) convertView.findViewById(R.id.tvIbukota);
		tvPhone.setText(entry.getIbukota());

		TextView tvJumlahPenduduk = (TextView) convertView
				.findViewById(R.id.tvJumlahPenduduk);
		tvJumlahPenduduk.setText(entry.getJumlahPenduduk());

		return convertView;
	}

}
