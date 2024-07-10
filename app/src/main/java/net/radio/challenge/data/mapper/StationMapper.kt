package net.radio.challenge.data.mapper

import net.radio.challenge.data.remote.dto.Playable
import net.radio.challenge.domain.model.StationModel

fun Playable.toStationModel(): StationModel {
    return StationModel(
        id = id,
        name = name,
        country = country,
        city = city,
        genres = genres,
        topics = topics,
        logo300x300 = logo300x300
    )
}