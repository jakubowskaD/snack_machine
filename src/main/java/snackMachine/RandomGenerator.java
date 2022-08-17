package snackMachine;

import snackMachine.position.Position;
import snackMachine.position.snack.Snack;
import snackMachine.position.snack.SnackType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import static snackMachine.position.snack.SnackType.*;

public class RandomGenerator {

    List<Position> positionGenerator(int numberOfPositions, int maxPrice){
        List<Position> positionList = new ArrayList<>();
        for(int i=0; numberOfPositions>i; i++){
            positionList.add(new Position(i, true, Optional.of(snackGenerator(maxPrice))));
        }
        return positionList;
    }
    private Snack snackGenerator(int maxPrice){
        return new Snack(randomSnackType(), randomPrice(maxPrice));
    }
    private SnackType randomSnackType(){
        int number = ThreadLocalRandom.current().nextInt(0, 5);
        return switch (number) {
            case 1 -> COLA;
            case 2 -> WATER;
            case 3 -> APPLE;
            case 4 -> BREADSTICKS;
            default -> BAR;
        };
    }
    private int randomPrice(int maxPrice){
        return ThreadLocalRandom.current().nextInt(1,maxPrice);
    }
}
