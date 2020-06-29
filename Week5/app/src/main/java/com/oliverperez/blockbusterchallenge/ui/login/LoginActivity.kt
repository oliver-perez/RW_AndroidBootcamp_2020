package com.oliverperez.blockbusterchallenge.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.oliverperez.blockbusterchallenge.model.LoginPrefs
import com.oliverperez.blockbusterchallenge.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loginButton.setOnClickListener {
            validateInput()
        }
    }

    private fun validateInput() {
        if (textFieldName.text.count() > 1 && textFieldPassword.text.count() > 3) {
            LoginPrefs.saveUserLoginStatus(true)
            finish()
        } else {
            // TODO: Show error alert
        }
    }
}