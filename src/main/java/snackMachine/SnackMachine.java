package snackMachine;

import snackMachine.position.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SnackMachine {

    Text text = new Text();
    private final int numberOfPositions;
    private final int maxPrice;
    List<Position> positionList = new ArrayList<>();
    Scanner myObj = new Scanner(System.in);

    public SnackMachine(int numberOfPositions, int maxPrice) {
        this.numberOfPositions = numberOfPositions;
        this.maxPrice = maxPrice;
    }

    public void run(){
        positionList = new RandomGenerator().positionGenerator(numberOfPositions, maxPrice);
        text.hello();
        printMenu();
//            printSnacks();
//            getSnack(myObj.nextLine());
    }

    private void printMenu(){
        text.menu();
        String number = myObj.nextLine();
        if(number.equals("1")){
            printSnacks();
        }else if(number.equals("2")){

        }else if(number.equals("3")){
            System.exit(0);
        }else{
            printMenu();
        }
    }
    private void printSnacks(){
        for (Position position : positionList){
            if(position.isOccupied()){
                System.out.println(position.getNumber() + ". " + position.getSnack().get().getSnackType() + " -> " + position.getSnack().get().getPrice() + "PLN");
            }else {
                System.out.println(position.getNumber());
            }
        }
    }
    private void getSnack(String choseNumber){
        if (Integer.parseInt(choseNumber)<= positionList.size()){
            for(Position position : positionList){
                if (position.getNumber() == Integer.parseInt(choseNumber)){
                    position.setOccupied(false);
                    text.mniam();
                    break;
            }}
        }else{
            text.wrong();
            printSnacks();
        }
    }
    private boolean isStealHungry(String choseNumber){
        return choseNumber.equals("q");
    }
}
