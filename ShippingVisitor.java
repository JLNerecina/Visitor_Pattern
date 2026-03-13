public interface ShippingVisitor {
    double visit(Chair chair);
    double visit(Sofa sofa);
    double visit(Table table);
    double visit(Bed bed);        
    double visit(Bookshelf shelf); 
}