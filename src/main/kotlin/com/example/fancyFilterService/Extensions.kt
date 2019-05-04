package com.example.fancyFilterService

import org.postgresql.geometric.PGpoint

// https://postgis.net/docs/ST_Point.html
fun PGpoint.longitude() = this.x

fun PGpoint.latitude() = this.y
