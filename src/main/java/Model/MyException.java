package Model;

public class MyException extends RuntimeException {

    private String s;

    public MyException(String s) {
        this.s = s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public String getS() {
        return this.s;
    }
}
