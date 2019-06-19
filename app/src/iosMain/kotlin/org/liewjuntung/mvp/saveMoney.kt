package org.liewjuntung.mvp

import platform.Foundation.NSUserDefaults
import platform.darwin.NSInteger

actual fun saveMoney(amount: Int) {
    NSUserDefaults.standardUserDefaults.setInteger(amount as NSInteger, AMOUNT_KEY)
}

actual fun showMoney(): Int {
    return NSUserDefaults.standardUserDefaults.integerForKey(AMOUNT_KEY).toInt()
}