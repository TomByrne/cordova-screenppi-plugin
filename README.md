#Cordova Screen PPI Plugin

Cordova plugin to access the screen PPI.

Currently only supports Android & iOS.

Heavily based on Yoik's [Screen Orientation API](https://github.com/yoik/cordova-yoik-screenorientation) plugin.

__The plugin adds the following to the screen object:__

__screenPPI__
The average PPI for the screen

##Install

cordova plugin add org.tbyrne.cordova.plugins.screenppi

###Source
https://github.com/yoik/cordova-yoik-screenorientation


##Usage

    console.log( "Screen is "+(window.outerWidth / screen.screenPPI)+" inches wide" );


Pull requests welcome.
