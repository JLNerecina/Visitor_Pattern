public class Sofa implements Furniture {
    private final String model;
    private final double lengthCm;
    private final double widthCm;
    private final double heightCm;

    public Sofa(String model, double lengthCm, double widthCm, double heightCm) {
        this.model = model;
        this.lengthCm = lengthCm;
        this.widthCm = widthCm;
        this.heightCm = heightCm;
    }

    public double getVolumeInM3() {
        return (lengthCm * widthCm * heightCm) / 1_000_000.0;
    }

    public String getModel() {
        return model;
    }

    @Override
    public double accept(ShippingVisitor visitor) {
        return visitor.visit(this);
    }
}