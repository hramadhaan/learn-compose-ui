package com.hramadhaan.udemylearncompose.util

data class LoadingState(val status: Status, val message: String? = null) {
    companion object {
        val IDLE = LoadingState(status = Status.IDLE)
        val LOADING = LoadingState(status = Status.LOADING)
        val FAILED = LoadingState(status = Status.FAILED)
        val SUCCESS = LoadingState(status = Status.SUCCESS)
    }

    enum class Status {
        SUCCESS,
        FAILED,
        LOADING,
        IDLE
    }
}