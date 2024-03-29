package com.kweboakye.spacextestapp.shared.data.database

import com.kweboakye.spacextestapp.shared.data.LaunchQueries
import com.kweboakye.spacextestapp.shared.data.RocketQueries
import com.kweboakye.spacextestapp.shared.data.SpaceXTestAppDatabase
import com.kweboakye.spacextestapp.shared.domain.model.Links
import com.kweboakye.spacextestapp.shared.domain.model.Rocket
import com.kweboakye.spacextestapp.shared.domain.model.RocketLaunch

class SpaceXRepository(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = SpaceXTestAppDatabase(databaseDriverFactory.createDriver())
    private val launchQueries: LaunchQueries = database.launchQueries
    private val rocketQueries: RocketQueries = database.rocketQueries

    internal fun clearDatabase() {
        launchQueries.transaction {
            launchQueries.removeAllLaunches()
            rocketQueries.removeAllRockets()
        }
    }

    internal fun getAllLaunches(): List<RocketLaunch> {
        return launchQueries.selectAllLaunchesInfo(::mapLaunchSelecting).executeAsList()
    }

    private fun mapLaunchSelecting(
        flightNumber: Long,
        missionName: String,
        launchYear: Int,
        rocketId: String,
        details: String?,
        launchSuccess: Boolean?,
        launchDateUTC: String,
        missionPatchUrl: String?,
        articleUrl: String?,
        rocket_id: String?,
        name: String?,
        type: String?
    ): RocketLaunch {
        return RocketLaunch(
            flightNumber = flightNumber.toInt(),
            missionName = missionName,
            launchYear = launchYear,
            details = details,
            launchDateUTC = launchDateUTC,
            launchSuccess = launchSuccess,
            rocket = Rocket(
                id = rocketId,
                name = name!!,
                type = type!!
            ),
            links = Links(
                missionPatchUrl = missionPatchUrl,
                articleUrl = articleUrl
            )
        )
    }

    internal fun createLaunches(launches: List<RocketLaunch>) {
        rocketQueries.transaction {
            launches.forEach { launch ->
                val rocket = rocketQueries.selectRocketById(launch.rocket.id).executeAsOneOrNull()
                if (rocket == null) {
                    insertRocket(launch)
                }

                insertLaunch(launch)
            }
        }
    }

    private fun insertRocket(launch: RocketLaunch) {
        rocketQueries.insertRocket(
            id = launch.rocket.id,
            name = launch.rocket.name,
            type = launch.rocket.type
        )
    }

    private fun insertLaunch(launch: RocketLaunch) {
        launchQueries.insertLaunch(
            flightNumber = launch.flightNumber.toLong(),
            missionName = launch.missionName,
            launchYear = launch.launchYear,
            rocketId = launch.rocket.id,
            details = launch.details,
            launchSuccess = launch.launchSuccess ?: false,
            launchDateUTC = launch.launchDateUTC,
            missionPatchUrl = launch.links.missionPatchUrl,
            articleUrl = launch.links.articleUrl
        )
    }
}
