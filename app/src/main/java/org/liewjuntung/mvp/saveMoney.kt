package org.liewjuntung.mvp

import android.content.SharedPreferences
import android.preference.PreferenceManager

fun sharedPreference(): SharedPreferences {
    return PreferenceManager.getDefaultSharedPreferences(MainApplication.appContext)
}

actual fun saveMoney(amount: Int) {
    sharedPreference().edit().putInt(AMOUNT_KEY, amount).apply()
}

actual fun showMoney(): Int {
    return sharedPreference().getInt(AMOUNT_KEY, 0)
}