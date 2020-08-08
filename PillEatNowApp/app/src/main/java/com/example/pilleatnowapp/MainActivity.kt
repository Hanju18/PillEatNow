package com.example.pilleatnowapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var lastTimeBackPressed:Long=-1500
        // 이전 버튼 두 번 눌러서 종료하기
        fun onBackPressed() {
            // (현재 버튼 누른 시간-이전에 버튼 누른 시간) <=1.5초일 때 동작
            if(System.currentTimeMillis()-lastTimeBackPressed<=1500)
                finish()
            lastTimeBackPressed=System.currentTimeMillis()
            Toast.makeText(this,"이전 버튼을 한 번 더 누르면 종료됩니다",Toast.LENGTH_SHORT).show()
        }
    }
}