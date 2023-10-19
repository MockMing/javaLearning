/**
 * 更令人困惑的类型擦除
 */

package codeOnJava_20.generics;

import onjava.Tuple2;

import java.util.*;

class Frob { }
class Fnorkle { }
class Quark<Q> { }
class Particle<POSITION, MOMENTUM> { }


public class LostInformation {
    public static void main(String[] args) {
        List<Frob> list = new ArrayList<>();

        Map<Frob, Fnorkle> map = new HashMap<>();

        Quark<Fnorkle> quark = new Quark<>();

        Particle<Long, Double> p = new Particle<>();

        System.out.println(Arrays.toString(list.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(map.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(quark.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(p.getClass().getTypeParameters()));

        System.out.println();

        System.out.println(list.getClass().getSimpleName());
        System.out.println(map.getClass().getSimpleName());
        System.out.println(quark.getClass().getSimpleName());
        System.out.println(p.getClass().getSimpleName());

        System.out.println();

        List<? extends Number> listext= new ArrayList<>();
        List<? super Number> listsup= new ArrayList<>();
        List<Tuple2<Integer, Double>> lt2 = new ArrayList<>();

        System.out.println(Arrays.toString(listext.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(listsup.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(lt2.getClass().getTypeParameters()));

        System.out.println();

        System.out.println(listext.getClass().getSimpleName());
        System.out.println(listsup.getClass().getSimpleName());
        System.out.println(lt2.getClass().getSimpleName());
    }
}
