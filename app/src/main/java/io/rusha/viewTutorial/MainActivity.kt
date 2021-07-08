package io.rusha.viewTutorial

import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val root = FrameLayout(this)

        val credentialsRoot = LinearLayout(this)
        credentialsRoot.orientation = LinearLayout.VERTICAL
        root.addView(credentialsRoot)
        val credentialsRootParams = FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT,
        )
        credentialsRoot.layoutParams = credentialsRootParams
        credentialsRootParams.gravity = Gravity.CENTER

        val loginEdit = EditText(this)
        val loginEditParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT,
        )
        loginEdit.layoutParams = loginEditParams
        loginEdit.hint = "Логин"
        credentialsRoot.addView(loginEdit)

        val passwordEditText = EditText(this)
        val passwordEditTextParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT,
        )
        passwordEditText.layoutParams = passwordEditTextParams
        passwordEditText.hint = "Пароль"
        credentialsRoot.addView(passwordEditText)

        val loginButton = Button(this)
        val loginButtonParams = FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT,
        )
        loginButtonParams.gravity = Gravity.BOTTOM
        loginButton.layoutParams = loginButtonParams
        loginButton.text = "Вход"
        root.addView(loginButton)

//        setContentView(root)
        setContentView(R.layout.activity_view)
    }
}