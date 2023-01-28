import java.util.ArrayList;
import java.util.Scanner;
class BankAccount
   {
    static void Register()
      {
        Scanner sc=new Scanner(System.in);
        System.out.println("---------------------------");
        System.out.println("Enter your name :");
        ATM.name=sc.nextLine();
        
        System.out.println("Enter username :");
        String user=sc.nextLine();
        
        System.out.println("Enter password :");
        String pass=sc.nextLine();
        
        System.out.println("Enter your Account number :");
        ATM.acc_number=sc.nextLine();
        
        System.out.println("REGISTRATION SUCCESSFULLY!");
        System.out.println("---------------------------");
        ATM.prompt();
        while(true)
        {
            display(ATM.name);
            int choice=sc.nextInt();
            if(choice==1)
            {
                login(user,pass);
                break;
            }
            else {
                if(choice==2)
                {
                    System.exit(0);
                }
                else
                {
                    System.out.println("Bad value! Enter again!");
                }
            }
        }
    }
    static void display(String name) {}
    static void login(String user,String pass){}
}
class Transaction
{
   
    static void Deposit()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("----------------");
        System.out.print("Enter amount to deposit :");
        int depo_cash=sc.nextInt();
        ATM.updatebalance(depo_cash);
        ATM.history.add(Integer.toString(depo_cash));
        ATM.history.add("Deposit");
        System.out.println("Amount Rs."+depo_cash+"/- deposit successful!");
        System.out.println("---------------------------");
        ATM.prompt();
    }
    
    static void Withdraw()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("----------------");
        System.out.println("Enter amount to withdraw :");
        int wdr_cash=sc.nextInt();
        if(wdr_cash<=ATM.balance)
        {
            ATM.balance=ATM.balance-wdr_cash;
            ATM.history.add(Integer.toString(wdr_cash));
            ATM.history.add("Withdraw");
            System.out.println("Amount Rs"+wdr_cash+"/-withdraw successfully");
            System.out.println("---------------------------");
        }
        else
        {
            System.out.println("insufficient balance to withdraw the cash");
            System.out.println("---------------------------");
        }
        ATM.prompt();
    }
    static void Transfer()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the receiver name :");
        String s=sc.nextLine();
        System.out.println("Enter the account number of the receiver :");
        int num=sc.nextInt();
        System.out.println("Enter the amount to be transferred :");
        int trans_cash=sc.nextInt();
        if(trans_cash<=ATM.balance){
            ATM.balance=ATM.balance-trans_cash;
            ATM.history.add(Integer.toString(trans_cash));
            ATM.history.add("transferred");
            System.out.println("Amount Rs."+trans_cash+"/- transferred successfully");
            System.out.println("---------------------------");
        }
        else
        {
            System.out.println("insufficient balance to transfer the cash");
            System.out.println("---------------------------");
        }
    }
}
class check
{
    static void CheckBalance()
    {
        System.out.println("------------------");
        System.out.println("The available balance in the bank account :");
        ATM.showbalance();
        System.out.println("---------------------------");
        ATM.prompt();
    }
}
class his
  {
    static void TransactionHistory()
    {
            System.out.println("---------------------");
            System.out.println("Transaction History :");
            int H=0;
            if(ATM.balance>0){
            for(int i=0;i<(ATM.history.size()/2);i++)
            {
                for(int j=0;j<2;j++)
                {
                    System.out.println(ATM.history.get(H)+" ");
                    H++;
                }
                System.out.println("---------------------");
            }
         }
            else 
            {
                System.out.println("your account is empty");
            }
            ATM.prompt();
    }
}


public class ATM 
{
    public static String name;
    public static int balance=0;
    public static String acc_number;
    public static ArrayList<String> history=new ArrayList<String>();

    static void updatebalance(int dcash)
    {
        balance=balance+dcash;
    }
    static void showbalance(){
        System.out.println(balance);
    }
    public static void ATM_INTERFACE()
    {

        Scanner sc=new Scanner(System.in);
        System.out.println("WELCOME TO ATM INTERFACE");
        System.out.println("--------------------------");
        System.out.println("select option :");
        System.out.println("1. Register");
        System.out.println("2. Exit");
        System.out.println("Enter choice");
        int choice =sc.nextInt();
        if (choice==1)
        {
                BankAccount.Register();
        }
        else
        {
            if(choice==2)
            {
                System.exit(0);
            }
            else
            {
                System.out.println("select a value only from the given options :");
                ATM_INTERFACE();
            }
        }
    }
    static void prompt()
      {
        Scanner sc=new Scanner(System.in);
        System.out.println("WELCOME "+ATM.name+" TO ATM SYSTEM");
        System.out.println("---------------------");
        System.out.println("Select option : ");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Transfer");
        System.out.println("4. Check balance");
        System.out.println("5. Transaction History");
        System.out.println("6. Exit");
        System.out.print("Enter your choice : ");
        int choice=sc.nextInt();
        switch (choice)
        {
            case 1:
                Transaction.Deposit();
            case 2:
                Transaction.Withdraw();
            case 3:
                Transaction.Transfer();
            case 4:
                check.CheckBalance();
            case 5:
                his.TransactionHistory();
            case 6:System.out.println("Thank you...!!");
                System.exit(0);
        }
    }

  public static void main(String[] args)
    {
        ATM_INTERFACE();
    }
}