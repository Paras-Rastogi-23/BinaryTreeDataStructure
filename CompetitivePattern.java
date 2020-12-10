import java.io.*;
public class CompetitivePattern {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int limit = Integer.parseInt(br.readLine());
        int EndPoint = 2+(4*(limit-1));
        int endPoint   = EndPoint;
        String[][] finalArray = new String[endPoint][endPoint];
        int startPoint = 0;

        while (limit>0){
            for (int i = startPoint; i < endPoint; i++) {
                for (int j = startPoint; j < endPoint; j++) {
                    if(i==startPoint || j == startPoint || i == endPoint-1 || j == endPoint-1)
                        finalArray[i][j] = "* ";
                    else
                        finalArray[i][j] = "  ";
                }
            }
            startPoint += 2;
            endPoint   -= 2;
            limit--;
        }
        for (int i = 0; i < EndPoint; i++) {
            for (int j = 0; j < EndPoint; j++) {
                System.out.print(finalArray[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
