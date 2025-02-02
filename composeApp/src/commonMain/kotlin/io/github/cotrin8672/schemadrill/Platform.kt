package io.github.cotrin8672.schemadrill

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform