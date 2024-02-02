package com.example.mvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm.R
import com.example.mvvm.databinding.ActivityMainBinding
import com.example.mvvm.viewmodel.CalculatorViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private lateinit var calculatorViewModel: CalculatorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        calculatorViewModel=ViewModelProvider(this).get(CalculatorViewModel::class.java)

        binding.button.setOnClickListener{

            val num1=binding.text1.text.toString().toIntOrNull()?:0
            val num2=binding.text2.text.toString().toIntOrNull()?:0

            val result=calculatorViewModel.calculatorSum(num1, num2)
            binding.textView3.text="${result.sum}"
        }


    }
}