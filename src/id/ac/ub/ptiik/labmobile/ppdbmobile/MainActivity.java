package id.ac.ub.ptiik.labmobile.ppdbmobile;

import id.ac.ub.ptiik.labmobile.ppdbmobile.base.MainMenu;
import id.ac.ub.ptiik.labmobile.ppdbmobile.base.NavigationMenu;
import id.ac.ub.ptiik.labmobile.ppdbmobile.fragments.InfoFragment;
import id.ac.ub.ptiik.labmobile.ppdbmobile.fragments.LocationFragment;
import id.ac.ub.ptiik.labmobile.ppdbmobile.fragments.MessagingFragment;
import id.ac.ub.ptiik.labmobile.ppdbmobile.fragments.SearchFragment;
import id.ac.ub.ptiik.labmobile.ppdbmobile.fragments.ShareFragment;
import id.ac.ub.ptiik.labmobile.ppdbmobile.interfaces.MainMenuInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;

public class MainActivity extends FragmentActivity
	implements MainMenuInterface {
		
	NavigationMenu navigationMenu;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_main);
		ViewGroup mainMenuContainerView = (ViewGroup) this.findViewById(R.id.mainMenuContainer);
		this.navigationMenu = new NavigationMenu(getApplicationContext(), mainMenuContainerView, this);
	}

	@Override
	public void onMainMenuClicked(MainMenu menu) {
		this.navigationMenu.activate(menu);
		Fragment newFragment;
		switch(menu.id) {
		case 1:
			newFragment = new InfoFragment();
			break;
		case 2:
			newFragment = new MessagingFragment();
			break;
		case 3:
			newFragment = new LocationFragment();
			break;
		case 4:
			newFragment = new ShareFragment();
			break;
		case 0:
		default:	
			newFragment = new SearchFragment();
			break;
		}
		this.getSupportFragmentManager()
			.beginTransaction()
			.replace(R.id.mainContentContainer, newFragment)
			.commit();
	}

}
