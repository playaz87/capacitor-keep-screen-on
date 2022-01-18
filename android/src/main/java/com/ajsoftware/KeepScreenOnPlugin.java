package com.ajsoftware;

import android.view.WindowManager;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "KeepScreenOn")
public class KeepScreenOnPlugin extends Plugin {

    private KeepScreenOn implementation = new KeepScreenOn();

    @PluginMethod
    public void echo(PluginCall call) {
        String value = call.getString("value");

        JSObject ret = new JSObject();
        ret.put("value", implementation.echo(value));
        call.resolve(ret);
    }

    @PluginMethod
    public void enable(PluginCall call) {
        try {
            getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
            call.resolve();
        } catch (Exception e) {
            call.reject(e.getLocalizedMessage());
        }
    }

    @PluginMethod
    public void disable(PluginCall call) {
        try {
            getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
            call.resolve();;
        } catch (Exception e) {
            call.reject(e.getLocalizedMessage());
        }
    }
}
