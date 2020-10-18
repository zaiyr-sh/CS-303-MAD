package kg.task.currencydatabase.DataAccess

import android.provider.BaseColumns;

public class CurrencyReaderContract private constructor(){
    // Table contents are grouped together in an anonymous object.
    class CurrencyEntry private constructor() :BaseColumns {
        companion object {
            val CURRENCY_ID = BaseColumns._ID
            const val TABLE_NAME = "CurrencyTbl"
            const val COUNTRY = "country"
            const val CURRENCY_NAME = "currency_name"
            const val COURSE_TO_DOLLAR = "course_to_dollar"
        }
    }
}

// Sqlite databases uses in this app, comes with an _id column that autoincrements and can function as a primary key.