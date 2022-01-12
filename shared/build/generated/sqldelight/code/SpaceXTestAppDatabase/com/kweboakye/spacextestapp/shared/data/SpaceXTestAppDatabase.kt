package com.kweboakye.spacextestapp.shared.data

import com.kweboakye.spacextestapp.shared.data.shared.newInstance
import com.kweboakye.spacextestapp.shared.data.shared.schema
import com.squareup.sqldelight.Transacter
import com.squareup.sqldelight.db.SqlDriver

interface SpaceXTestAppDatabase : Transacter {
  val launchQueries: LaunchQueries

  val rocketQueries: RocketQueries

  companion object {
    val Schema: SqlDriver.Schema
      get() = SpaceXTestAppDatabase::class.schema

    operator fun invoke(driver: SqlDriver): SpaceXTestAppDatabase =
        SpaceXTestAppDatabase::class.newInstance(driver)}
}
