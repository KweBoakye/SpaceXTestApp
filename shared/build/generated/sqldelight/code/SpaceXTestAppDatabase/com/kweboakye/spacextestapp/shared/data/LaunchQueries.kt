package com.kweboakye.spacextestapp.shared.data

import com.squareup.sqldelight.Query
import com.squareup.sqldelight.Transacter
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String

interface LaunchQueries : Transacter {
  fun <T : Any> selectAllLaunchesInfo(mapper: (
    flightNumber: Long,
    missionName: String,
    launchYear: Int,
    rocketId: String,
    details: String?,
    launchSuccess: Boolean?,
    launchDateUTC: String,
    missionPatchUrl: String?,
    articleUrl: String?,
    id: String?,
    name: String?,
    type: String?
  ) -> T): Query<T>

  fun selectAllLaunchesInfo(): Query<SelectAllLaunchesInfo>

  fun insertLaunch(
    flightNumber: Long,
    missionName: String,
    launchYear: Int,
    rocketId: String,
    details: String?,
    launchSuccess: Boolean?,
    launchDateUTC: String,
    missionPatchUrl: String?,
    articleUrl: String?
  )

  fun removeAllLaunches()
}
