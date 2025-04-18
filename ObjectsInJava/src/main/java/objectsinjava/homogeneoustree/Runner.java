package objectsinjava.homogeneoustree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Runner {
    private static final Logger LOG = LoggerFactory.getLogger(Runner.class);

    public static void main(String[] args) {
        int[] treeArray = {10, 5, 15, 2, 7, 12, 20};
        Tree<Integer> tree = new Tree<>(treeArray[0]);

        for (int i = 1; i < treeArray.length; i++) {
            tree.insert(treeArray[i]);
        }

        StringBuilder result = new StringBuilder();
        tree.sortedToString(result);
        LOG.info(result.toString());
        if(tree.search(5)){
            LOG.info("This value is present!");
        }
        else{
            LOG.info("This value is not present!");
        }
    }
}
