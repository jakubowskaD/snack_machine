package snackMachine;

import snackMachine.position.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class SnackMachine {

    Text text = new Text();
    private final int numberOfPositions;
    private final int maxPrice;
    List<Position> positionList = new ArrayList<>();
    List<Position> emptyPositionList = new ArrayList<>();
    Scanner myObj = new Scanner(System.in);

    public SnackMachine(int numberOfPositions, int maxPrice) {
        this.numberOfPositions = numberOfPositions;
        this.maxPrice = maxPrice;
    }

    public void run(){
        positionList = new RandomGenerator().positionGenerator(numberOfPositions, maxPrice);
        text.hello();
        printMenu();
    }

    private void printMenu(){
        text.menu();
        String number = myObj.nextLine();
        if(number.equals("1")){
            printSnacks();
            getSnack();
        }else if(number.equals("2")){
            addRandomSnack();
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
    private void getSnack(){
        String choseNumber = myObj.nextLine();
        if (Integer.parseInt(choseNumber)<= positionList.size()){
            for(Position position : positionList){
                if (position.getNumber() == Integer.parseInt(choseNumber)){
                    if (position.isOccupied()){
                        position.setOccupied(false);
                        text.mniam();
                    } else {
                        text.wrong();
                    }
                    printMenu();
            }}
        }else{
            text.wrong();
            getSnack();
        }
    }
    private void printAddSnack(){
        for(Position position : positionList){
            if(!position.isOccupied()){
                System.out.println(position.getNumber());
                emptyPositionList.add(position);
            }
        }
    }
    private void addRandomSnack(){
        printAddSnack();
        String choseNumber = myObj.nextLine();
        for(Position position : emptyPositionList){
            if (position.getNumber() == Integer.parseInt(choseNumber)){
                position.setOccupied(true);
                position.setSnack(Optional.ofNullable(new RandomGenerator().snackGenerator(maxPrice)));
                emptyPositionList.remove(position);
            }
        }
        printMenu();
    }

}
