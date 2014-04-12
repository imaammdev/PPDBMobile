package id.ac.ub.ptiik.labmobile.ppdbmobile.base;

import id.ac.ub.ptiik.labmobile.ppdbmobile.R;
import id.ac.ub.ptiik.labmobile.ppdbmobile.interfaces.MainMenuInterface;

import java.util.ArrayList;

import android.app.Service;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.TableLayout.LayoutParams;

public class NavigationMenu implements OnClickListener {
	ArrayList<MainMenu> menuList;
	Context context;
	MainMenuInterface menuInterface;
	
	@SuppressWarnings("deprecation")
	public NavigationMenu(Context context, ViewGroup containerView, MainMenuInterface menuInterface) {
		this.context = context;
		this.menuList = new ArrayList<MainMenu>();
		this.menuInterface = menuInterface;
		
		MainMenu menuSearch = new MainMenu(0, "Pencarian");
		MainMenu menuInfo = new MainMenu(1, "Info PPDB");
		MainMenu menuMessaging = new MainMenu(2, "Pesan Anda");
		MainMenu menuShare = new MainMenu(3, "Bagikan");
		
		menuMessaging.state = MainMenu.STATE_ACTIVE;
		
		this.menuList.add(menuSearch);
		this.menuList.add(menuInfo);
		this.menuList.add(menuMessaging);
		this.menuList.add(menuShare);
		
		for(MainMenu menu: menuList) {
			View v = ((LayoutInflater) context.getSystemService(Service.LAYOUT_INFLATER_SERVICE))
					.inflate(R.layout.tab, null);
			((TextView) v.findViewById(R.id.tabLabel)).setText(menu.label);
			if(menu.state == MainMenu.STATE_ACTIVE)
				v.findViewById(R.id.tabWrapper).setBackgroundDrawable(context.getResources().getDrawable(R.drawable.button_secondary_bg_selector));
			v.setTag(menu.id);
			v.setOnClickListener(this);
			menu.viewHolder = v;
			
			containerView.addView(v, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT, 1));
		}
	}
	
	@SuppressWarnings("deprecation")
	public void activate(MainMenu menu) {
		for(MainMenu m : this.menuList) { 
			
			if(m.id == menu.id) {
				menu.activate();
				menu.viewHolder.findViewById(R.id.tabWrapper).setBackgroundDrawable(this.context.getResources().getDrawable(R.drawable.button_bg_selector));
			} else {
				m.deactivate();
				m.viewHolder.findViewById(R.id.tabWrapper).setBackgroundDrawable(this.context.getResources().getDrawable(R.drawable.button_secondary_bg_selector));
			}
			
		}
				
	}

	@Override
	public void onClick(View v) {
		int index = (Integer) v.getTag();
		this.menuInterface.onMainMenuClicked(this.menuList.get(index));
	}
}
