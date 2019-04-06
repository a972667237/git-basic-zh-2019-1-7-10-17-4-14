package cn.school.thoughtworks.section1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PracticeA {
    private int indexOf(char c) {
        return c - 'A';
    }

    private final long bitUpdate(long bitmap, int updated_index) {
        return bitmap | (long)1 << updated_index;
    }

    private final boolean isIndexActive(long bitmap, int index) {
        System.out.println((bitmap >> index) & 1);
        return ((bitmap >> index) & 1) == 1;
    }

    List<String> collectSameElements(List<String> collection1, List<String> collection2) {
        //实现练习要求，并改写该行代码。
        // using bit map?
        // assume that collection1 and collection2 only have english alphabet
        System.out.println(collection1);
        System.out.println(collection2);
        long bitmap = 0;
        List<String> same_list = new ArrayList<String>();
        Iterator<String> collection_setter_iter, collection_filter_iter;
        collection_setter_iter = collection2.iterator();
        collection_filter_iter = collection1.iterator();

        // start iter bigger
        while(collection_setter_iter.hasNext()) {
            int char_index = indexOf(collection_setter_iter.next().charAt(0));
            bitmap = bitUpdate(bitmap, char_index);
        }

        // start iter smaller
        while(collection_filter_iter.hasNext()) {
            String now_item = collection_filter_iter.next();
            int char_index = indexOf(now_item.charAt(0));
            if (isIndexActive(bitmap, char_index)) {
                same_list.add(now_item);
            }
        }
        return same_list;
    }
}
