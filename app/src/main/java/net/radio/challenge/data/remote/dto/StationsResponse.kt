package net.radio.challenge.data.remote.dto

import com.squareup.moshi.Json


data class StationsResponse (

  @field:Json(name ="systemName"  ) val systemName  : String?              = null,
  @field:Json(name ="title"       ) val title       : String?              = null,
  @field:Json(name ="playables"   ) val playables   : ArrayList<Playable> = arrayListOf(),
  @field:Json(name ="displayType" ) val displayType : String?              = null,
  @field:Json(name ="count"       ) val count       : Int?                 = null,
  @field:Json(name ="offset"      ) val offset      : Int?                 = null,
  @field:Json(name ="totalCount"  ) val totalCount  : Int?                 = null

)