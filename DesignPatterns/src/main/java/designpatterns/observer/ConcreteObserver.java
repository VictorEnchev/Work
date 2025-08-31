package designpatterns.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implementation of the Observer interface
 */
public class ConcreteObserver implements Observer {
    private static final Logger LOG = LoggerFactory.getLogger(ConcreteObserver.class);

    private final Available availableGoods;
    private final Sold soldGoods;

    public ConcreteObserver(int goodsCount) {
        availableGoods = new Available(goodsCount);
        soldGoods = new Sold();
    }

    /**
     * Updates the statistics based on the information which is received from the manager
     * @param actionType Added or Sold
     */
    @Override
    public void update(String actionType) {
        switch (actionType) {
            case "Added" -> {
                availableGoods.addGood();
                LOG.info("Good added");
            }
            case "Sold" -> {
                availableGoods.sellGood();
                soldGoods.sellGood();
                LOG.info("Good sold");
            }
        }
    }
}
