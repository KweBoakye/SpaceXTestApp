package com.kweboakye.spacextestapp.shared.data.database

import com.kweboakye.spacextestapp.shared.data.SpaceXTestAppDatabase
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(SpaceXTestAppDatabase.Schema, "SpaceXTestAppDatabase.db")
    }
}