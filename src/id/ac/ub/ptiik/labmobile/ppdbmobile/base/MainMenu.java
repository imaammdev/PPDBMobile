package id.ac.ub.ptiik.labmobile.ppdbmobile.base;

import android.view.View;

public class MainMenu {
	
	public int id;
	public String label;
	public int iconResource;
	public int state = MainMenu.STATE_NORMAL;
	public View viewHolder;
	
	public static final int STATE_NORMAL = 0;
	public static final int STATE_ACTIVE = 1;
	
	public MainMenu(int id, String label) {
		this.id = id;
		this.label = label;
	}
	
	public void activate() {
		this.state = MainMenu.STATE_ACTIVE;
	}
	
	public void deactivate() {
		this.state = MainMenu.STATE_NORMAL;
	}
}
