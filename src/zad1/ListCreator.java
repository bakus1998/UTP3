package zad1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class ListCreator <T>{ // Uwaga: klasa musi być sparametrtyzowana

    public List<T> myList;

    public ListCreator(List<T> myList) {
        this.myList = myList;
    }


    //Selector wybiera liczby wg Selectora
    public ListCreator<T> when(Predicate<T> sel) {
        List<T> whenList = new ArrayList<>();

        for(int i=0; i<myList.size(); i++) {
            if(sel.test(myList.get(i))) {
                whenList.add(myList.get(i));
            }
        }
        myList = whenList;
        return this;
    }


    //mapper zmiana wartosci
    public <S> List <S> mapEvery(Function<T,S> myMap){
        List <S> mapList = new ArrayList<>();
        for (int i=0; i<myList.size(); i++){
            mapList.add(myMap.apply(myList.get(i)));
        }
        return mapList;
    }


    public static <T> ListCreator<T> collectFrom(List<T> list) {
        ListCreator<T> creator = new ListCreator<>(list);
        return creator;
    }
}
