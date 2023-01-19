package com.example.android.myrecipe

import android.os.Parcel
import android.os.Parcelable

data class Resep(
    val gambarMasakan: Int,
    val namaMasakan: String?,
    val asalDaerah: String?,
    val deskripsiMasakan: String?,
    val bahanMasakan: String?,
    val langkahPembuatan: String?,
    val videoId: String?
    ): Parcelable {
        constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()
        )

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeInt(gambarMasakan)
            parcel.writeString(namaMasakan)
            parcel.writeString(asalDaerah)
            parcel.writeString(deskripsiMasakan)
            parcel.writeString(bahanMasakan)
            parcel.writeString(langkahPembuatan)
            parcel.writeString(videoId)
        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<Resep> {
            override fun createFromParcel(parcel: Parcel): Resep {
                return Resep(parcel)
            }

            override fun newArray(size: Int): Array<Resep?> {
                return arrayOfNulls(size)
            }
        }
    }

