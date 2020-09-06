package com.company;

import java.util.LinkedHashSet;
import java.util.Objects;

public class Multitude{

     private LinkedHashSet<Object> mMultitudeSet;

     public Multitude() {
          this.mMultitudeSet = new LinkedHashSet<>();
     }

     public Multitude(LinkedHashSet<Object> mMultitudeSet) {
          this.mMultitudeSet = mMultitudeSet;
     }



     public void addToMultitude(Object o){
          mMultitudeSet.add(o);
     }

     public boolean isEmpty(){
          return mMultitudeSet.isEmpty();
     }

     // Возвращает мощность множества
     public int getSize(){
          return mMultitudeSet.size();
     }

     // Возвращает true если все окк
     public boolean deleteItem(int index){
          if(index < getSize()){
               mMultitudeSet.remove(index);
               return true;
          }
          return false;
     }

     // проверяет сузествует ли элемент во множестве
     //TODO text this dich
     public boolean isConsistObject(Object o){
          return mMultitudeSet.contains(o);
     }

     // обьеденение множество, возвращает новое множество
     //TODO test
     public Multitude union(Multitude multitude){
          LinkedHashSet<Object> unitedSet = new LinkedHashSet<>();
          unitedSet.addAll(this.mMultitudeSet);

          unitedSet.addAll(multitude.mMultitudeSet);
          return new Multitude(unitedSet);
     }

     // Возвращяет новое множнство составленое из пересечения множеств
     //TODO test
     public Multitude intersection(Multitude multitude){
          LinkedHashSet<Object> intersectionSet = new LinkedHashSet<>();
          for(Object o : multitude.mMultitudeSet){
               for(Object obj : this.mMultitudeSet){
                    if(o.equals(obj)){
                         intersectionSet.add(o);
                         break;
                    }
               }
          }
          return new Multitude(intersectionSet);
     }

     // Возвращяет новое множнство составленое из разности множеств
     public Multitude difference(Multitude multitude){
          LinkedHashSet<Object> differenceList = new LinkedHashSet<>(this.mMultitudeSet);
          for(Object o : multitude.mMultitudeSet){
               for(Object obj : differenceList){
                    if(o.equals(obj)){
                         differenceList.remove(o);
                         break;
                    }
               }
          }
          return new Multitude(differenceList);
     }

     public Multitude booleanMultiple() {
          Multitude result = new Multitude();
          //int sizeNewMultitude = (int) Math.pow(2, this.getSize());

          for (int i = 0; i <= this.getSize(); i++) {

               int[] neededNums = new int[i];
               for (int q = 0; q < i; q++) {
                    neededNums[q] = q;
               }


               boolean isContinue = true;
               while (isContinue) {
                    //сдесь должен быть код который добавлянт item если он в neededNums и изменять neededNums
                    LinkedHashSet<Object> objectLinkedHashSet = new LinkedHashSet<>();
                    for (int j = 0; j < neededNums.length; j++) {
                         objectLinkedHashSet.add(this.mMultitudeSet.toArray()[neededNums[j]]);
                    }
                    isContinue = checkIsOverflow(neededNums);
                    neededNums = getIncreasedNums(neededNums);

                    result.addToMultitude(new Multitude(objectLinkedHashSet));


               }

          }
          return result;
          //TODO бописать все
     }

     private int[] getIncreasedNums(int[] neededNum) {
          if (neededNum.length == 0) return neededNum;
          for(int i = neededNum.length - 1; i >= 0; i--){
               if (neededNum[i] < this.getSize() - 1){
                    neededNum[i]++;
                    if(i != neededNum.length - 1){
                         int j = i;
                         while (j + 1 <= neededNum.length - 1 && neededNum[j] + 1 < this.getSize() - 1){
                              neededNum[j+1] = neededNum[j] + 1;
                              j++;
                         }

                    }
                    return neededNum;
               }
          }


          return neededNum;
     }

     private boolean checkIsOverflow(int[] numArray) {
          if(numArray.length == 0 || numArray.length >= this.getSize()) return false;
          for(int i  = 0; i < numArray.length; i++){
               if(numArray[i] != this.getSize() - numArray.length + i) {
                    return true;
               }
          }
          //if(numArray.length == 0) return false;
          return false;
     }


     // TODO test this dish
     @Override
     public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || getClass() != o.getClass()) return false;
          Multitude multitude = (Multitude) o;
          return Objects.equals(mMultitudeSet, multitude.mMultitudeSet);
     }

     @Override
     public int hashCode() {
          return Objects.hash(mMultitudeSet);
     }

     @Override
     public String toString() {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("{");
          if(!this.isEmpty()){
               for(Object o : this.mMultitudeSet){
                    stringBuilder.append(o.toString()).append(", ");
               }

               stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length() - 1);
          }

          stringBuilder.append("}");

          return stringBuilder.toString();
     }
}
