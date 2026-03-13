public class Chair implements Furniture {
    private final String model;
    private final double weightInKg;

    public Chair(String model, double weightInKg) {
        this.model = model;
        this.weightInKg = weightInKg;
    }

    public double getWeightInKg() {
        return weightInKg;
    }

    public String getModel() {
        return model;
    }

    @Override
    public double accept(ShippingVisitor visitor) {
        return visitor.visit(this);  
    }
}