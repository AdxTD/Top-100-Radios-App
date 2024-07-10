package net.radio.challenge.data.remote.dto

import com.squareup.moshi.Json


data class StationsResponse (

  val systemName  : String?              = null,
  val title       : String?              = null,
  val playables   : List<Playable>,
  val displayType : String?              = null,
  val count       : Int?                 = null,
  val offset      : Int?                 = null,
  val totalCount  : Int?                 = null

)