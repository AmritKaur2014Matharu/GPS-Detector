GPS-Detector
============
GPS Detector plugin will check if gps location service is enabled or not. It will open the location setting page for enabling this service

SETUP
============
cordova plugin add https://github.com/AmritKaur2014Matharu/GPS-Detector.git

GPSDetection.checkGPSService
============
This function is used to check if gps service is enable or not on user's device.
GPSDetection.checkGPSService(gpsSuccessHandler, gpsErrorHandler, [{}]);

gpsSuccessHandler: This function will be called when GPS Service enable or disable process is executed successfully.

gpsErrorHandler: This function will be called when error occurs while the GPS service enable or disable process is being executed. 

Last Parameter: No parameter is required. Just pass the same as mentioned above.

Cordova Version
============
Cordova version supported >= 3.0
Tested on Samsung Note 3

Platform Supported
============
Android

USAGE
============
After adding the plugin via CLI, add the following java code in main activity class of your android project
```js

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, intent);
		Log.e("onActivityResult", requestCode +" "+"hello ");
		if(requestCode ==1){
			 LocationManager manager = (LocationManager) this.getActivity().getSystemService(Context.LOCATION_SERVICE);
			 boolean statusOfGPS = manager.isProviderEnabled(LocationManager.GPS_PROVIDER);
			 if(!statusOfGPS){
				 new AlertDialog.Builder(this)
				    .setTitle("GPS Service")
				    .setMessage("Are you sure you don't want to enable GPS?")
				    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
				        public void onClick(DialogInterface dialog, int which) { 
				           Log.e("GPS SERVICE", "No GPS Service..."); 
				        }
				     })
				    .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
				        public void onClick(DialogInterface dialog, int which) { 
				        	startActivityForResult(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS), 1);   // do nothing
				        }
				     })
				    .setIcon(android.R.drawable.ic_dialog_alert)
				     .show();
			 }
		}
	} 

```
Example
============
When device ready event is called, call the following function in javascript file to send request to native java code to open the setting page for GPS location service.
          
```js
 document.addEventListener('deviceready', function(){
            	GPSDetection.checkGPSService(gpsSuccessHandler, gpsErrorHandler, [{}]);
            });

```
