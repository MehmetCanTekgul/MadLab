package com.example.msku;

public class BalanceChangingTest {
    public String addBalance(int pastAmount, int addAmount){
        int result = pastAmount + addAmount;
        return String.valueOf(result);
    }

    public String extractionBalance(int pastAmount, int extractAmount){
        int result = pastAmount - extractAmount;
        return String.valueOf(result);
    }

    public boolean isBalanceEnough(int currentAmount, int neededAmount){
        if(currentAmount>=neededAmount){
            return true;
        }else{
            return false;
        }
    }
}
