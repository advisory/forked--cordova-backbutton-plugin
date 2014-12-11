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
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		if (action.equals("sleepApp")) {
			try {				
				Intent i = new Intent(Intent.ACTION_MAIN);
                i.addCategory(Intent.CATEGORY_HOME);
                this.cordova.getActivity().startActivity(i);
				
			} catch (Exception e) {
				LOG.e(TAG, "Exception occurred: ".concat(e.getMessage()));
				return false;
			}
			cordova.getActivity().runOnUiThread(new Runnable() {
     			public void run() {
         			callbackContext.success(); 
     			}
 			}
			return true;
		}
		LOG.e(TAG, "Called invalid action: "+ action);
		return false;  
	}

}
