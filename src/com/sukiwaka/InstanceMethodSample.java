package com.sukiwaka;

class Account {
    String accountNO;

    /**
     * equalsメソッドのオーバーライド例
     *
     * @param obj
     * @return
     */
    public boolean equals(Object obj) {
        if (obj == this) { return true; }
        if (obj == null) { return false; }
        if (!(obj instanceof Account)) { return false; }
        Account acc = (Account) obj;
        return this.accountNO.trim().equals(acc.accountNO.trim());
    }
}

public class InstanceMethodSample {
    public static void main(String[] args) {

    }
}
