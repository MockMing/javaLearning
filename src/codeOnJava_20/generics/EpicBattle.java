/**
 * 更多层级的示例
 */

package codeOnJava_20.generics;

import java.util.List;

// 对边界继承无影响
interface SuperPower { }

interface XRayVision extends SuperPower {
    void seeThroughWalls();
}

interface SuperHearing extends SuperPower {
    void hearSubtleNoises();
}

interface SuperSmell extends SuperPower {
    void trackBySmell();
}

class SuperHero<POWER extends SuperPower> {
    POWER power;
    SuperHero(POWER power) {
        this.power = power;
    }
    POWER getPower() {
        return power;
    }
}

class SuperSleuth<POWER extends XRayVision> extends SuperHero<POWER> {
    SuperSleuth(POWER power) {
        super(power);
    }
    void see() {
        power.seeThroughWalls();
    }
}

class CanineHero<POWER extends SuperHearing & SuperSmell> extends SuperHero<POWER> {
    CanineHero(POWER power) {
        super(power);
    }
    void hear() {
        power.hearSubtleNoises();
    }
    void smell() {
        power.trackBySmell();
    }
}

class SuperHearSmell implements SuperHearing, SuperSmell {
    @Override
    public void hearSubtleNoises() { }
    @Override
    public void trackBySmell() { }
}

// *这里子类不是泛型类，但基类是泛型类
// SuperHearSmell 实现了 SuperHearing, SuperSmell ，CanineHero 的构造器要求传入的 POWER 实现这两个边界，条件满足因此可以传入
class DogPerson extends CanineHero<SuperHearSmell> {
    DogPerson() {
        super(new SuperHearSmell());
    }
}

public class EpicBattle {
    // 泛型方法中的边界：
    static <POWER extends SuperHearing> void useSuperHearing(SuperHero<POWER> hero) {
        hero.getPower().hearSubtleNoises();
    }
    static <POWER extends SuperHearing & SuperSmell> void superFind(SuperHero<POWER> hero) {
        hero.getPower().hearSubtleNoises();
        hero.getPower().trackBySmell();
    }

    public static void main(String[] args) {
        DogPerson dogPerson = new DogPerson();
        useSuperHearing(dogPerson);
        superFind(dogPerson);
        // 你可以这样：
        List<? extends SuperHearing> audioPeople;
        // 但不能这样：
        //- List<? extends SuperHearing & SuperSmell> dogPs;
    }
}
