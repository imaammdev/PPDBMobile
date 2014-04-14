package id.ac.ub.ptiik.labmobile.ppdbmobile.task;

import id.ac.ub.ptiik.labmobile.ppdbmobile.interfaces.HelloInterface;
import id.ac.ub.ptiik.labmobile.utility.Rest;
import android.os.AsyncTask;

public class HelloTask extends AsyncTask<String, Void, String> {

	HelloInterface yangMrosesHasil;
	
	public HelloTask(HelloInterface yangMrosesHasil) {
		this.yangMrosesHasil = yangMrosesHasil;
	}
	
	@Override
	protected String doInBackground(String... args) {
		this.yangMrosesHasil.onStartProses();
		String URL = args[0];
		
		String result = Rest.getInstance().get(URL).getResponseText();
		this.yangMrosesHasil.onProses();
		return result;
	}

	
	@Override
	protected void onPostExecute(String result) {
		this.yangMrosesHasil.onFinish(result);
		super.onPostExecute(result);
	}

}
