package jasm.util.collect;

import jasm.util.lang.ArrayUtil;
import jasm.util.lang.StaticLoophole;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class CollectionUtil {

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

  public static <Element_Type> Set<Element_Type> hashSetFrom(Element_Type... elements) {
      return new HashSet<Element_Type>(Arrays.asList(elements));
  }
}
