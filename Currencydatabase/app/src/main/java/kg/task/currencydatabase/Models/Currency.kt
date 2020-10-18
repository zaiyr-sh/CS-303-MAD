package kg.task.currencydatabase.Models

import kotlin.properties.Delegates

class Currency() {
    private var id = 0
    private var country: String = ""
    private var currencyName: String = ""
    private var courseToDollar: String = ""

    constructor(country: String, currencyName: String, courseToDollar: String) : this() {
        this.id = id
        this.country = country
        this.currencyName = currencyName
        this.courseToDollar = courseToDollar
    }

    fun getId(): Int {
        return id
    }

    fun setId(id: Int) {
        this.id = id
    }

    fun getCountry(): String {
        return country
    }

    fun setCountry(country: String) {
        this.country = country
    }

    fun getCurrencyName(): String {
        return currencyName
    }

    fun setCurrencyName(currencyName: String) {
        this.currencyName = currencyName
    }

    fun getCourseToDollar(): String {
        return courseToDollar
    }

    fun setCourseToDollar(courseToDollar: String) {
        this.courseToDollar = courseToDollar
    }
}