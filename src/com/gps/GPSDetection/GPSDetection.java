package com.gps.GPSDetection;

import java.io.Console;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;

import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.util.Log;

public class GPSDetection extends CordovaPlugin {
	String gpsService =  "GPS-SERVICE";
	static final int  CHECKGPS = 1; 
	@Override
	public boolean execute(String action, JSONArray args,
			CallbackContext callbackContext) throws JSONException {
		// TODO Auto-generated method stub
	
		if(action.equals(gpsService) ){
			 LocationManager manager = (LocationManager) this.cordova.getActivity().getSystemService(Context.LOCATION_SERVICE);
			 boolean statusOfGPS = manager.isProviderEnabled(LocationManager.GPS_PROVIDER);
			 if(!statusOfGPS){
				 this.cordova.getActivity().startActivityForResult(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS), CHECKGPS);
			 }
		}
		
		return super.execute(action, args, callbackContext);
	}



}
