import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Elevator {
    int currentElevatorFloor = (int) (Math.random() * 10);
    //    public int currentElevatorFloor = 1;
    private int maxCapacity;
    private String color;
    boolean isStateDoor = false;

    public Elevator(int maxCapacity, String color) {
        this.maxCapacity = maxCapacity;
        this.color = color;
    }

    //3 Main methods

    void getDisplayCurrentFloor() {
        System.out.println("Current floor: " + currentElevatorFloor);
    }

    void callElevator(int actualFloor) {

        if (actualFloor == currentElevatorFloor) {
//            System.out.println("Current floor = number");
            openDoor();

        } else if (actualFloor > currentElevatorFloor) {
//            System.out.println("Current floor < number ");
            for (; currentElevatorFloor < actualFloor; ) {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                goingUp();
            }
            openDoor();
            System.out.println("You have arrived");
        } else if (actualFloor < currentElevatorFloor) {
//            System.out.println("Current floor > number ");
            while (currentElevatorFloor > actualFloor) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                goingDown();
            }
        }

    }

    void goingUp() {

        currentElevatorFloor++;
        getDisplayCurrentFloor();

    }

    void goingDown() {
        currentElevatorFloor--;
        getDisplayCurrentFloor();
    }

    void openDoor() {
        isStateDoor = true;
    }

    void callDispatcher() {
        // Do smth for call dispather
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public static void main(String[] args) {
        Elevator elevator = new Elevator(8, "white");
        System.out.println(" Hello, You are on: " + elevator.currentElevatorFloor + " floor");
        Floor floor = new Floor();
        int actualFloor1 = floor.getActualFloor();
        elevator.callElevator(actualFloor1);
    }

}
