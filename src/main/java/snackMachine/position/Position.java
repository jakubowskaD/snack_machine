package snackMachine.position;

import snackMachine.position.snack.Snack;

import java.util.Objects;
import java.util.Optional;

public class Position {
        private int number;
        private boolean occupied;
        private Optional<Snack> snack;

        public Position(int number, boolean occupied, Optional<Snack> snack) {
                this.number = number;
                this.occupied = occupied;
                this.snack = snack;
        }

        public int getNumber() {
                return number;
        }

        public boolean isOccupied() {
                return occupied;
        }

        public void setOccupied(boolean occupied) {
                this.occupied = occupied;
        }

        public Optional<Snack> getSnack() {
                return snack;
        }

        public void setSnack(Optional<Snack> snack) {
                this.snack = snack;
        }


        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                Position position = (Position) o;

                if (number != position.number) return false;
                if (occupied != position.occupied) return false;
                return Objects.equals(snack, position.snack);
        }

        @Override
        public int hashCode() {
                int result = number;
                result = 31 * result + (occupied ? 1 : 0);
                result = 31 * result + (snack != null ? snack.hashCode() : 0);
                return result;
        }

        @Override
        public String toString() {
                return "Position{" +
                        "number=" + number +
                        ", occupied=" + occupied +
                        ", snack=" + snack +
                        '}';
        }
}
