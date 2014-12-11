var exec = require('cordova/exec');
var Sleep = function () {};
Sleep.prototype.goToSleep = function(successCallback, errorCallback) {
    return exec(successCallback, errorCallback, 'Sleep', 'sleepApp', []);
};
var sleep = new Sleep();
module.exports = sleep;