package com.kweboakye.spacextestapp.shared.data.database

import android.content.Context
import com.kweboakye.spacextestapp.shared.data.SpaceXTestAppDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(SpaceXTestAppDatabase.Schema, context, "SpaceXTestAppDatabase.db")
    }
}