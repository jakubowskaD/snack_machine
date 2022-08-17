package snackMachine.position.snack;


public class Snack {
    private SnackType snackType;
    private int price;

    public Snack(SnackType snackType, int price) {
        this.snackType = snackType;
        this.price = price;
    }

    public SnackType getSnackType() {
        return snackType;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Snack snack = (Snack) o;

        if (price != snack.price) return false;
        return snackType == snack.snackType;
    }

    @Override
    public int hashCode() {
        int result = snackType != null ? snackType.hashCode() : 0;
        result = 31 * result + price;
        return result;
    }

    @Override
    public String toString() {
        return "Snack{" +
                "snackType=" + snackType +
                ", price=" + price +
                '}';
    }
}
