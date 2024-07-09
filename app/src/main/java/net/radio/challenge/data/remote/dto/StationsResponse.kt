package com.example.example

import com.google.gson.annotations.SerializedName


data class StationsResponse (

  @SerializedName("systemName"  ) var systemName  : String?              = null,
  @SerializedName("title"       ) var title       : String?              = null,
  @SerializedName("playables"   ) var playables   : ArrayList<Playables> = arrayListOf(),
  @SerializedName("displayType" ) var displayType : String?              = null,
  @SerializedName("count"       ) var count       : Int?                 = null,
  @SerializedName("offset"      ) var offset      : Int?                 = null,
  @SerializedName("totalCount"  ) var totalCount  : Int?                 = null

)