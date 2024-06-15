package com.example.darkmode

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.darkmode.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreferences : SharedPreferences = getSharedPreferences("myPref", MODE_PRIVATE)
        val editor : SharedPreferences.Editor = sharedPreferences.edit()
        val isDarkModeOn = sharedPreferences.getBoolean("isDarkModeOn",false)
        if (isDarkModeOn){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            binding.btnDarkLight.setText("Disable Dark Mode")
        }else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            binding.btnDarkLight.setText("Enable Dark Mode")
        }
        binding.btnDarkLight.setOnClickListener {
           if (isDarkModeOn){
               AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
               editor.putBoolean("isDarkModeOn",false)
               editor.apply()
               binding.btnDarkLight.setText("Enable Dark Mode")
           }else{
               AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
               editor.putBoolean("isDarkModeOn",true)
               editor.apply()
               binding.btnDarkLight.setText("Disable Dark Mode")
           }
        }
    }
}
