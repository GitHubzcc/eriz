package com.eriz.common.util;


import com.eriz.common.domain.TreeDo;

import java.util.ArrayList;
import java.util.List;

public class BuildTree {

    public static <T> List<TreeDo<T>> buildList(List<TreeDo<T>> nodes, String idParam) {
        if (nodes == null)
            return null;
        List<TreeDo<T>> topNodes = new ArrayList<>();

        for (TreeDo<T> children : nodes) {
            String pid = children.getParentId();
            if (pid == null || idParam.equals(pid)) {
                topNodes.add(children);
                continue;
            }

            for (TreeDo<T> parent : nodes) {
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
