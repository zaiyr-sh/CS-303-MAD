package kg.task.currencydatabase.Viewers

import android.content.Context
import android.content.Intent
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kg.task.currencydatabase.DataAccess.CurrencyReaderDBHelper

import kg.task.currencydatabase.Models.Currency
import kg.task.currencydatabase.R

class CurrenciesAdapter (listArray: ArrayList<Currency>, context: Context): RecyclerView.Adapter<CurrenciesAdapter.ViewHolder>() {
    private var listArrayR = listArray
    private var contextR = context

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val countryName_textView = view.findViewById<TextView>(R.id.countryName_textView)
        val currency_textView = view.findViewById<TextView>(R.id.currency_textView)
        val course_textView = view.findViewById<TextView>(R.id.course_textView)
        val button_delete = view.findViewById<Button>(R.id.button_delete)

        // fill in layout
        fun bind(listItem: Currency, context: Context) {
            countryName_textView.text = Html.fromHtml("<strong>Country: </strong>${listItem.getCountry()}")
            currency_textView.text = Html.fromHtml("<strong>Currency: </strong>${listItem.getCurrencyName()}")
            course_textView.text = Html.fromHtml("<strong>Course to dollar: </strong>${listItem.getCourseToDollar()}")

            val currencyReaderDBHelper = CurrencyReaderDBHelper(context)
            button_delete.setOnClickListener {
                if(currencyReaderDBHelper.deleteCurrency(listItem)){
                    Toast.makeText(context, "Successfully deleted!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    // draw view holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(contextR)
        return ViewHolder(inflater.inflate(R.layout.currency_item, parent, false))
    }

    // run bind() function
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listItem: Currency = listArrayR[position]
        holder.bind(listItem, contextR)
    }

    // get the size of elements
    override fun getItemCount(): Int {
        return listArrayR.size
    }
}