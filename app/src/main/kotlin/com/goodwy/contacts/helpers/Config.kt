package com.goodwy.contacts.helpers

import android.content.Context
import androidx.core.content.edit
import com.goodwy.commons.helpers.BaseConfig
import com.goodwy.commons.helpers.ON_CONTACT_CLICK
import com.goodwy.commons.helpers.SHOW_TABS

class Config(context: Context) : BaseConfig(context) {
    companion object {
        fun newInstance(context: Context) = Config(context)
    }

    var autoBackupContactSources: Set<String>
        get() = prefs.getStringSet(AUTO_BACKUP_CONTACT_SOURCES, setOf())!!
        set(autoBackupContactSources) = prefs.edit {
            remove(AUTO_BACKUP_CONTACT_SOURCES).putStringSet(AUTO_BACKUP_CONTACT_SOURCES, autoBackupContactSources)
        }

    var showTabs: Int
        get() = prefs.getInt(SHOW_TABS, ALL_TABS_MASK)
        set(showTabs) = prefs.edit { putInt(SHOW_TABS, showTabs) }

    var onContactClick: Int
        get() = prefs.getInt(ON_CONTACT_CLICK, ON_CLICK_VIEW_CONTACT)
        set(onContactClick) = prefs.edit { putInt(ON_CONTACT_CLICK, onContactClick) }

    var onFavoriteClick: Int
        get() = prefs.getInt(ON_FAVORITE_CLICK, ON_CLICK_VIEW_CONTACT)
        set(onContactClick) = prefs.edit { putInt(ON_FAVORITE_CLICK, onContactClick) }

    //Swipe
    var swipeRightAction: Int
        get() = prefs.getInt(SWIPE_RIGHT_ACTION, SWIPE_ACTION_CALL)
        set(swipeRightAction) = prefs.edit { putInt(SWIPE_RIGHT_ACTION, swipeRightAction) }

    var swipeLeftAction: Int
        get() = prefs.getInt(SWIPE_LEFT_ACTION, SWIPE_ACTION_MESSAGE)
        set(swipeLeftAction) = prefs.edit { putInt(SWIPE_LEFT_ACTION, swipeLeftAction) }

    var swipeVibration: Boolean
        get() = prefs.getBoolean(SWIPE_VIBRATION, true)
        set(swipeVibration) = prefs.edit { putBoolean(SWIPE_VIBRATION, swipeVibration) }

    var swipeRipple: Boolean
        get() = prefs.getBoolean(SWIPE_RIPPLE, false)
        set(swipeRipple) = prefs.edit { putBoolean(SWIPE_RIPPLE, swipeRipple) }
}
