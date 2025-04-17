/**
 * Problème : Calcul des réductions pour un magasin
 * Règles :
 * - Standard: 6% de réduction
 * - Seasonal: 12% de réduction 
 * - Weight: 6% si poids ≤ 10kg, 18% si > 10kg
 */
public class MegaStore {
    public enum DiscountType {
        Standard,
        Seasonal,
        Weight
    }

    public static double getDiscountedPrice(double cartWeight, 
                                         double totalPrice,
                                         DiscountType discountType) {
        switch(discountType) {
            case Standard:
                return applyDiscount(totalPrice, 0.06);
            case Seasonal:
                return applyDiscount(totalPrice, 0.12);
            case Weight:
                return applyDiscount(totalPrice, cartWeight > 10 ? 0.18 : 0.06);
            default:
                return totalPrice;
        }
    }

    private static double applyDiscount(double price, double discountRate) {
        return price * (1 - discountRate);
    }

    public static void main(String[] args) {
        System.out.println(getDiscountedPrice(12, 100, DiscountType.Weight)); // 82.0
        System.out.println(getDiscountedPrice(5, 100, DiscountType.Weight));  // 94.0
        System.out.println(getDiscountedPrice(0, 100, DiscountType.Standard)); // 94.0
        System.out.println(getDiscountedPrice(0, 100, DiscountType.Seasonal)); // 88.0
    }
}
