package de.davidriad.digibee

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.core.view.get
import com.google.android.material.textfield.TextInputLayout
import de.davidriad.digibee.databinding.ActivityLoginBinding
import de.davidriad.digibee.databinding.ActivityMainBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        emailFocusLinstener()
        passwordFocusLinstener()

        binding.loginButton.setOnClickListener { submitForm() }
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
        var message = validEmail().toString() + validPassword().toString()
        if(binding.emailContainer.helperText != null)
            message += "\n\nEmail: " + binding.emailContainer.helperText
        if(binding.emailContainer.helperText != null)
            message += "\n\nPassword: " + binding.passwordContainer.helperText

        AlertDialog.Builder(this)
            .setTitle("Invalid Form")
            .setMessage(message)
            .setPositiveButton("okay"){_,_ ->
                //do nothing
            }
            .show()
    }

    private fun resetForm() {
        var message = "Email: " + binding.emailEditText.text
            message += "\nPassword: " + binding.passwordEditText.text

        AlertDialog.Builder(this)
            .setTitle("Form submitted")
            .setMessage(message)
            .setPositiveButton("Okay"){_,_ ->
                binding.emailEditText.text = null
                binding.passwordEditText.text = null

                binding.emailContainer.helperText = getString(R.string.required)
                binding.passwordContainer.helperText = getString(R.string.required)
            }
            .show()
    }

    private fun emailFocusLinstener(){
        binding.emailEditText.setOnFocusChangeListener { _, focused ->
            if(!focused){
                //binding.emailContainer.helperText = validEmail()
            }
        }
    }

    private fun validEmail(): Boolean {
        val emailText = binding.emailEditText.text.toString()
        /*if(!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()){
            return false
        }*/
        if(emailText == "admin"){
            return true
        }
        return false
    }

    private fun passwordFocusLinstener(){
        binding.passwordEditText.setOnFocusChangeListener { _, focused ->
            if(!focused){
                //binding.emailContainer.helperText = validPassword()
            }
        }
    }

    //All of this is using for Sign-Up
    private fun validPassword(): Boolean {
        val passwordText = binding.passwordEditText.text.toString()
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
        if(passwordText == "admin"){
            return true
        }
        return false
    }

    fun Signup(v : View){
        val intent = Intent(this, SignUpActivity::class.java)
        startActivity(intent)
    }


}