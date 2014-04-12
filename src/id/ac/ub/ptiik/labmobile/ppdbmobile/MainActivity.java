package id.ac.ub.ptiik.labmobile.ppdbmobile;

import id.ac.ub.ptiik.labmobile.ppdbmobile.base.MainMenu;
import id.ac.ub.ptiik.labmobile.ppdbmobile.base.NavigationMenu;
import id.ac.ub.ptiik.labmobile.ppdbmobile.fragments.InfoFragment;
import id.ac.ub.ptiik.labmobile.ppdbmobile.fragments.LocationFragment;
import id.ac.ub.ptiik.labmobile.ppdbmobile.fragments.MessagingFragment;
import id.ac.ub.ptiik.labmobile.ppdbmobile.fragments.SearchFragment;
import id.ac.ub.ptiik.labmobile.ppdbmobile.fragments.ShareFragment;
import id.ac.ub.ptiik.labmobile.ppdbmobile.interfaces.MainInterface;
import id.ac.ub.ptiik.labmobile.ppdbmobile.interfaces.MainMenuInterface;
import android.app.Service;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

public class MainActivity extends FragmentActivity
	implements MainMenuInterface, MainInterface, OnClickListener {
		
	NavigationMenu navigationMenu;
	TextView pageTitleText;
	ViewGroup actionBarView;
	ViewGroup mainMenuContainerView;
	RelativeLayout settingButton, backButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE); 
		this.setContentView(R.layout.activity_main);
		
		this.mainMenuContainerView = (ViewGroup) this.findViewById(R.id.mainMenuContainer);
		this.pageTitleText = (TextView) this.findViewById(R.id.mainPageTitle);
		this.actionBarView = (ViewGroup) this.findViewById(R.id.actionBar);
		this.navigationMenu = new NavigationMenu(getApplicationContext(), mainMenuContainerView, this);
		
	}

	@Override
	public void onMainMenuClicked(MainMenu menu) {
		this.navigationMenu.activate(menu);
		try {
			((ViewGroup) this.settingButton.getParent()).removeView(this.settingButton);
		} catch (Exception e) {}
		try {
			((ViewGroup) this.backButton.getParent()).removeView(this.backButton);
		} catch (Exception e) {}
		
		Fragment newFragment;
		String title = "PPBD Mobile";
		switch(menu.id) {
		case 1:
			newFragment = new InfoFragment();
			title = "Info PPDB";
			this.addSettingButton(this);
			break;
		case 2:
			newFragment = new MessagingFragment();
			title = "Pesan Anda";
			this.addBackButton(this);
			break;
		case 3:
			newFragment = new LocationFragment();
			title = "Lokasi";
			break;
		case 4:
			newFragment = new ShareFragment();
			title = "Bagikan";
			break;
		case 0:
		default:	
			newFragment = new SearchFragment();
			title = "Pencarian";
			break;
		}
		this.getSupportFragmentManager()
			.beginTransaction()
			.replace(R.id.mainContentContainer, newFragment)
			.commit();
		this.setPageTitle(title);
	}

	public void setPageTitle(String title) {
		this.pageTitleText.setText(title);
	}
	
	public void addSettingButton(View.OnClickListener listener) {
		this.settingButton = (RelativeLayout) ((LayoutInflater) this.getSystemService(Service.LAYOUT_INFLATER_SERVICE))
				.inflate(R.layout.view_button_setting, null);
		this.settingButton.setOnClickListener(listener);
		this.actionBarView.addView(settingButton);
		LayoutParams params = (LayoutParams) this.settingButton.getLayoutParams();
		params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
		params.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE);
		this.settingButton.setLayoutParams(params);
	}

	@Override
	public void addBackButton(OnClickListener listener) {
		this.backButton = (RelativeLayout) ((LayoutInflater) this.getSystemService(Service.LAYOUT_INFLATER_SERVICE))
				.inflate(R.layout.view_button_back, null);
		this.backButton.setOnClickListener(listener);
		this.actionBarView.addView(backButton);
		LayoutParams params = (LayoutParams) this.backButton.getLayoutParams();
		params.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
		params.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE);
		this.backButton.setLayoutParams(params);
	}
	
	@Override
	public void onClick(View v) {
		switch(v.getId()) {
		case R.id.action_settings:
			break;
		}
	}

	

}
