package com.dexxtr.gcm;

import android.content.Context;

import com.dexxtr.R;
import com.google.android.gcm.GCMBroadcastReceiver;

public class GCMReceiver extends GCMBroadcastReceiver {

	@Override
	protected String getGCMIntentServiceClassName(Context context) {
		return context.getString(R.string.gcm_service_class);
	}
}
