package com.oliverperez.blockbusterchallenge.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.oliverperez.blockbusterchallenge.model.LoginPrefs
import com.oliverperez.blockbusterchallenge.R
import com.oliverperez.blockbusterchallenge.ui.dashboard.MovieDashboardActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private val presenter = LoginActivityPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loginButton.setOnClickListener {
            presenter.didTapLoginButton(textFieldName, textFieldPassword)
        }
        textFieldName.requestFocus()
    }

    fun showMovieDashboard() {
        startActivity(Intent(this, MovieDashboardActivity::class.java))
    }
}