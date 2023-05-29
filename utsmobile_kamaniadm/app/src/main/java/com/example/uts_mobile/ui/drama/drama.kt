package com.example.uts_mobile.ui.drama

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.time.Year

@Parcelize
data class drama (
    var name: String = "",
    var detail: String = "",
    var photo: Int = 0
)
    : Parcelable {
    companion object {
        const val EXTRA_FILM = "extra_film"
    }
}