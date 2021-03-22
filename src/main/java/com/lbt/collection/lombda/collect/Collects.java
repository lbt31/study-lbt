package com.lbt.collection.lombda.collect;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

/**
 * @description:
 * @author: LiBitong
 * @date: 2021-03-22 10:53
 **/
public class Collects {
    public static Set<Integer> set1 = new HashSet<>();
    public static Set<Integer> set2 = new HashSet<>();
    public static List<Sbu> sbuList = new ArrayList<>();

    public static List<Integer> list1 = new ArrayList<>();
    public static List<Integer> list2 = new ArrayList<>();
    public static List<SbuList> sbuLists = new ArrayList<>();

    static {
        set1.addAll(Arrays.asList(1,2,3,4,5,6));
        set2.addAll(Arrays.asList(2,3,5,6,12,13,14));
        sbuList.add(new Sbu(true,set1));
        sbuList.add(new Sbu(true,set2));

        list1.addAll(Arrays.asList(1,2,3,4,5,6));
        list2.addAll(Arrays.asList(2,3,5,6,12,13,14));
        sbuLists.add(new SbuList(true,list1));
        sbuLists.add(new SbuList(true,list2));
    }


    public static void main(String[] args) {
        HashSet<Integer> collect = sbuList.stream().filter(sub -> sub.getF())
                .map(Sbu :: getSet).collect(HashSet::new, HashSet::addAll, HashSet::addAll);
        System.out.println(collect);

        List<Integer> list = sbuLists.stream().filter(sub -> sub.getF())
                .map(SbuList :: getSet).collect(ArrayList :: new, ArrayList::addAll, ArrayList::addAll);
        System.out.println(list);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Sbu{
        private Boolean f;
        private Set<Integer> set;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SbuList{
        private Boolean f;
        private List<Integer> set;
    }


}
