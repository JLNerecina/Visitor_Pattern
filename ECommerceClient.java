public class ECommerceClient {
    public static void main(String[] args) {
        Furniture chair1    = new Chair("Ergonomic Office Chair", 8.5);
        Furniture sofa1     = new Sofa("Modern 3-Seater Sofa", 210, 95, 78);
        Furniture table1    = new Table("Dining Table Walnut", 200, 95);
        Furniture bed1      = new Bed("Queen Memory Foam Bed", 203, 152, true);
        Furniture bookshelf = new Bookshelf("Tall Oak Bookshelf", 6, 195);

        ShippingVisitor calculator = new ShippingCostCalculator(450.0);

        System.out.println("=== E-COMMERCE SHIPPING CALCULATION ===");

        double chairCost    = chair1.accept(calculator);
        double sofaCost     = sofa1.accept(calculator);
        double tableCost    = table1.accept(calculator);
        double bedCost      = bed1.accept(calculator);      // new
        double shelfCost    = bookshelf.accept(calculator); // new

        System.out.println("\n=== SHIPPING SUMMARY ===");
        System.out.printf("Chair     : $%.2f%n", chairCost);
        System.out.printf("Sofa      : $%.2f%n", sofaCost);
        System.out.printf("Table     : $%.2f%n", tableCost);
        System.out.printf("Bed       : $%.2f%n", bedCost);
        System.out.printf("Bookshelf : $%.2f%n", shelfCost);

        double total = chairCost + sofaCost + tableCost + bedCost + shelfCost;
        System.out.printf("%nTOTAL SHIPPING COST FOR ORDER: $%.2f%n", total);
    }
}