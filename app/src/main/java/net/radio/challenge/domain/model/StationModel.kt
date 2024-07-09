package net.radio.challenge.domain.model

import com.squareup.moshi.Json

data class StationModel(
    val id:         String? = null,
    val name:       String? = null,
    val country:    String? = null,
    val city:       String? = null,
    val genres:     ArrayList<String> = arrayListOf(),
    val topics:     ArrayList<String> = arrayListOf(),
    val logo300x300:String? = null
)
