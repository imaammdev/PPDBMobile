package id.ac.ub.ptiik.labmobile.ppdbmobile;

import id.ac.ub.ptiik.labmobile.ppdbmobile.fragments.InfoFragment;
import id.ac.ub.ptiik.labmobile.ppdbmobile.fragments.LocationFragment;
import id.ac.ub.ptiik.labmobile.ppdbmobile.fragments.MessagingFragment;
import id.ac.ub.ptiik.labmobile.ppdbmobile.fragments.SearchFragment;
import id.ac.ub.ptiik.labmobile.ppdbmobile.fragments.ShareFragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;

public class MainActivity extends FragmentActivity  {
	
	private FragmentTabHost mTabHost;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_main);
		
		mTabHost = (FragmentTabHost) this.findViewById(android.R.id.tabhost);
		mTabHost.setup(this, getSupportFragmentManager(), R.id.fragment_container);
		
        mTabHost.addTab(mTabHost.newTabSpec("Search").setIndicator("Search",
                getResources().getDrawable(R.drawable.ic_launcher)),
                SearchFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("Info").setIndicator("Info",
                getResources().getDrawable(R.drawable.ic_magnify)),
                   InfoFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("Messaging").setIndicator("Messaging",
                getResources().getDrawable(R.drawable.ic_magnify)),
                   MessagingFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("Location").setIndicator("Location",
                getResources().getDrawable(R.drawable.ic_magnify)),
                   LocationFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("Share").setIndicator("Share",
                getResources().getDrawable(R.drawable.ic_magnify)),
                   ShareFragment.class, null);
	}

}
