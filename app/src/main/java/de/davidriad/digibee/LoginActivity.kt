package de.davidriad.digibee

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.core.view.get
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        emailFocusLinstener()
        passwordFocusLinstener()

        loginButton.setOnClickListener { submitForm() }
    }

    private fun submitForm() {

        val validEmail = validEmail()
        val validPassword = validPassword()

        if (validEmail && validPassword)
        //resetForm()
            navigateForm()
        else
            invalidForm()
    }

    private fun navigateForm() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun invalidForm() {
        var message = ""
        if (emailContainer.helperText != null)
            message = "Email: " + emailContainer.helperText
        if (emailContainer.helperText != null)
            message += "\n\nPassword: Required"

        AlertDialog.Builder(this)
            .setTitle("Invalid Form")
            .setMessage(message)
            .setPositiveButton("okay") { _, _ ->
                //do nothing
            }
            .show()
    }

    private fun resetForm() {
        var message = "Email: " + emailEditText.text
        message += "\nPassword: " + passwordEditText.text

        AlertDialog.Builder(this)
            .setTitle("Form submitted")
            .setMessage(message)
            .setPositiveButton("Okay") { _, _ ->
                emailEditText.text = null
                passwordEditText.text = null

                emailContainer.helperText = getString(R.string.required)
                passwordContainer.helperText = getString(R.string.required)
            }
            .show()
    }

    private fun emailFocusLinstener() {
        emailEditText.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                //binding.emailContainer.helperText = validEmail()
            }
        }
    }

    private fun validEmail(): Boolean {
        val emailText = emailEditText.text.toString()
        /*if(!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()){
            return false
        }*/
        if (emailText == "admin") {
            return true
        }
        return false
    }

    private fun passwordFocusLinstener() {
        passwordEditText.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                //binding.emailContainer.helperText = validPassword()
            }
        }
    }

    //All of this is using for Sign-Up
    private fun validPassword(): Boolean {
        val passwordText = passwordEditText.text.toString()
        /*if(passwordText.length < 6){
            return false
        //return "Minimum 8 Character Password"
        }
        if(!passwordText.matches(".*[A-Z].*".toRegex())){
            return false
        //return "Must Contain 1 Upper-case Character"
        }
        if(!passwordText.matches(".*[A-Z].*".toRegex())){
            return false
        //return "Must Contain 1 Upper-case Character"
        }
        if(!passwordText.matches(".*[a-z].*".toRegex())){
            return false
        //return "Must Contain 1 Lower-case Character"
        }
        if(!passwordText.matches(".*[@#\$%^&+=].*".toRegex())){
            return false
        //return "Must Contain 1 Special Character (@#\$%^&+=)"
        }*/
        if (passwordText == "admin") {
            return true
        }
        return false
    }

    fun Signup(v: View) {
        val intent = Intent(this, SignUpActivity::class.java)
        startActivity(intent)
    }


}