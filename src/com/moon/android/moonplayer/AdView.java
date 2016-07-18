package com.moon.android.moonplayer;

import com.moon.android.moonplayer.util.Logger;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

@SuppressLint("NewApi")
public class AdView extends LinearLayout {

	private Logger logger = Logger.getLogger();

	private TextView mTextPrompt;

	public AdView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(context);
	}

	public AdView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public AdView(Context context) {
		this(context, null);
	}

	private void init(Context context) {
	
		View view = LayoutInflater.from(context).inflate(
				R.layout.osd_ad, this);
		
	}

}
