package id.ac.ub.ptiik.labmobile.ppdbmobile;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;

public class MainActivity extends Activity implements TabListener  {
	
	ActionBar actionBar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_main);
		this.actionBar = this.getActionBar();
		this.actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		Tab tab1 = this.actionBar.newTab().setText("Ab").setTag(1);
		Tab tab2 = this.actionBar.newTab().setText("Bc").setTag(2);
		Tab tab3 = this.actionBar.newTab().setText("Cd").setTag(3);
		
		tab1.setTabListener(this);
		tab2.setTabListener(this);
		tab3.setTabListener(this);
		LayoutInflater inflater = (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);
		tab1.setCustomView(inflater.inflate(R.layout.tab_info, null));
		
		this.actionBar.addTab(tab1);
		this.actionBar.addTab(tab2);
		this.actionBar.addTab(tab3);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		Fragment fragment;
		int tabNo = Integer.valueOf(tab.getTag().toString());
		switch(tabNo){
			case 2:
			fragment = new LocationFragment();
			break;
			default:
				fragment = new InfoFragment();
				break;
		}
		ft.replace(R.id.fragment_container, fragment);
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

}
