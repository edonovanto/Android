package com.candralab.listview;


import android.graphics.Bitmap;

public class Country {
	private Bitmap flagIcon;

	private String nama;
	private String ibukota;
	private String jumlahPenduduk;
	
	public Country(Bitmap fi, String n, String i, String jp) {
		flagIcon = fi;
		nama = n;
		ibukota = i;
		jumlahPenduduk = jp;
	}
	
	public Bitmap getFlagIcon() {
		return flagIcon;
	}

	public void setFlagIcon(Bitmap flagIcon) {
		this.flagIcon = flagIcon;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getIbukota() {
		return ibukota;
	}

	public void setIbukota(String ibukota) {
		this.ibukota = ibukota;
	}

	public String getJumlahPenduduk() {
		return jumlahPenduduk;
	}

	public void setJumlahPenduduk(String jumlahPenduduk) {
		this.jumlahPenduduk = jumlahPenduduk;
	}

	
	
}
