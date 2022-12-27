package com.example.redditnews.room

import androidx.room.TypeConverter
import com.example.redditnews.pojo.ChildrenItem
import com.example.redditnews.pojo.MediaEmbed
import com.example.redditnews.pojo.SecureMediaEmbed
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class Converters {

    //Convert ListOfChildren To String
    @TypeConverter
    fun fromListOfChildrenToString(value: List<ChildrenItem>?): String? {
        return Gson().toJson(value)
    }

    //Convert String To ListOfChildren
    @TypeConverter
    fun fromStringToListOfChildren(s: String?): List<ChildrenItem>? {
        return Gson().fromJson<List<ChildrenItem>?>(s, object : TypeToken<List<ChildrenItem>?>() {}.type
        )
    }

    //Convert MediaEmbed To String
    @TypeConverter
    fun fromMediaEmbedToString(value: MediaEmbed?): String? {
        return Gson().toJson(value)
    }

    //Convert String To MediaEmbed
    @TypeConverter
    fun fromStringToMediaEmbed(s: String?): MediaEmbed? {
        return Gson().fromJson<MediaEmbed?>(s, object : TypeToken<MediaEmbed?>() {}.type
        )
    }

    //Convert SecureMediaEmbed To String
    @TypeConverter
    fun fromSecureMediaEmbedToString(value: SecureMediaEmbed?): String? {
        return Gson().toJson(value)
    }

    //Convert String To SecureMediaEmbed
    @TypeConverter
    fun fromStringToSecureMediaEmbed(s: String?): SecureMediaEmbed? {
        return Gson().fromJson<SecureMediaEmbed?>(s, object : TypeToken<SecureMediaEmbed?>() {}.type
        )
    }


}