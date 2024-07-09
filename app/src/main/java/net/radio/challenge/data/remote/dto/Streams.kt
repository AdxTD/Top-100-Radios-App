package com.example.example

import com.google.gson.annotations.SerializedName


data class Streams (

  @SerializedName("url"           ) var url           : String? = null,
  @SerializedName("contentFormat" ) var contentFormat : String? = null,
  @SerializedName("status"        ) var status        : String? = null

)