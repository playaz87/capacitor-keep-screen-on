import Foundation
import Capacitor

/**
 * Please read the Capacitor iOS Plugin Development Guide
 * here: https://capacitorjs.com/docs/plugins/ios
 */
@objc(KeepScreenOnPlugin)
public class KeepScreenOnPlugin: CAPPlugin {
    private let implementation = KeepScreenOn()

    @objc func echo(_ call: CAPPluginCall) {
        let value = call.getString("value") ?? ""
        call.resolve([
            "value": implementation.echo(value)
        ])
    }
    
    @objc func enable(_ call: CAPPluginCall) {
        UIApplication.shared.isIdleTimerDisabled = true;
    }
    
    @objc func disable(_ call: CAPPluginCall) {
        UIApplication.shared.isIdleTimerDisabled = false;
    }
}
