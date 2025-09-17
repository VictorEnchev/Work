package collections.pagebean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Operates with the given data using several different methods
 */
public class Distributor {
    private static final Logger LOG = LoggerFactory.getLogger(Distributor.class);

    private final int pageSize;
    private final List<String> items;
    private final List<Page> pages;
    private int indicator;

    public Distributor(List<String> items, int pageSize) {
        this.items = items;
        this.pages = new ArrayList<>();
        this.pageSize = pageSize;
        this.indicator = 0;
    }

    /**
     * Moves through the existing pages and creates new ones if necessary. Logs out every operation
     */
    public void next(){
        if(items.isEmpty() && indicator == pages.size()) LOG.info("No next items");
        else {
            indicator++;
            if (indicator <= pages.size()) LOG.info(String.join(", ", pages.get(indicator - 1).getItems()));
            else {
                Page page = new Page(pageSize);
                page.getItems()
                        .addAll(items.stream()
                                .limit(pageSize)
                                .toList()
                        );
                int delete = 0;
                while (!this.items.isEmpty() && delete < pageSize) {
                    this.items.removeFirst();
                    delete++;
                }
                pages.add(page);

                LOG.info(String.join(", ", page.getItems()));
            }
        }
    }

    /**
     * Returns the previous page
     * @throws IllegalArgumentException if there is no previous page
     */
    public void previous(){
        if(indicator <= 1){
            throw new IllegalArgumentException("Can not do this action! No previous page");
        }

        indicator--;
        Page page = pages.get(indicator - 1);
        LOG.info(String.join(", ", page.getItems()));
    }

    /**
     * Checks if there is next page or more data to be processed
     */
    public void hasNext(){
        if(!this.items.isEmpty() || indicator < pages.size()) LOG.info("There are next items to return.");
        else LOG.info("There are no next items to return.");
    }

    /**
     * Checks if there is previous page
     */
    public void hasPrevious(){
        if(indicator <= 1) LOG.info("There are no previous items");
        else LOG.info("There are previous items");
    }

    /**
     * Returns to the first page
     */
    public void firstPage(){
        indicator = 1;
        LOG.info(String.join(", ", pages.getFirst().getItems()));
    }

    /**
     * Returns to the last page
     */
    public void lastPage(){
        indicator = pages.size();
        LOG.info(String.join(", ", pages.getLast().getItems()));
    }

    /**
     * Returns the number of the current page
     */
    public void getCurrPageNumber(){
        LOG.info(indicator + "");
    }
}
