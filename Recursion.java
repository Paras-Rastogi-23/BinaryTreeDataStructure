
public class Recursion {
    public static void main(String[] args) {
        float result = f(1,3,0);
        System.out.println(" - "+result);
    }
    static float f(long m ,long n,int count ){
        float result;
        result = (float) m/(float) n;
        System.out.print(count);
        if(m<0 || n<0)
            return 0;
        else{
            System.out.println("-  m = "+m+" n = "+n+" result = "+result);
            result = result - f((2*m) , (3*n),count+1);
        }
        return result;
    }
}
