public class Bookshelf implements Furniture {
    private final String model;
    private final int numberOfShelves;
    private final double heightCm;

    public Bookshelf(String model, int numberOfShelves, double heightCm) {
        this.model = model;
        this.numberOfShelves = numberOfShelves;
        this.heightCm = heightCm;
    }

    public int getNumberOfShelves() {
        return numberOfShelves;
    }

    public double getHeightInMeters() {
        return heightCm / 100.0;
    }

    public String getModel() {
        return model;
    }

    @Override
    public double accept(ShippingVisitor visitor) {
        return visitor.visit(this);
    }
}