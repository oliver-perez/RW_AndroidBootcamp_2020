package com.oliverperez.personalcard

final class DataSource {

    private var currentQuote: String = ""
    private var quotes = mutableListOf<String>(
        "“Any fool can write code that a computer can understand. Good programmers write code that humans can understand.” ${'\n'}  ${'\t'} – Martin Fowler",
        "“First, solve the problem. Then, write the code.” ${'\n'}  ${'\t'} – John Johnson",
        "“Code is like humor. When you have to explain it, it’s bad.” ${'\n'}  ${'\t'} – Cory House",
        "“Before software can be reusable it first has to be usable.” ${'\n'}  ${'\t'} – Ralph Johnson",
        "“Make it work, make it right, make it fast.” ${'\n'}  ${'\t'} – Kent Beck"
    )

    /**
     * This method returns a random quote, without repeating the last returned quote
     */
    fun getNewQuote(): String {
        var newQuote = quotes.random()
        return if (quotes.count() > 1) {
            while (newQuote == currentQuote) {
                newQuote = quotes.random()
            }
            currentQuote = newQuote
            newQuote
        } else {
            newQuote
        }
    }
}