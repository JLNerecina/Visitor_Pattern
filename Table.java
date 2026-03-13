public class Table implements Furniture {
    private final String model;
    private final double lengthCm;
    private final double widthCm;

    public Table(String model, double lengthCm, double widthCm) {
        this.model = model;
        this.lengthCm = lengthCm;
        this.widthCm = widthCm;
    }

    public double getAreaInM2() {
        return (lengthCm * widthCm) / 10_000.0;
    }

    public String getModel() {
        return model;
    }

    @Override
    public double accept(ShippingVisitor visitor) {
        return visitor.visit(this);
    }
}