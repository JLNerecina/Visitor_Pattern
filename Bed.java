public class Bed implements Furniture {
    private final String model;
    private final double lengthCm;
    private final double widthCm;
    private final boolean hasHeadboard;

    public Bed(String model, double lengthCm, double widthCm, boolean hasHeadboard) {
        this.model = model;
        this.lengthCm = lengthCm;
        this.widthCm = widthCm;
        this.hasHeadboard = hasHeadboard;
    }

    public double getMattressAreaInM2() {
        return (lengthCm * widthCm) / 10_000.0;
    }

    public boolean hasHeadboard() {
        return hasHeadboard;
    }

    public String getModel() {
        return model;
    }

    @Override
    public double accept(ShippingVisitor visitor) {
        return visitor.visit(this);
    }
}