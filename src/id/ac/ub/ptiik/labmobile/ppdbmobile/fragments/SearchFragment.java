package id.ac.ub.ptiik.labmobile.ppdbmobile.fragments;

import id.ac.ub.ptiik.labmobile.ppdbmobile.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SearchFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_search, null, false);
		return v;
	}
}
