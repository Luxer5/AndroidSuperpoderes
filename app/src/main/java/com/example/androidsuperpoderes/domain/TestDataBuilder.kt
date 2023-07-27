package com.example.androidsuperpoderes.domain

import com.example.androidsuperpoderes.domain.model.HeroModel

class TestDataBuilder() {
    var id = "Iddelhero"
    var name = "nombre Heroe"
    var photoUrl = ""
    var description = "Descripcion del hero"
    var numElements: Int = 15
    var favorite = false

    fun withName(name: String): TestDataBuilder {
        this.name =  name
        return  this
    }
    fun withPhotoUrl(photoUrl: String): TestDataBuilder {
        this.photoUrl =  photoUrl
        return  this
    }
    fun withNumElements(numElements: Int): TestDataBuilder {
        this.numElements =  numElements
        return  this
    }
    fun withDescription(description: String): TestDataBuilder{
        this.description = description
        return this
    }

    fun buildList():List<HeroModel>{
        val list = mutableListOf<HeroModel>()
        for(i in 0 .. numElements){
            list.add(HeroModel(id,name, photoUrl, description, favorite))
        }
        return list.toList()
    }

    fun buildSingle():HeroModel = HeroModel(id,name, photoUrl, description, favorite)

}