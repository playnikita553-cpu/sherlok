package com.shcherbakovnikita.sherlok

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.shcherbakovnikita.sherlok.databinding.OtvetPodtverdityBinding

class podtverdityotvetik : AppCompatActivity() {

    private lateinit var binding: OtvetPodtverdityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = OtvetPodtverdityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bundle = intent.extras
        val selectedItem = bundle?.getInt(otveta_vibor.ANIMAL)

        val images = listOf<Int>(R.drawable.lisa, R.drawable.pesik, R.drawable.barsik)
        val animals = resources.getStringArray(R.array.animals)
        if (selectedItem != null) {
            
            binding.titleAnimal.text = animals[selectedItem]
            binding.imageAnimal.setImageResource(images[selectedItem])
        }

       
        binding.btnYes.setOnClickListener {
            returnAnswer(selectedBtn = 1)
        }
        binding.btnNo.setOnClickListener {
            returnAnswer(selectedBtn = 2)
        }
    }


    companion object {
        const val CHOOSE = "choose"
    }


    private fun returnAnswer(selectedBtn: Int) {
        val intent = Intent()
        intent.putExtra(CHOOSE, selectedBtn)
        setResult(RESULT_OK, intent)
        finish()
    }
    }
