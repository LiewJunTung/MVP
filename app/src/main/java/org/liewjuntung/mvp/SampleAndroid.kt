package org.liewjuntung.mvp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.widget.Button
import android.widget.TextView
import sample.R

class MainActivity : AppCompatActivity(), AccountView {


    lateinit var withdrawalButton: Button
    lateinit var depositButton: Button
    lateinit var amountTextView: TextView
    lateinit var presenter: AccountPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = AccountPresenterImpl(this, AccountInteractorImpl())

        setContentView(R.layout.activity_main)
        findViewById<Toolbar>(R.id.toolbar).title = "Kt MVP Bank App"
        withdrawalButton = findViewById(R.id.withdraw_button)
        depositButton = findViewById(R.id.deposit_button)
        amountTextView = findViewById(R.id.money_textview)

        withdrawalButton.setOnClickListener {
            presenter.withdrawMoney(100)
        }

        depositButton.setOnClickListener {
            presenter.depositMoney(100)
        }
        presenter.displayMoney()

    }

    override fun displayAmount(text: String) {
        amountTextView.text = text
    }

    override fun displayError(text: String) {
        amountTextView.text = text
    }
}