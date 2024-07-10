package net.radio.challenge.data.remote.dto

import com.squareup.moshi.Json


data class Playable (

  val city                : String?              = null,
  val country             : String?              = null,
  val genres              : List<String>         = arrayListOf(),
  val id                  : String?              = null,
  val lastModified        : Int?                 = null,
  val logo100x100         : String?              = null,
  val logo300x300         : String?              = null,
  val logo630x630         : String?              = null,
  val name                : String?              = null,
  val topics              : List<String>         = arrayListOf(),
  val streams             : List<Streams>        = arrayListOf(),
  val hasValidStreams     : Boolean?             = null,
  val adParams            : String?              = null,
  val type                : String?              = null,
  val seoRelevantIn       : List<String>         = arrayListOf(),
  val blockingInformation : BlockingInformation? = BlockingInformation()

)