package kg.task.currencydatabase.Viewers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kg.task.currencydatabase.DataAccess.CurrencyReaderDBHelper
import kg.task.currencydatabase.Models.Currency
import kg.task.currencydatabase.R
import kotlinx.android.synthetic.main.currency_content.*

class CurrenciesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_currencies)

        val currencyDbHelper = CurrencyReaderDBHelper(this)
        val currenciesArrayList: ArrayList<Currency> = currencyDbHelper.getAllCurrencies()

        currency_recycler_view.hasFixedSize()
        currency_recycler_view.layoutManager = LinearLayoutManager(this)
        currency_recycler_view.adapter = CurrenciesAdapter(currenciesArrayList, this)
    }
}