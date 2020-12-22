import java.io.IOException;
import java.util.*;

class Direction {


    static char Direction(int[] arr, int n) {
        char direction = 'N';
        HashMap<Character, Character> mapClockwise = new HashMap<Character, Character>();
        HashMap<Character, Character> mapAntiClockwise = new HashMap<Character, Character>();
        mapClockwise.put('N', 'E');
        mapClockwise.put('E', 'S');
        mapClockwise.put('S', 'W');
        mapClockwise.put('W', 'N');
        mapAntiClockwise.put('E', 'N');
        mapAntiClockwise.put('N', 'W');
        mapAntiClockwise.put('W', 'S');
        mapAntiClockwise.put('S', 'E');
        for (int i = 0; i < n; i++) {
            if (arr[i] > 1) {
                direction = mapClockwise.get(direction);
            } else if (arr[i] < 1) {
                direction = mapAntiClockwise.get(direction);
            } else continue;
        }
        return direction;
    }

    public static void main(String[] args)throws IOException {
        Scanner in = new Scanner(System.in);
        int[] arr = {1, 2, 3, -4, -2, 5, -2, 4};
        char direction = Direction(arr, arr.length);
        System.out.println(direction);
    }

}


