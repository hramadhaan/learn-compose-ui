package com.hramadhaan.udemylearncompose.domain.model

data class User(
    val id: String?,
    val userId: String,
    val fullName: String,
    val avatarUrl: String,
    val quote: String,
    val profession: String,
) {
    fun toMap(): MutableMap<String, Any> {
        return mutableMapOf(
            "user_id" to this.userId,
            "full_name" to this.fullName,
            "avatar_url" to this.avatarUrl,
            "quote" to this.quote,
            "profession" to this.profession,
        )
    }
}