public abstract class CaffeineBeverage {

    // テンプレートメソッド
    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    // 差し替え可能なロジック

    abstract void brew();
    abstract void addCondiments();

    // 差し替え不要なロジック

    void boilWater() {
        System.out.println("お湯を沸かす");
    }

    void pourInCup() {
        System.out.println("カップに注ぐ");
    }
}

class Tea extends CaffeineBeverage {

    @Override
    void brew() {
        System.out.println("紅茶を浸す");
    }

    @Override
    void addCondiments() {
        System.out.println("レモンを追加する");
    }
}

class Coffee extends CaffeineBeverage {

    @Override
    void brew() {
        System.out.println("コーヒーをドリップする");
    }

    @Override
    void addCondiments() {
        System.out.println("砂糖とミルクを追加する");
    }
}
