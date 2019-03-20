package cn.elmi.sample.breaker;


public class Category {

    private Object val;

    public Category(Object val) {
        this.val = val;
    }

    public String append(Object o) {
        return val.toString().concat(o.toString());
    }

}
