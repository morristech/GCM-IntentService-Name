package com.dexxtr.gcm;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.google.android.gcm.GCMBaseIntentService;

public class GCMService extends GCMBaseIntentService {

	private static final String TAG = "GCMService";
	
	public GCMService() {
		super();
	}
	
	@Override
	protected void onRegistered(Context context, String regId) {
		Log.i(TAG, "Device registered: regId= " + regId);
	}

	@Override
	protected void onUnregistered(Context context, String regId) {
		Log.i(TAG, "Device unregistered");
	}

	@Override
	protected void onMessage(Context context, Intent intent) {
		Log.i(TAG, "Received message");
	}

	@Override
	protected void onDeletedMessages(Context context, int total) {
		Log.i(TAG, "Received deleted messages notification, count: " + total);
	}

	@Override
	public void onError(Context context, String errorId) {
		Log.i(TAG, "Received error: " + errorId);
	}

	@Override
	protected boolean onRecoverableError(Context context, String errorId) {
		Log.i(TAG, "Received recoverable error: " + errorId);
		return super.onRecoverableError(context, errorId);
	}
}
