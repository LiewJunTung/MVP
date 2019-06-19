package org.liewjuntung.mvp

import platform.Foundation.NSNumber
import platform.Foundation.NSUserDefaults

actual fun saveMoney(amount: Int) {
    val money = amount as NSNumber
    val defaults = NSUserDefaults.standardUserDefaults
    defaults.setInteger(money.integerValue, AMOUNT_KEY)
    defaults.synchronize()

}

actual fun showMoney(): Int {
    return NSUserDefaults.standardUserDefaults().integerForKey(AMOUNT_KEY).toInt()
}