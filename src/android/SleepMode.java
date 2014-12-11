package org.apache.cordova.plugin.sleep;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.LOG;

import org.json.JSONArray;
import org.json.JSONException;

import android.content.Intent;

public class SleepMode extends CordovaPlugin {
	protected static final String TAG = "SleepModePlugin";

	@Override
	public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
		if (action.equals("sleepApp")) {
			this.initialize(callbackContext, args);
			return true;
		} else {
			LOG.e(TAG, "Called invalid action: "+ action);
			return false; 
		}
	}

	private void initialize(final CallbackContext callbackContext, final JSONArray args) {
		cordova.getActivity().runOnUiThread(new Runnable () {
			public void run () {
				try {
					Intent i = new Intent(Intent.ACTION_MAIN);
                	i.addCategory(Intent.CATEGORY_HOME);
                	cordova.getActivity().startActivity(i);
                	callbackContext.success();
				} catch (Exception e) {
					LOG.e(TAG, "Exception occurred: ".concat(e.getMessage()));
					callbackContext.error("Exception");
				}
			}
		});
	}

}