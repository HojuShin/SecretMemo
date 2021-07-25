package com.exam.secretmemo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main)




        val editTextEmail = findViewById<EditText>(R.id.editTextTextEmailAddress)
        val editTextPassword = findViewById<EditText>(R.id.memotext)

        findViewById<Button>(R.id.login_button).setOnClickListener {
            val emailText = editTextEmail.text.toString()
            val passwordText = editTextPassword.text.toString()

            if (emailText == "abc123@naver.com" && passwordText == "123456789") {
                Log.d("", "통과!")
                val intent = Intent(this, MemoActivity::class.java)
                startActivity(intent);
                finish(); //현재 액티비티 X
            } else if (emailText != "abc123@naver.com" && passwordText == "123456789") {
                Log.d("", "이메일이 올바르지 않습니다.")
            } else if (emailText == "abc123@naver.com" && passwordText != "123456789") {
                Log.d("", "비밀번호가 틀렸어요. 다시 입력해주세요")
                Toast.makeText(this, "비밀번호가 틀렸어요. 다시 입력해주세요", Toast.LENGTH_SHORT).show()
            } else {
                Log.d("", "이메일과 비밀번호가 올바르지 않습니다.")
            }
        }


    }
}