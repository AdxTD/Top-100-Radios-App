package net.radio.challenge.data.remote.dto

import com.squareup.moshi.Json


data class BlockingInformation (

  @field:Json(name ="isBlocked"   ) val isBlocked   : Boolean?          = null,
  @field:Json(name ="isBlockedIn" ) val isBlockedIn : List<String> = arrayListOf()

)