package com.kweboakye.spacextestapp.shared.data.network


import com.kweboakye.spacextestapp.shared.domain.model.ResultOrError
import com.kweboakye.spacextestapp.shared.domain.model.RocketLaunch
import com.kweboakye.spacextestapp.shared.domain.model.toResultOrErrorFailure
import com.kweboakye.spacextestapp.shared.domain.model.toResultOrErrorSuccess
import io.ktor.client.HttpClient
import io.ktor.client.features.ClientRequestException
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.get
import io.ktor.client.features.HttpResponseValidator
import io.ktor.client.features.RedirectResponseException
import io.ktor.client.features.ResponseException
import io.ktor.client.features.ServerResponseException
import kotlinx.serialization.json.Json

class SpaceXApi {
    private val httpClient = HttpClient {
        install(JsonFeature) {
            val json = Json { ignoreUnknownKeys = true }
            serializer = KotlinxSerializer(json)
        }
        HttpResponseValidator {
            validateResponse { response ->
                val statusCode = response.status.value
                when (statusCode) {
                    in 300..399 -> throw RedirectResponseException(response)
                    in 400..499 -> throw ClientRequestException(response)
                    in 500..599 -> throw ServerResponseException(response)
                }

                if (statusCode >= 600) {
                    throw ResponseException(response)
                }
            }
        }
    }

    suspend fun getAllLaunches(): ResultOrError<List<RocketLaunch>> {
        return runCatching {
        httpClient.get<List<RocketLaunch>>(LAUNCHES_ENDPOINT).toResultOrErrorSuccess()
        }.getOrElse { exception: Throwable ->
            (exception as Exception).toResultOrErrorFailure()
         }
    }

    companion object {
        private const val LAUNCHES_ENDPOINT = "https://api.spacexdata.com/v3/launches"
    }
}
