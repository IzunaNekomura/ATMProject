package school;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Objects;

public class BankAccount {
//    CONSTANTS   //
    static private int MAX_PASSWORD_LENGTH = 5;
//    MEMBERS   //
    private int acctNum;
    private double balance;
    private String fName;
    private String lName;
    private String pswd;
    private String log;
//    CONSTRUCTORS    //
    BankAccount(){

    }
    BankAccount(String a, String b){

    }
    BankAccount(int a, double b, String c, String d, String e, String f){

    }
//    METHODS   //
    boolean deposit (double depoValue){
        if (depoValue > 0){
            balance += depoValue;
            log += "\n" + genTimestamp() + " Deposit Successful [$" + depoValue + "]";
            return true;
        } else {
            return false;
        }
    }
    boolean withdraw (double drawValue) {
        if(drawValue > 0 && balance >= drawValue){
            balance -= drawValue;
            log += "\n" + genTimestamp() + " Withdrawal Successful [$" + drawValue + "]";
            return true;
        } else {
            return false;
        }
    }
    boolean transferTo (double, BankAccount payee){}
    boolean checkPswd (String password){
        return Objects.equals(pswd, password);
    }
    boolean resetPswd (String currentPassword, String newPassword){
        if (Objects.equals(pswd, currentPassword)){
            pswd = newPassword;
            log += "\n" + genTimestamp() + " Password Successfully Changed!";
            return true;
        } else {
            log += "\n" + genTimestamp() + " Reset Password Failed!";
            return false;
        }
    }
    void resetAcctNum(){
        genAcctNum(5);
    }
    void setFName (String firstName){
        fName = firstName;
    }
    void setLName (String lastName){
        lName = lastName;
    }
    String getFName(){
        return fName;
    }
    String getLName(){
        return lName;
    }
    String getLog(){
        return log;
    }
    double getBalance(){
        return balance;
    }
    int getAcctNum(){
        return acctNum;
    }
    private int genAcctNum (int accNumLength){
        StringBuilder sb = new StringBuilder();
        for(int i=1; i <= accNumLength; i++){
                int newNum = (int) (Math.random() * accNumLength);
                if (i == 1 && newNum == 0) {
                    i--;
                    continue;
                }
            sb.append(newNum);
        }
        return Integer.parseInt(sb.toString());
    }
    private String genPswd (int pwLength){
        String[] strArray = { "a", "b", "c", "d", "e", "f", "g", "h", "i",  "j", "k", "l", "m", "n", "o", "p", "q", "r",
                "s", "t", "u", "v", "w", "x", "y", "z", "A",
                "B", "C", "D", "E", "F", "G", "H", "I", "J",
                "K", "L", "M", "N", "O", "P", "Q", "R", "S",
                "T", "U", "V", "W", "X", "Y", "Z", "1", "2",
                "3", "4", "5", "6", "7", "8", "9", "0" };
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= pwLength; i++){
            sb.append(strArray[(int) (Math.random() * pwLength)]);
        }
        return sb.toString();
    }
    private String genTimestamp(){
        return new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
    }
}
