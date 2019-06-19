import UIKit
import app

class ViewController: UIViewController {

    var presenter: AccountPresenter!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        presenter = AccountPresenterImpl(accountView: self, interactor: AccountInteractorImpl())
        presenter.displayMoney()
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    
    @IBAction func withdraw(_ sender: Any) {
        presenter.withdrawMoney(amount: 100)
    }
    
    @IBAction func deposit(_ sender: Any) {
        presenter.depositMoney(amount: 100)
    }
    
    @IBOutlet weak var amount: UILabel!
}

extension ViewController: AccountView {
    func displayAmount(text: String) {
        amount.text = text
    }
    
    func displayError(text: String) {
        amount.text = text
    }
}
