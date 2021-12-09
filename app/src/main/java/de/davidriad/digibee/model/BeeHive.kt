package de.davidriad.digibee.model

data class BeeHive(
    var name:String,
    var id:String,
    var condition: String,
    var temperature: Int,
    var humidity: Int,
    var weather: String,
    var wind: String,
    var queenBeeHealth: String,
)