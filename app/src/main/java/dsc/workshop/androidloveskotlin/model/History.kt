package dsc.workshop.androidloveskotlin.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class History(
    var poinA: Int,
    var poinB: Int
) : Parcelable