package samplearrays;

public class BankAccount {

    String name;
    double currentBalance;
    double[] transactions = new double[1000];
    int transactionIndex = 0;

    public BankAccount(String name, int startingBalance){
        this.name = name;
        this.currentBalance = startingBalance;
    }

    public void deposit(double amount){
        if(amount<=0){
            System.out.println("Unsuccessful Deposit: negative value or nothing to deposit");
        }else{
            this.currentBalance += amount;
            if(this.transactionIndex >= this.transactions.length){
                for(int i=0;i<this.transactions.length-1;i++){
                    this.transactions[i] = this.transactions[i+1];
                }
                this.transactions[this.transactions.length-1] = amount;
            }else{
            this.transactions[this.transactionIndex]= amount;
            }
            this.transactionIndex += 1;
            System.out.println("name: "+this.name+", the deposited amount: "+ amount+", the new balance: "+this.currentBalance);
        }
    }

    public void withdraw(double amount){
        if(amount <= 0 || this.currentBalance < amount){
            System.out.println("Unsuccessful Withdraw: negative/null value or the current balance is insufficient");
        }else{
            this.currentBalance -= amount;
            if(this.transactionIndex >= this.transactions.length){
                for(int i=0;i<this.transactions.length-1;i++){
                    this.transactions[i] = this.transactions[i+1];
                }
                this.transactions[this.transactions.length-1] = -amount;
            }else{
                this.transactions[this.transactionIndex]= -amount;
            }
            this.transactionIndex += 1;
            System.out.println("name: "+this.name+", the withdraw amount: "+ amount+", the new balance: "+this.currentBalance);
        }
    }

    public void displayTransactions(){
        System.out.println("Recent recorded transactions: ");
        for(double value:this.transactions){
            if(value==0){
                return;
            }
            System.out.println((value>0? "Deposit: ":"Withdraw: ")+value);
        }
    }

    public void displayBalance(){
        System.out.println("current balance: "+this.currentBalance);
    }

    public static void main(String[] args) {

        BankAccount john = new BankAccount("John Doe", 100);

        // ----- DO NOT CHANGE -----

        //Testing..
        john.displayBalance();
        john.deposit(0.25);
        john.withdraw(100.50);
        john.withdraw(40.90);
        john.deposit(-90.55);
        john.deposit(3000);
        john.displayTransactions();
        john.displayBalance();

        // ----- DO NOT CHANGE -----

    }

}
