package org.liewjuntung.mvp


interface AccountInteractor {
    interface Listener {
        fun returnCurrentAmount(amount: Int)
        fun showError(error: String)
    }

    fun deposit(amount: Int, listener: Listener)
    fun withdrawal(amount: Int, listener: Listener)
    fun displayAmount(listener: Listener)
}


const val AMOUNT_KEY = "amount_key"
expect fun saveMoney(amount: Int)
expect fun showMoney(): Int

class AccountInteractorImpl : AccountInteractor {
    override fun deposit(amount: Int, listener: AccountInteractor.Listener) {
        var currentAmount = showMoney()
        currentAmount += amount
        saveMoney(currentAmount)
        listener.returnCurrentAmount(currentAmount)
    }

    override fun withdrawal(amount: Int, listener: AccountInteractor.Listener) {
        var currentAmount = showMoney()
        if (amount > currentAmount) {
            listener.showError("You have not enough minerals")
        } else {
            currentAmount -= amount
            saveMoney(currentAmount)
            listener.returnCurrentAmount(showMoney())
        }
    }

    override fun displayAmount(listener: AccountInteractor.Listener) {
        listener.returnCurrentAmount(showMoney())
    }

}