package com.moon.android.moonplayer;

import java.util.Timer;
import java.util.TimerTask;

import com.nostra13.universalimageloader.core.DisplayImageOptions;

import com.nostra13.universalimageloader.core.ImageLoader;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class OSDAd extends OSD {

	private AdView mAdView;
	private View mParentView;
	private ImageView mAdImg;
	private TextView mTvSec;
	private DisplayImageOptions mOptions;

	public OSDAd(View parentView) {
		setProperity(PROPERITY_LEVEL_6);
		mParentView = parentView;
		mAdView = (AdView) mParentView.findViewById(R.id.ad_view);
		mAdImg = (ImageView) mAdView.findViewById(R.id.ad_osd_img);
		mTvSec = (TextView) mAdView.findViewById(R.id.ad_osd_sec);
		initDisplayImageOptions();
		Timer time = new Timer();
		time.schedule(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				mhandler.sendEmptyMessage(0);
			}
		}, 1000, 1000);
	}

	@Override
	public void setVisibility(int visibility) {
		// TODO Auto-generated method stub
		mAdView.setVisibility(visibility);
	}

	public int CountSec;
	// Timer time;
	
   public boolean isTime=true;
	public void SetAd(String adurl, int sec) {

		CountSec = sec;
		mTvSec.setText(CountSec + "");
		isTime=true;
		ImageLoader.getInstance().displayImage(adurl, mAdImg, mOptions);

	}
    public void SetAdVideo(int sec){
    	
    }
	Handler mhandler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			if(isTime){
				mTvSec.setText(CountSec + "");
				CountSec--;
				if (CountSec <= 0) {
					setVisibility(View.GONE);
					isTime=false;
				}
			}
			
			super.handleMessage(msg);
		}

	};

	private void initDisplayImageOptions() {
		mOptions = new DisplayImageOptions.Builder()
				.showImageOnLoading(R.drawable.pic_loading)
				.showImageForEmptyUri(R.drawable.pic_loading)
				.showImageOnFail(R.drawable.pic_loading).cacheInMemory(true)
				.cacheOnDisk(true).considerExifParams(true)

				// .displayer(new RoundedBitmapDisplayer(20))
				.build();
	}

}
