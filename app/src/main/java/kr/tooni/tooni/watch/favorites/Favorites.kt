package kr.tooni.tooni.watch.favorites

data class Favorites (
    var no: Int,
    var platform: String,
    var thumbnail: String,
    var title: String,
    var writer: String,
    var genre: String,
    var rate: Double,
    var count: Int
)