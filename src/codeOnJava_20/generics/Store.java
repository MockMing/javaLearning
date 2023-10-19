/**
 * 使用泛型集合构建复杂模型
 * 该模型是一个带有通道、货架和货品的商店
 * 声明类时，例如 class Shelf extends ArrayList<Product> { ... } 中泛型的声明，有一种 “这个 Shelf 里放的是 Product 它的存放方式是 ArrayList” 的感觉
 */

package codeOnJava_20.generics;

import onjava.Suppliers;
import java.util.ArrayList;
import java.util.Random;
import java.util.function.Supplier;

// 货品
class Product {
    private final int id;           // 编号
    private String description;     // 描述
    private double price;           // 价格

    Product(int idNumber, String descr, double price) {
        id = idNumber;
        description = descr;
        this.price = price;
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return id + ": " + description + ", price: $" + price;
    }

    public void priceChange(double change) {
        price += change;
    }

    // 货品生成器
    public static Supplier<Product> generator = new Supplier<Product>() {
        // 匿名内部类
        private Random rand = new Random(47);
        @Override
        public Product get() {
            return new Product(
                    rand.nextInt(1000),
                    "Test",
                    Math.round(
                            rand.nextDouble() * 1000.0
                    ) + 0.99
            );
        }
    };
}

// 货架
class Shelf extends ArrayList<Product> {
    // 填充货品的操作在离货品“最近的一层”进行处理
    Shelf(int nProducts) {
        Suppliers.fill(this, Product.generator, nProducts);
    }
}

// 通道
class Aisle extends ArrayList<Shelf> {
    Aisle(int nShelves, int nProducts) {
        for(int i = 0; i < nShelves; i++)
            add(new Shelf(nProducts));
    }
}

class CheckoutStand{ }
class Office {}

// 商店
public class Store extends ArrayList<Aisle> {
    private ArrayList<CheckoutStand> checkouts = new ArrayList<>();
    private Office office = new Office();

    public Store(int nAisles, int nShelves, int nProducts) {
        for(int i = 0; i < nAisles; i++) {
            add(new Aisle(nShelves, nProducts));
        }
    }

    @Override
    public String toString() {

        StringBuilder result = new StringBuilder();

        for(Aisle a : this)
            for(Shelf s : a)
                for(Product p : s) {
                    result.append(p);
                    result.append("\n");
                }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Store(5, 4, 3));
    }
}
