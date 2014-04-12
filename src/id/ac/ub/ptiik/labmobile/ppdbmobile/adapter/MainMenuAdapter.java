package id.ac.ub.ptiik.labmobile.ppdbmobile.adapter;

import id.ac.ub.ptiik.labmobile.ppdbmobile.R;
import id.ac.ub.ptiik.labmobile.ppdbmobile.base.MainMenu;

import java.util.ArrayList;

import android.app.Service;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class MainMenuAdapter extends BaseAdapter {

	ArrayList<MainMenu> menuList;
	Context c;
	
	public MainMenuAdapter(Context c, ArrayList<MainMenu> menuList) {
		this.menuList = menuList;
		this.c = c;
	}
	
	@Override
	public int getCount() {
		if(this.menuList != null)
			return this.menuList.size();
		else return 0;
	}

	@Override
	public Object getItem(int position) {
		return this.menuList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return this.menuList.get(position).id;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) this.c.getSystemService(Service.LAYOUT_INFLATER_SERVICE);
		View v = inflater.inflate(R.layout.tab, null);
		return v;
	}

}
