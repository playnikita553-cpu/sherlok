package com.shcherbakovnikita.sherlok

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.shcherbakovnikita.sherlok.databinding.ActivityMainBinding  // Импорт binding
import com.shcherbakovnikita.sherlok.databinding.ViborOtvetaBinding

class MainActivity : AppCompatActivity() {

    // Объявляем переменную binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    binding.otvety.setOnClickListener()
        {
            val intent = Intent(this, otveta_vibor::class.java)
            startActivity(intent)
        }
    }

}