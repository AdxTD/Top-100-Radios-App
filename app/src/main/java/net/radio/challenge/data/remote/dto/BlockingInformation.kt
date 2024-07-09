package com.example.example

import com.google.gson.annotations.SerializedName


data class BlockingInformation (

  @SerializedName("isBlocked"   ) var isBlocked   : Boolean?          = null,
  @SerializedName("isBlockedIn" ) var isBlockedIn : ArrayList<String> = arrayListOf()

)