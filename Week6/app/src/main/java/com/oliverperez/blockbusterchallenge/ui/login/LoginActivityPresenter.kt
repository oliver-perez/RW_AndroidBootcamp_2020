package com.oliverperez.blockbusterchallenge.ui.login

import android.view.textclassifier.TextLinks
import android.widget.TextView
import com.oliverperez.blockbusterchallenge.model.LoginPrefs
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivityPresenter(private val view: LoginActivity) {

    fun didTapLoginButton(textFieldName: TextView, textFieldPassword: TextView) {
        validateInput(textFieldName, textFieldPassword)
    }

    private fun validateInput(textFieldName: TextView, textFieldPassword: TextView) {
        if (textFieldName.text.count() > 1 && textFieldPassword.text.count() > 3) {
            LoginPrefs.saveUserLoginStatus(true)
            view.showMovieDashboard()
            view.finish()
        } else {
            // TODO: Show error alert
        }
    }
}