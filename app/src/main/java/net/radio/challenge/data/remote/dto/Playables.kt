package com.example.example

import com.google.gson.annotations.SerializedName


data class Playables (

  @SerializedName("city"                ) var city                : String?              = null,
  @SerializedName("country"             ) var country             : String?              = null,
  @SerializedName("genres"              ) var genres              : ArrayList<String>    = arrayListOf(),
  @SerializedName("id"                  ) var id                  : String?              = null,
  @SerializedName("lastModified"        ) var lastModified        : Int?                 = null,
  @SerializedName("logo100x100"         ) var logo100x100         : String?              = null,
  @SerializedName("logo300x300"         ) var logo300x300         : String?              = null,
  @SerializedName("logo630x630"         ) var logo630x630         : String?              = null,
  @SerializedName("name"                ) var name                : String?              = null,
  @SerializedName("topics"              ) var topics              : ArrayList<String>    = arrayListOf(),
  @SerializedName("streams"             ) var streams             : ArrayList<Streams>   = arrayListOf(),
  @SerializedName("hasValidStreams"     ) var hasValidStreams     : Boolean?             = null,
  @SerializedName("adParams"            ) var adParams            : String?              = null,
  @SerializedName("type"                ) var type                : String?              = null,
  @SerializedName("seoRelevantIn"       ) var seoRelevantIn       : ArrayList<String>    = arrayListOf(),
  @SerializedName("blockingInformation" ) var blockingInformation : BlockingInformation? = BlockingInformation()

)