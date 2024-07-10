package net.radio.challenge.domain.model

import com.squareup.moshi.Json

data class StationModel(
    val id:         String? = null,
    val name:       String? = null,
    val country:    String? = null,
    val city:       String? = null,
    val genres:     List<String> = arrayListOf(),
    val topics:     List<String> = arrayListOf(),
    val logo300x300:String? = null
)
