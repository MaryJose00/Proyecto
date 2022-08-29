package acme.app.jediguide.ui.activities

import acme.app.jediguide.databinding.ActivityLogin2Binding
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLogin2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogin2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginButton.setOnClickListener(){
            login()
        }

    }
    private fun login(){
        binding.loginButton.setOnClickListener{
            if (binding.emailedirText.text.isNotEmpty() && binding.passwordEditText.text.isNotEmpty()) {
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                    binding.emailedirText.text.toString(),
                    binding.passwordEditText.text.toString()
                ).addOnCompleteListener {
                    if (it.isSuccessful) {
                        startActivity(Intent(baseContext, MainActivity::class.java))
                    } else {
                        val builder = AlertDialog.Builder(this)
                        builder.setTitle("ERROR")
                        builder.setMessage("Usuario no se ha podido registrar ")
                        builder.setPositiveButton("Aceptar", null)
                        val dialog: AlertDialog = builder.create()
                        dialog.show()
                    }
                }

            }
        }

        binding.accderButton.setOnClickListener{
            if (binding.emailedirText.text.isNotEmpty() && binding.passwordEditText.text.isNotEmpty()) {
                FirebaseAuth.getInstance().signInWithEmailAndPassword(
                    binding.emailedirText.text.toString(),
                    binding.passwordEditText.text.toString()
                ).addOnCompleteListener {
                    if (it.isSuccessful) {
                        startActivity(Intent(baseContext, MainActivity::class.java))
                    } else {
                        val builder = AlertDialog.Builder(this)
                        builder.setTitle("ERROR")
                        builder.setMessage("Credenciales incorrectas ")
                        builder.setPositiveButton("Aceptar", null)
                        val dialog: AlertDialog = builder.create()
                        dialog.show()
                    }
                }

            }
        }


    }
}