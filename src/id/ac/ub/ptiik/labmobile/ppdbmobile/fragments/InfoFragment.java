package id.ac.ub.ptiik.labmobile.ppdbmobile.fragments;

import id.ac.ub.ptiik.labmobile.ppdbmobile.GPSTracker;
import id.ac.ub.ptiik.labmobile.ppdbmobile.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class InfoFragment extends Fragment {

	//private double longitude, latitude;
	private TextView fragmentInfoText;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v =  inflater.inflate(R.layout.fragment_info, null, false);
		this.fragmentInfoText = (TextView) v.findViewById(R.id.fragmentInfoText);
		return v;
	}
	
	@Override
	public void onStart() {
		

		LokasiDialogFragment lokasiDialogFragment = new LokasiDialogFragment();
		lokasiDialogFragment.show(getFragmentManager(), "getlokasifromuser");

		
		
		
		/*
		GPSTracker gpsTrackerService = new GPSTracker(getActivity());
		if ( gpsTrackerService.canGetLocation() ) {
			this.longitude = gpsTrackerService.getLongitude();
			this.latitude = gpsTrackerService.getLatitude();
		} else {
			gpsTrackerService.showSettingsAlert();
		}
		this.fragmentInfoText.setText("User's location:\nLongitude: " 
				+ this.longitude + "\nLatitude: " + this.latitude);
		gpsTrackerService.stopUsingGPS();
		*/
		super.onStart();
		
	}

}
