package collections.pagebean;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representation of a page with items
 */
public class Page {
    private int pageSize;
    private List<String> items;

    public Page(int pageSize) {
        this.pageSize = pageSize;
        this.items = new ArrayList<>();
    }

    public List<String> getItems() {
        return items;
    }
}
