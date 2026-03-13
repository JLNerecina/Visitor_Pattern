# Furniture Shipping Cost Calculator – Visitor Pattern Example

A clean Java demonstration of the **Visitor design pattern** applied to a realistic e-commerce scenario: calculating shipping costs for different types of furniture.

Each furniture type has completely different shipping rules, yet the domain model remains clean and free of any business logic.

## UML Class Diagram

![Visitor Pattern UML Diagram](https://github.com/JLNerecina/Visitor_Pattern/blob/main/Visitor%20Pattern%20UML%20Diagram.png)


## Why Use the Visitor Pattern Here?

- Keeps domain classes (Chair, Sofa, Bed, etc.) focused only on data & structure  
- Centralizes all shipping calculation rules in one place  
- Makes it easy to add new furniture types without touching existing classes  
- Makes it easy to introduce new operations (insurance cost, packaging volume, carbon footprint, disassembly fees…)  
- Demonstrates clean **double dispatch** via `accept()` / `visit()`

## Supported Furniture Types & Shipping Rules

- **Chair** → flat base rate + weight multiplier  
- **Sofa** → volume-based + distance factor  
- **Table** → surface area-based  
- **Bed** → mattress area + headboard fee + long-distance surcharge  
- **Bookshelf** → number of shelves + height + fragility surcharge (for tall units)

## Features

- Pure interface-based Visitor implementation (no abstract classes)  
- Realistic, type-specific shipping cost formulas  
- Fully extensible: new furniture types or new calculations require minimal, localized changes  
- Simple console demo showing per-item and total shipping costs  
- Clear separation of concerns (domain vs. business rules)

## Project Structure

```
src/
├── Furniture.java                  # Element interface
├── Chair.java
├── Sofa.java
├── Table.java
├── Bed.java                        # added
├── Bookshelf.java                  # added
├── ShippingVisitor.java            # Visitor interface
├── ShippingCostCalculator.java     # Concrete visitor – all business logic lives here
└── ECommerceClient.java            # Demo / main program
```

## Example Output

```
=== E-COMMERCE SHIPPING CALCULATION (Visitor Pattern) ===
→ Chair 'Ergonomic Office Chair' shipping calculated (lightweight flat rate)
→ Sofa 'Modern 3-Seater Sofa' shipping calculated (bulky + distance-based)
→ Table 'Dining Table Walnut' shipping calculated (area-based)
→ Bed 'Queen Memory Foam Bed' shipping calculated (mattress area + headboard & distance)
→ Bookshelf 'Tall Oak Bookshelf' shipping calculated (shelves + height, fragility check)

=== SHIPPING SUMMARY ===
Chair     : $69.00
Sofa      : $312.45
Table     : $131.00
Bed       : $578.84
Bookshelf : $241.60

TOTAL SHIPPING COST FOR ORDER: $1,332.89
```

## How to Run

1. Clone the repository
2. Compile all Java files  
   ```bash
   javac *.java
   ```
3. Run the demo  
   ```bash
   java ECommerceClient
   ```

## Learning / Teaching Value

This example is intentionally practical and easy to follow — ideal for:

- Understanding when & why to use the Visitor pattern  
- Seeing double dispatch in action  
- Comparing Visitor vs. alternatives (instanceof switches, strategy pattern + reflection, sealed classes + pattern matching, etc.)  
- Teaching the **Open/Closed Principle** in a tangible way

## How to Extend the Project

### Adding a new furniture type (e.g. Wardrobe)

1. Create new class implementing `Furniture`  
2. Implement `accept(ShippingVisitor visitor)` → `return visitor.visit(this);`  
3. Add `double visit(Wardrobe wardrobe);` to `ShippingVisitor` interface  
4. Implement the visit method in `ShippingCostCalculator`

### Adding a completely new operation (e.g. insurance cost)

1. Create new visitor interface (or just a new class implementing a new one: `InsuranceVisitor`)  
2. Add corresponding `accept(InsuranceVisitor v)` overloads if needed (or use a generic visitor)  
3. Implement the new visitor with insurance rules

No changes are required to existing furniture classes in either case.

## Note
Programmer: John Lian R. Nerecina (3-BSCS-1)  
Institution: New Era University   
Github: @JLNerecina  
Last Update: March 14, 2026    
