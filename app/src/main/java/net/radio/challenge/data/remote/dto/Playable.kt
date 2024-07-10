package net.radio.challenge.data.remote.dto

import com.squareup.moshi.Json


data class Playable (

  @field:Json(name = "city"                ) val city                : String?              = null,
  @field:Json(name = "country"             ) val country             : String?              = null,
  @field:Json(name = "genres"              ) val genres              : ArrayList<String>    = arrayListOf(),
  @field:Json(name = "id"                  ) val id                  : String?              = null,
  @field:Json(name = "lastModified"        ) val lastModified        : Int?                 = null,
  @field:Json(name = "logo100x100"         ) val logo100x100         : String?              = null,
  @field:Json(name = "logo300x300"         ) val logo300x300         : String?              = null,
  @field:Json(name = "logo630x630"         ) val logo630x630         : String?              = null,
  @field:Json(name = "name"                ) val name                : String?              = null,
  @field:Json(name = "topics"              ) val topics              : ArrayList<String>    = arrayListOf(),
  @field:Json(name = "streams"             ) val streams             : ArrayList<Streams>   = arrayListOf(),
  @field:Json(name = "hasValidStreams"     ) val hasValidStreams     : Boolean?             = null,
  @field:Json(name = "adParams"            ) val adParams            : String?              = null,
  @field:Json(name = "type"                ) val type                : String?              = null,
  @field:Json(name = "seoRelevantIn"       ) val seoRelevantIn       : ArrayList<String>    = arrayListOf(),
  @field:Json(name = "blockingInformation" ) val blockingInformation : BlockingInformation? = BlockingInformation()

)