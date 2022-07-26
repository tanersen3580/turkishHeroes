package com.tanersen.turkishheroes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    // Bir değişkene sınıfın içinden heryerden ulşmak için
    //onu kapsadığı alanın en dışında tanımlamak gereki
    //Bunun adı scope(kapsam) func içinde tanımladığımız değişkenleri
    //burada tanımla.
    private var name=""
    private var age:Int?=null //int olabilir ama başlangış değeri null
    private var job=""
    //private neden çünkü sade bu class içinden ulaşılmasını istiyorum.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun makeHeroes(view:View) {
        name = nameText.text.toString()
        age=ageText.text.toString().toIntOrNull()
        //Int' e çevirebilirse çevirir, çeviremezse null atar.
        job=jobText.text.toString()
        //Null safety koyalım
        if (age==null){
        resultText.text="Doğru yaşı giriniz."
        }
        else {
            val heroes=turkishHeroes(name,age!!,job)
            //!! null olamaz anlamına gelir.
            resultText.text="İsmi :${heroes.name} Yaşı : ${heroes.age} Mesleği : ${heroes.job}"

        }
    }

    }