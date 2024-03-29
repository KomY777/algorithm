package test;

import java.util.ArrayList;

public class seqList implements List{
    ArrayList list = new ArrayList();
    @Override
    public void insert(int i, Object obj) throws Exception {
        list.add(i, obj);
    }

    @Override
    public Object delete(int i) throws Exception {
        return list.remove(list.get(i));
    }

    @Override
    public Object getData(int i) throws Exception {
        return list.get(i);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
