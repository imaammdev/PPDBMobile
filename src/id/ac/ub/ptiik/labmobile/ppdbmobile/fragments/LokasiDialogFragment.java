package id.ac.ub.ptiik.labmobile.ppdbmobile.fragments;

import id.ac.ub.ptiik.labmobile.ppdbmobile.R;
import id.ac.ub.ptiik.labmobile.ppdbmobile.interfaces.HelloInterface;
import id.ac.ub.ptiik.labmobile.ppdbmobile.task.HelloTask;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

public class LokasiDialogFragment extends DialogFragment implements OnClickListener, HelloInterface {
	
	private View v;
	private TextView infoLokasiText;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		this.v = inflater.inflate(R.layout.fragment_lokasi, null);
		this.infoLokasiText = (TextView) this.v.findViewById(R.id.fragmentInputLokasiText);
		
		
		this.infoLokasiText.setText("Halooo...");
		
		
		this.infoLokasiText.setOnClickListener(this);
		
		return v;
	}
	
	@Override
	public void onClick(View arg0) {
		Toast.makeText(getActivity(), "Halo juga", Toast.LENGTH_SHORT).show();
		
		HelloTask helloTask = new HelloTask(this);
		helloTask.execute("http://ub.ac.id");
		
	}

	@Override
	public void onProses() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(String result) {
		Toast.makeText(getActivity(), result, Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onStartProses() {
		// TODO Auto-generated method stub
		
	}
}
