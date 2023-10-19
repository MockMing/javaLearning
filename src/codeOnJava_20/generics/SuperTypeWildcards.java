/**
 * 超类通配符
 */

package codeOnJava_20.generics;

import java.util.List;

public class SuperTypeWildcards {
    static void writeTo(List<? super Apple> apples) {
        apples.add(new Apple());
        apples.add(new Jonathan());
        // Error
        //- apples.add(new Fruit());
    }
}
