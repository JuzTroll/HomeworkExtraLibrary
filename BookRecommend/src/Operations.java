public class Operations {
    public int divide(int a, int b){
        return a/b;
    }

    public static void main(String[] args){
        Operations op = new Operations();
        try {
            System.out.println(op.divide(5, 0));
        } catch(ArithmeticException e) {
            System.out.println("S-a intamplat ceva: " + e.getMessage());
        }
    }
}
