package com.example.vital.tictactoe

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {
    var move = 0
    val buttonsArray : ArrayList<Button> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonsArray.add(button0)
        buttonsArray.add(button1)
        buttonsArray.add(button2)
        buttonsArray.add(button3)
        buttonsArray.add(button4)
        buttonsArray.add(button5)
        buttonsArray.add(button6)
        buttonsArray.add(button7)
        buttonsArray.add(button8)

        for (btn in buttonsArray) {
            btn.setOnClickListener(this)
        }

        resetButton.setOnClickListener{
            setDefaultButtons()
        }
        setDefaultButtons()
    }

    override fun onClick(v: View?) {
        move++
        val btn = v as Button

        if (move % 2 == 0) {
            btn.text = "O"
        } else {
            btn.text = "X"
        }

        btn.isEnabled = false
        checkWinner()
    }

    private fun setDefaultButtons() {
        for (btn in buttonsArray) {
            btn.text = ""
            btn.isEnabled = true
            result.text = ""
            move = 0
        }
    }

    private fun lockButtons() {
        for (btn in buttonsArray) {
            btn.isEnabled = false
        }
    }

    fun checkWinner() {
        val text = if (move % 2 == 0) "O win" else "X win"
        val filteredArray = buttonsArray.filter{
            it.text == ""
        }
        val isEmpty = filteredArray.isEmpty()

        if (buttonsArray[0].text != "" && buttonsArray[0].text == buttonsArray[1].text && buttonsArray[0].text == buttonsArray[2].text) {
            result.text = text
            lockButtons()
        } else if (buttonsArray[3].text != "" && buttonsArray[3].text == buttonsArray[4].text && buttonsArray[3].text == buttonsArray[5].text) {
            result.text = text
            lockButtons()
        } else if (buttonsArray[6].text != "" && buttonsArray[6].text == buttonsArray[7].text && buttonsArray[6].text == buttonsArray[8].text) {
            result.text = text
            lockButtons()
        } else if (buttonsArray[0].text != "" && buttonsArray[0].text == buttonsArray[3].text && buttonsArray[0].text == buttonsArray[6].text) {
            result.text = text
            lockButtons()
        } else if (buttonsArray[1].text != "" && buttonsArray[1].text == buttonsArray[4].text && buttonsArray[1].text == buttonsArray[7].text) {
            result.text = text
            lockButtons()
        } else if (buttonsArray[2].text != "" && buttonsArray[2].text == buttonsArray[5].text && buttonsArray[2].text == buttonsArray[8].text) {
            result.text = text
            lockButtons()
        } else if (buttonsArray[0].text != "" && buttonsArray[0].text == buttonsArray[4].text && buttonsArray[0].text == buttonsArray[8].text) {
            result.text = text
            lockButtons()
        } else if (buttonsArray[2].text != "" && buttonsArray[2].text == buttonsArray[4].text && buttonsArray[2].text == buttonsArray[6].text) {
            result.text = text
            lockButtons()
        } else if (isEmpty) {
            result.text = "With drawn"
            lockButtons()
        }
    }
}
