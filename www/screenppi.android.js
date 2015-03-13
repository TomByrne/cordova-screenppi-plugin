var exec = require('cordova/exec');

var onSuccess = function(val){
	screen.screenPPI = val;
}
exec(onSuccess, null, "ScreenPPI", "getPPI", []);