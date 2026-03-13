public class ShippingCostCalculator implements ShippingVisitor {
    private final double distanceKm;  

    public ShippingCostCalculator(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    @Override
    public double visit(Chair chair) {
        double cost = 35.0 + (chair.getWeightInKg() * 4.0);
        System.out.println("→ Chair '" + chair.getModel() + "' shipping calculated (lightweight flat rate)");
        return Math.round(cost * 100.0) / 100.0;
    }

    @Override
    public double visit(Sofa sofa) {
        double volume = sofa.getVolumeInM3();
        double cost = 120.0 + (volume * 95.0) * (distanceKm / 150.0);
        System.out.println("→ Sofa '" + sofa.getModel() + "' shipping calculated (bulky + distance-based)");
        return Math.round(cost * 100.0) / 100.0;
    }

    @Override
    public double visit(Table table) {
        double area = table.getAreaInM2();
        double cost = 55.0 + (area * 38.0);
        System.out.println("→ Table '" + table.getModel() + "' shipping calculated (area-based)");
        return Math.round(cost * 100.0) / 100.0;
    }
    @Override
    public double visit(Bed bed) {
        double area = bed.getMattressAreaInM2();
        double base = 180.0 + (area * 140.0);
        double headboardFee = bed.hasHeadboard() ? 65.0 : 0.0;
        double cost = base + headboardFee + (distanceKm > 300 ? 45.0 : 0.0);

        System.out.println("→ Bed '" + bed.getModel() + "' shipping calculated (mattress area + headboard & distance)");
        return Math.round(cost * 100.0) / 100.0;
    }

    @Override
    public double visit(Bookshelf shelf) {
        int shelves = shelf.getNumberOfShelves();
        double heightM = shelf.getHeightInMeters();
        double cost = 75.0 + (shelves * 22.0) + (heightM * 48.0);

        if (heightM > 1.8) {
            cost += 55.0;
        }

        System.out.println("→ Bookshelf '" + shelf.getModel() + "' shipping calculated (shelves + height, fragility check)");
        return Math.round(cost * 100.0) / 100.0;
    }
}