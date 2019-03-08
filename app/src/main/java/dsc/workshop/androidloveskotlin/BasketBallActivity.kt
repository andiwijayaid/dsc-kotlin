package dsc.workshop.androidloveskotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import dsc.workshop.androidloveskotlin.model.History
import dsc.workshop.androidloveskotlin.utils.DBHelper
import kotlinx.android.synthetic.main.activity_basket_ball.*

class BasketBallActivity : AppCompatActivity() {

    private lateinit var dbHelper: DBHelper

    var aPoint = 0
    var bPoint = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basket_ball)

        dbHelper = DBHelper(this)

        a_1_pointBT.setOnClickListener {
            aPoint+=1
            a_pointTV.setText(aPoint.toString())
        }

        a_3_pointBT.setOnClickListener {
            aPoint+=3
            a_pointTV.setText(aPoint.toString())
        }

        b_1_pointBT.setOnClickListener {
            bPoint+=1
            b_pointTV.setText(bPoint.toString())
        }

        b_3_pointBT.setOnClickListener {
            bPoint+=3
            b_pointTV.setText(bPoint.toString())
        }

        resetBT.setOnClickListener {
            resetScore()
        }

        saveBT.setOnClickListener {
            val history = History(aPoint, bPoint)
            dbHelper.saveHistory(history)
            resetScore()
        }
    }

    fun resetScore() {
        aPoint = 0
        bPoint = 0
        a_pointTV.setText(aPoint.toString())
        b_pointTV.setText(bPoint.toString())
    }
}
