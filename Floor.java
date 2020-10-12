import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Floor {
//    public int actualFloor ;

    public int getActualFloor() {
        int actualFloor = 9;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Please enter floor: ");
            actualFloor = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return actualFloor;
    }
}
