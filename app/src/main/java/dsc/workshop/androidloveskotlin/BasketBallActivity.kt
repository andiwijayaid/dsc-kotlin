package dsc.workshop.androidloveskotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_basket_ball.*

class BasketBallActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basket_ball)

        var aPoint = 0
        var bPoint = 0

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
            aPoint = 0
            bPoint = 0
            a_pointTV.setText(aPoint.toString())
            b_pointTV.setText(bPoint.toString())
        }
    }
}
