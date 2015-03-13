/*
The MIT License (MIT)

Copyright (c) 2014

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package org.tbyrne.cordova.plugins.screenppi;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;

import org.json.JSONArray;
import org.json.JSONException;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.util.Log;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.content.Context;

public class ScreenPPI extends CordovaPlugin {

    private static final String TAG = "ScreenPPI";

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {

        Log.d(TAG, "execute action: " + action);

        // Route the Action
        if (action.equals("getPPI")) {
            Context context = this.cordova.getActivity().getApplicationContext();
            WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            DisplayMetrics dm = new DisplayMetrics();
            wm.getDefaultDisplay().getMetrics(dm);
            int dpiInt = Math.round(dm.densityDpi / dm.density);
            callbackContext.success(dpiInt);
            return true;
        }

        // Action not found
        callbackContext.error("action not recognised");
        return false;
    }
}