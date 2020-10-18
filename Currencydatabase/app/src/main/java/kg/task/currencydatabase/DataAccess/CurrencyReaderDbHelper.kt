package kg.task.currencydatabase.DataAccess

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import kg.task.currencydatabase.Models.Currency

public class CurrencyReaderDBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    lateinit var db: SQLiteDatabase

    override fun onCreate(db: SQLiteDatabase?) {
        // Create Table for Database
        this.db = db!!
        val SQL_CREATE_ENTRIES: String =
            "CREATE TABLE ${CurrencyReaderContract.CurrencyEntry.TABLE_NAME} (" +
                    "${CurrencyReaderContract.CurrencyEntry.CURRENCY_ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "${CurrencyReaderContract.CurrencyEntry.COUNTRY} TEXT NOT NULL," +
                    "${CurrencyReaderContract.CurrencyEntry.CURRENCY_NAME} TEXT NOT NULL," +
                    "${CurrencyReaderContract.CurrencyEntry.COURSE_TO_DOLLAR} TEXT NOT NULL)"
        db.execSQL(SQL_CREATE_ENTRIES)

        // Insert Data in the Table
        createCurrencies()
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db!!.execSQL(CurrencyReaderContract.CurrencyEntry.TABLE_NAME)
        onCreate(db)
    }

    companion object {
        // If you change the database schema, you must increment the database version.
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "Currencies.db"
    }

    private fun createCurrencies() {
        val currencyOne = Currency("Kyrgyz Republic", "SOM", "81.80")
        val currencyTwo = Currency("Russian Federation", "RUB", "77.80")
        val currencyThree = Currency("Republic of Kazakhstan", "TEN", "429.38")

        // Put information into database
        putCurrency(currencyOne)
        putCurrency(currencyTwo)
        putCurrency(currencyThree)
    }

    fun createDynamicCurrencies(country: String, currency: String, course: String): Boolean {
        val currency = Currency(country, currency, course)
        db = this.writableDatabase
        // Update information in database
        putCurrency(currency)
        db.close()
        return true
    }

    private fun putCurrency(currency: Currency) {
        // Create a new map of values, where column names are the keys
        val values: ContentValues = ContentValues().apply {
            put(CurrencyReaderContract.CurrencyEntry.COUNTRY, currency.getCountry())
            put(CurrencyReaderContract.CurrencyEntry.CURRENCY_NAME, currency.getCurrencyName())
            put(CurrencyReaderContract.CurrencyEntry.COURSE_TO_DOLLAR, currency.getCourseToDollar())
        }

        // Insert the new row
        db.insert(CurrencyReaderContract.CurrencyEntry.TABLE_NAME, null, values)
    }

    public fun getAllCurrencies(): ArrayList<Currency> {
        val currencyArrayList = ArrayList<Currency>()
        db = readableDatabase
        val cursor: Cursor =
            db.rawQuery("select * from ${CurrencyReaderContract.CurrencyEntry.TABLE_NAME}", null);

        if (cursor.moveToFirst()) {
            do {
                //Parcelable object
                val currency = Currency()
                currency.setId(cursor.getInt(cursor.getColumnIndex(CurrencyReaderContract.CurrencyEntry.CURRENCY_ID)))
                currency.setCountry(cursor.getString(cursor.getColumnIndex(CurrencyReaderContract.CurrencyEntry.COUNTRY)))
                currency.setCurrencyName(
                    cursor.getString(
                        cursor.getColumnIndex(
                            CurrencyReaderContract.CurrencyEntry.CURRENCY_NAME
                        )
                    )
                )
                currency.setCourseToDollar(
                    cursor.getString(
                        cursor.getColumnIndex(
                            CurrencyReaderContract.CurrencyEntry.COURSE_TO_DOLLAR
                        )
                    )
                )
                currencyArrayList.add(currency)
            } while (cursor.moveToNext())
        }
        cursor.close()
        return currencyArrayList
    }

    fun deleteCurrency(currency: Currency): Boolean {
        db = this.writableDatabase
        val success = db.delete(CurrencyReaderContract.CurrencyEntry.TABLE_NAME, CurrencyReaderContract.CurrencyEntry.CURRENCY_ID + "=?",
            arrayOf(currency.getId().toString())
        )
        db.close()
        return true
    }
}