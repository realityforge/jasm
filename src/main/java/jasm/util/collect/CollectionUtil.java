package jasm.util.collect;

import java.util.List;
import java.util.ArrayList;
import jasm.util.lang.ArrayUtil;
import jasm.util.lang.StaticLoophole;

public class CollectionUtil {

  /**
         * Returns true if {@code sequence} contains an element identical to {@code value}. More formally, returns true
   * if and only if {@code sequence} contains at least one element {@code e} such that
   * {@code (value == e)}.
   */
  public static boolean containsIdentical(List sequence, Object value) {
      for (Object element : sequence) {
          if (element == value) {
              return true;
          }
      }
      return false;
  }

  /**
         * Returns true if {@code sequence} contains an element equal to {@code value}. More formally, returns true
   * if and only if {@code sequence} contains at least one element {@code e} such that
   * {@code (value == null ? e == null : value.equals(e))}.
   */
  public static boolean containsEqual(List sequence, Object value) {
      for (Object element : sequence) {
          if (element.equals(value)) {
              return true;
          }
      }
      return false;
  }

  /**
         * Returns the index in {@code sequence} of the first occurrence identical to {@code value}, or -1 if
   * {@code sequence} does not contain {@code value}. More formally, returns the lowest index
   * {@code i} such that {@code (sequence.get(i) == value)}, or -1 if there is no such index.
   */
  public static int indexOfIdentical(List sequence, Object value) {
      int i = 0;
      for (Object element : sequence) {
          if (element == value) {
              return i;
          }
          ++i;
      }
      return -1;
  }

  public static <Element_Type> Element_Type[] toArray(List<? extends Element_Type> sequence, Class<Element_Type> elementType) {
      final Element_Type[] array = StaticLoophole.cast(ArrayUtil.create(elementType, sequence.size()));
      for (int i = 0; i < array.length; i++) {
          array[i] = sequence.get(i);
      }
      return array;
  }

  /**
         * Extracts the elements from a given sequence that are {@linkplain Class#isInstance(Object) instances of} a given class
   * and returns them in a new sequence.
   */
  public static <Element_Type, Sub_Type extends Element_Type> ArrayList<Sub_Type> filter(Iterable<Element_Type> sequence, Class<Sub_Type> subType) {
      final ArrayList<Sub_Type> result = new ArrayList<Sub_Type>();
      for (Element_Type element : sequence) {
          if (subType.isInstance(element)) {
              result.add(subType.cast(element));
          }
      }
      return result;
  }
}
