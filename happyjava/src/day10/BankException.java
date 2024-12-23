package day10;

public class BankException extends Exception{
    public BankException(){
        super("BankException 발생");
    }
    public BankException(String msg){
        super(msg);
    }
}
