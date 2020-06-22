package com.oliverperez.personalcard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val dataSource: DataSource = DataSource()
    lateinit var quoteButton: Button
    lateinit var quoteLabel: TextView

    companion object {
        private const val QUOTE_KEY = "QUOTE_KEY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        quoteButton = findViewById(R.id.quoteButton)
        quoteLabel = findViewById(R.id.quoteLabel)

        quoteButton.setOnClickListener {
            setNewQuote()
        }
        if (savedInstanceState != null) {
            quoteLabel.text = savedInstanceState.getString(QUOTE_KEY)
        } else {
            setNewQuote()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(QUOTE_KEY, quoteLabel.text.toString())
    }

    /**
     * Changes the current quote label to a new random quote
     */
    private fun setNewQuote() {
        quoteLabel.text = dataSource.getNewQuote()
    }
}