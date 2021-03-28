package com.yasinkacmaz.jetflix.ui.main.moviedetail.image

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Image(val url: String, val voteCount: Int): Parcelable
