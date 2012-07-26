package com.dexxtr;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gcm.GCMRegistrar;

public class MainActivity extends Activity {

	private static final String TAG = "MainActivity";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.main);
	    
	    new Thread() {
	        @Override
	        public void run() {
            	registerGSM();
	        }
	    }.start();
	}
	
	private void registerGSM() {
		GCMRegistrar.checkDevice(this);
	    GCMRegistrar.checkManifest(this);
	    
	    final String regId = GCMRegistrar.getRegistrationId(this);
        if (regId.equals("")) {
	    	GCMRegistrar.register(this, getString(R.string.gcm_project_id));
	    } else {
    		Log.v(TAG, "GCM already registered");
	    }
	}
    
    @Override
    protected void onDestroy() {
    	GCMRegistrar.unregister(this);
        GCMRegistrar.onDestroy(this);
        super.onDestroy();
    }
}
