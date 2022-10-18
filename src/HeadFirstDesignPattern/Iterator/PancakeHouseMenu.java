package HeadFirstDesignPattern.Iterator;

import java.util.ArrayList;
import java.util.List;

public class PancakeHouseMenu {
    List<MenuItem> menuItems;

    public PancakeHouseMenu(List<MenuItem> menuItems) {
        this.menuItems = new ArrayList<MenuItem>();

        addItem("K&Bのパンケーキ朝食", "スクランブルエッグとトースト付きパンケーキ", false, 2.99);

        addItem("いつものパンケーキ朝食", "卵焼きとソーセージ付きパンケーキ", false, 2.99);
    }

    public void addItem(String name, String description, boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        menuItems.add(menuItem);
    }

    public ArrayList<MenuItem> getMenuItems() {
        return (ArrayList<MenuItem>) menuItems;
    }
}
