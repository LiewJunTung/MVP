package org.liewjuntung.mvp

interface AccountPresenter {
    fun displayMoney()
    fun depositMoney(amount: Int)
    fun withdrawMoney(amount: Int)
    fun onDestroy()
}

class AccountPresenterImpl(var accountView: AccountView?, private val interactor: AccountInteractor) :
    AccountPresenter {

    private val accountInteractorListener = object : AccountInteractor.Listener {
        override fun showError(error: String) {
            accountView?.displayError(error)
        }

        override fun returnCurrentAmount(amount: Int) {
            accountView?.displayAmount("SGD $amount")
        }
    }

    override fun displayMoney() {
        interactor.displayAmount(accountInteractorListener)
    }

    override fun depositMoney(amount: Int) {
        interactor.deposit(amount, accountInteractorListener)
    }

    override fun withdrawMoney(amount: Int) {
        interactor.withdrawal(amount, accountInteractorListener)
    }

    override fun onDestroy() {
        accountView = null
    }
}
