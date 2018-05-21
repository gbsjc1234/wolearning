package top.wolearning.areas.sysManage.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ArticalNode {
    private String title;
    private String childrenKey;
    private List<ArticalNode> children = null;



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getChildrenKey() {
        return childrenKey;
    }

    public void setChildrenKey(String childrenKey) {
        this.childrenKey = childrenKey;
    }

    public List<ArticalNode> getChildren() {
        return children;
    }

    public void setChildren(List<ArticalNode> children) {
       this.children = children;
    }
}
