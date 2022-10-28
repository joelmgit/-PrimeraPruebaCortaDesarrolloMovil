package com.apppruebaa.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName="capitulo")
data class Capitulo(
    @PrimaryKey(autoGenerate = true)
    val idCapitulo: Int,
    @ColumnInfo(name="titulo")
    val titulo: String?,
    @ColumnInfo(name="revision")
    val revision: Int?,
    @ColumnInfo(name="precio")
    val precio: Double?,
) : Parcelable