package kg.task.currencydatabase

import android.content.ContentValues
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kg.task.currencydatabase.DataAccess.CurrencyReaderContract
import kg.task.currencydatabase.DataAccess.CurrencyReaderDBHelper
import kg.task.currencydatabase.Models.Currency
import kg.task.currencydatabase.Viewers.CurrenciesActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_add.setOnClickListener{
            val country: String = countryEditText.text.toString()
            val currency: String = currencyEditText.text.toString()
            val course: String = countryEditText.text.toString()
            val currencyReaderDBHelper = CurrencyReaderDBHelper(this)
            if(currencyReaderDBHelper.createDynamicCurrencies(country, currency, course)){
                Toast.makeText(this, "Successfully added!", Toast.LENGTH_SHORT).show()
            }
        }

        buttonOpenQuestions.setOnClickListener { view ->
            val intent = Intent(view.context, CurrenciesActivity::class.java)
            view.context.startActivity(intent)
        }
    }
}