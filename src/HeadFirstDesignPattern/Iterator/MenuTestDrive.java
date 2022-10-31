package HeadFirstDesignPattern.Iterator;

public class MenuTestDrive {
    public static void main(String[] args) {
        MenuComponent pancakeHouseMenu = new Menu("パンケーキハウスメニュー", "朝食");
        MenuComponent dinerMenu = new Menu("食堂メニュー", "昼食");
        MenuComponent cafeMenu = new Menu("カフェメニュー", "夕食");
        MenuComponent dessertMenu = new Menu("デザートメニュー", "もちろんデザート");

        MenuComponent allMenus = new Menu("すべてのメニュー", "すべてを統合したメニュー");

        allMenus.add(pancakeHouseMenu);
        allMenus.add(dinerMenu);
        allMenus.add(cafeMenu);

        dinerMenu.add(new MenuItem(
                "パスタ",
                "マリナラソーススパゲティとサワードウパン",
                true,
                3.89
        ));

        dinerMenu.add(dessertMenu);

        dessertMenu.add(new MenuItem(
                "アップルパイ",
                "バニラアイスクリームをのせたフレーク状生地のアップルパイ",
                true,
                1.59
        ));

        Waitress waitress = new Waitress(allMenus);
        waitress.printMenu();
    }
}
