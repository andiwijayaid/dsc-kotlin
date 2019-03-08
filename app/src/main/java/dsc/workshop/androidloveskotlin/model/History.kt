package dsc.workshop.androidloveskotlin.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class History(
    val poinA: String,
    val poinB: String
) : Parcelable