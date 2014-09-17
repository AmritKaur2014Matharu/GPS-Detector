var GPSDetection = {
		checkGPSService:function (gpsSuccessCallback, gpsErrorCallback, arguments){
			cordova.exec( gpsSuccessCallback, gpsErrorCallback, "GPSDetection" , "GPS-SERVICE" , arguments);
		}
};
module.exports = GPSDetection;

