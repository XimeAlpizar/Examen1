package com.example.oneplusoneapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

private val TAG = "MainActivity"
private val TEXT = "TEXT_CONTENT"
class MainActivity : AppCompatActivity() {

    private var textView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val userInput: EditText = findViewById<EditText>(R.id.editText1)
        val userInput2: EditText = findViewById<EditText>(R.id.editText2)
        val userInput3: EditText = findViewById<EditText>(R.id.editText3)
        val button: Button = findViewById<Button>(R.id.button5)
        val button2: Button = findViewById<Button>(R.id.button4)
        textView = findViewById<TextView>(R.id.textView2)

        //userInput = findViewById<EditText>(R.id.editText1)
        //userInput = findViewById<EditText>(R.id.editText2)
        //userInput = findViewById<EditText>(R.id.editText3)

        textView?.text =""
        textView?.movementMethod = ScrollingMovementMethod()


        button.setOnClickListener(object :View.OnClickListener {
            override fun onClick(p0: View?) {
                Log.d(TAG, "onClick")
                if(userInput.text.isNotEmpty() && userInput2.text.isNotEmpty() && userInput3.text.isNotEmpty()) {
                    textView?.append(userInput.text)
                    textView?.append("+")
                    textView?.append(userInput2.text)
                    textView?.append("=")
                    textView?.append(userInput3.text)
                    textView?.append("\n")
                    //userInput.setText("")
                    userInput.text.clear()
                    userInput2.text.clear()
                    userInput3.text.clear()
                }else {
                    textView?.append("\n")
                    textView?.text = "Fallo"
                }
            }
        })

        button2.setOnClickListener(object :View.OnClickListener {
            override fun onClick(p0: View?) {
                Log.d(TAG, "onClick")
                textView?.text =""
                userInput.text.clear()
                userInput2.text.clear()
                userInput3.text.clear()
            }
        })
    }

    override fun onStart(){
        Log.d(TAG, "onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d(TAG, "onResume")
        super.onResume()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        Log.d(TAG, "onRestoreInstanceState")
        super.onRestoreInstanceState(savedInstanceState)
        textView?.text = savedInstanceState.getString(TEXT, "")
    }

    override fun onPause() {
        Log.d(TAG, "onPause")
        super.onPause()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d(TAG, "onSaveInstanceState")
        super.onSaveInstanceState(outState)
        outState.putString(TEXT, textView?.text.toString())
    }

    override fun onStop() {
        Log.d(TAG, "onStop")
        super.onStop()
    }

    override fun onRestart() {
        Log.d(TAG, "onRestart")
        super.onRestart()
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy")
        super.onDestroy()
    }
}