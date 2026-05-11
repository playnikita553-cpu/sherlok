package com.shcherbakovnikita.sherlok

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.shcherbakovnikita.sherlok.databinding.ViborOtvetaBinding

class otveta_vibor : AppCompatActivity() {

    private lateinit var binding: ViborOtvetaBinding

    companion object {
        const val ANIMAL = "animal"
        const val RESULT_VIEW = 1
    }

    var animals: Array<String> = arrayOf()
    var selectedItem = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ViborOtvetaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        animals = resources.getStringArray(R.array.animals)
        binding.first.text = animals[0]
        binding.seconds.text = animals[1]
        binding.third.text = animals[2]

        binding.first.setOnClickListener {
            selectedItem = 0
            chekAnswer(selectedItem)
        }
        binding.seconds.setOnClickListener {
            selectedItem = 1
            chekAnswer(selectedItem)
        }
        binding.third.setOnClickListener {
            selectedItem = 2
            chekAnswer(selectedItem)
        }
    }

    private fun chekAnswer(selectedItem: Int) {
        val intent = Intent(this, podtverdityotvetik::class.java)
        intent.putExtra(ANIMAL, selectedItem)
        startActivityForResult(intent, RESULT_VIEW)
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?,
    ) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RESULT_VIEW) {
            val chooseBtn = data?.getIntExtra(podtverdityotvetik.CHOOSE, -1)

            if (chooseBtn == 1) {
                if (selectedItem == 2) {
                    binding.result.setTextColor(resources.getColor(R.color.green))
                    binding.result.text = resources.getString(R.string.BtnYes, binding.third.text)
                } else {
                    binding.result.setTextColor(resources.getColor(R.color.redBtn))
                    binding.result.text = resources.getString(R.string.BtnNo, animals[selectedItem])
                }
            }

            if (chooseBtn == 2) {
                if (binding.third.isChecked) {
                    binding.result.setTextColor(resources.getColor(R.color.green))
                    binding.result.text = resources.getString(R.string.noBtnNo, binding.third.text)
                } else if (binding.seconds.isChecked) {
                    binding.result.setTextColor(resources.getColor(R.color.redBtn))
                    binding.result.text =
                        resources.getString(R.string.noBtnYes, binding.seconds.text)
                } else {
                    binding.result.setTextColor(resources.getColor(R.color.redBtn))
                    binding.result.text = resources.getString(R.string.noBtnYes, binding.first.text)
                }
            }
        }
    }
}