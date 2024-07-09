package net.radio.challenge.data.remote.dto

import com.squareup.moshi.Json


data class Streams (

  @field:Json(name ="url"           ) val url           : String? = null,
  @field:Json(name ="contentFormat" ) val contentFormat : String? = null,
  @field:Json(name ="status"        ) val status        : String? = null

)