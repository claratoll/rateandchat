package com.example.rateandchat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {


    lateinit var auth : FirebaseAuth
    lateinit var emailView : EditText
    lateinit var passwordView : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //gömmer Action Bar längst upp
        supportActionBar?.hide()

        //login to app
        auth = Firebase.auth

        emailView = findViewById(R.id.loginEditEmailText)
        passwordView = findViewById(R.id.loginEditPasswordText)

        val signInButton = findViewById<Button>(R.id.logInButton)
        signInButton.setOnClickListener {
            logIn()
        }
    }

    fun logIn() {
        val email = emailView.text.toString()
        val password = passwordView.text.toString()

        if (email.isEmpty() || password.isEmpty()) {
            return
        }

        // calculate length of the entered password and compare
        if (password.length < 6) {
            throw ArithmeticException("Password is too short")
        } else{
            println("Strong password")}


        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener{ task ->
            if (task.isSuccessful){
                Log.d("!!!", "login success")
                Toast.makeText(this, "Login success", Toast.LENGTH_SHORT).show()

            } else {
                Log.d("!!!", "user not created ${task.exception}")
                Toast.makeText(this, "Try again", Toast.LENGTH_SHORT).show()

            }
        }
    }
}