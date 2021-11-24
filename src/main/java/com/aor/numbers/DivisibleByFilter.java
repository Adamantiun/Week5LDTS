package com.aor.numbers;

public class DivisibleByFilter implements GenericListFilter{
    private int n;
    public DivisibleByFilter(int x){
        n=x;
    }
    public boolean accept(Integer number) {
        return number%n ==0;
    }
}
