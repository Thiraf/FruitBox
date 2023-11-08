package com.example.fruitbox

import android.os.Parcel
import android.os.Parcelable

data class Fruit(
    val image: Int,
    val name: String,
    val color: String,
    val explanation: String
) : Parcelable {
    // Konstruktor sekunder untuk membaca data dari Parcel
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    )

    // Menulis data ke Parcel
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(image)
        parcel.writeString(name)
        parcel.writeString(color)
        parcel.writeString(explanation)
    }

    // Fungsi ini digunakan untuk membuat objek Parcel dari objek Fruit
    override fun describeContents(): Int {
        return 0
    }

    // Companion object untuk membuat objek Fruit dari Parcel
    companion object CREATOR : Parcelable.Creator<Fruit> {
        override fun createFromParcel(parcel: Parcel): Fruit {
            return Fruit(parcel)
        }

        // Membuat array objek Fruit dengan ukuran tertentu
        override fun newArray(size: Int): Array<Fruit?> {
            return arrayOfNulls(size)
        }
    }
}
