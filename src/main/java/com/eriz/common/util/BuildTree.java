package com.eriz.common.util;


import com.eriz.common.domain.TreeDO;

import java.util.ArrayList;
import java.util.List;

public class BuildTree {

    public static <T> List<TreeDO<T>> buildList(List<TreeDO<T>> nodes, String idParam) {
        if (nodes == null) {
            return null;
        }
        List<TreeDO<T>> topNodes = new ArrayList<>();

        for (TreeDO<T> children : nodes) {
            String pid = children.getParentId();
            if (pid == null || idParam.equals(pid)) {
                topNodes.add(children);
                continue;
            }

            for (TreeDO<T> parent : nodes) {
                String id = parent.getId();
                if (id != null && id.equals(pid)) {
                    parent.getChildren().add(children);
                    children.setHasParent(true);
                    parent.setHasChildren(true);
                    continue;
                }
            }
        }
        return topNodes;
    }
}
