package dsc.workshop.androidloveskotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import dsc.workshop.androidloveskotlin.adapter.HistoryAdapter
import dsc.workshop.androidloveskotlin.model.History
import dsc.workshop.androidloveskotlin.utils.DBHelper
import kotlinx.android.synthetic.main.activity_history.*

class HistoryActivity : AppCompatActivity() {

    private lateinit var adapter: HistoryAdapter

    var teamAPoints = arrayOf(100, 97, 94, 99)
    var teamBPoints = arrayOf(88, 100, 97, 90)

    private val history = ArrayList<History>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        adapter = HistoryAdapter(this, history)

        historyRV.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        setData()
    }

    fun setData() {
        val dbHelper = DBHelper(this)
        adapter = HistoryAdapter(this, dbHelper.historyList())
        historyRV.adapter = adapter
//        for (item in 0 until teamAPoints.size) {
//            history.add(History(teamAPoints[item], teamBPoints[item]))
//
//            adapter = HistoryAdapter(this, history)
//            historyRV.adapter = adapter
//        }
    }
}
