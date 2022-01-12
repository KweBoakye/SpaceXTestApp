package com.kweboakye.spacextestapp.shared.data

import com.squareup.sqldelight.Query
import com.squareup.sqldelight.Transacter
import kotlin.Any
import kotlin.String

interface RocketQueries : Transacter {
  fun <T : Any> selectRocketById(id: String, mapper: (
    id: String,
    name: String,
    type: String
  ) -> T): Query<T>

  fun selectRocketById(id: String): Query<Rocket>

  fun insertRocket(
    id: String,
    name: String,
    type: String
  )

  fun removeAllRockets()
}
