/*
 * Copyright (c) 2005 Sun Microsystems, Inc. All rights reserved. Use is subject to license terms.
 */
/*VCSID=33ff3576-047e-48a4-8202-afb79c8d4c3c*/
package test.com.sun.max.collect;

import java.util.*;

import com.sun.max.collect.*;
import com.sun.max.ide.*;

/**
 * Tests for {@link ArraySequence}.
 *
 * @author Hiroshi Yamauchi
 */
public class ArraySequenceTest extends MaxTestCase {
    
    public ArraySequenceTest(String name) {
        super(name);
    }
    
    public static void main(String[] args) {
        junit.textui.TestRunner.run(ArraySequenceTest.class);
    }

    private AppendableSequence<Integer> makeIntegerArraySequence(int nElements) {
        final Integer[] array = new Integer[nElements];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Integer(i);
        }
        return new ArrayListSequence<Integer>(array);
    }
        
    public void test_length() {
        final AppendableSequence<Integer> seq1 = makeIntegerArraySequence(99);
        final AppendableSequence<Integer> seq2 = makeIntegerArraySequence(99);
        final AppendableSequence<Integer> seq3 = makeIntegerArraySequence(100);
        final AppendableSequence<Integer> seq4 = makeIntegerArraySequence(0);
        assertTrue(seq1.length() == seq2.length());
        assertTrue(seq1.length() != seq3.length());
        assertTrue(seq2.length() + 1 == seq3.length());
        assertTrue(seq4.length() == 0);
    }
    
    public void test_isEmpty() {
        final AppendableSequence<Integer> seq1 = new ArrayListSequence<Integer>();
        final AppendableSequence<Integer> seq2 = new ArrayListSequence<Integer>(new Integer(3));
        final AppendableSequence<Integer> seq3 = makeIntegerArraySequence(100);
        assertTrue(seq1.isEmpty());
        assertTrue(!seq2.isEmpty());
        assertTrue(!seq3.isEmpty());
    }
    
    public void test_get() {
        final AppendableSequence<Integer> seq1 = makeIntegerArraySequence(99);
        for (int i = 0; i < 99; i++) {
            assertTrue(seq1.get(i) == i);
        }
    }

    public void test_first_and_last() {
        final AppendableSequence<Integer> seq1 = makeIntegerArraySequence(99);
        assertTrue(seq1.first() == 0);
        assertTrue(seq1.last() == 98);
    }
    
    public void test_contains() {
        final AppendableSequence<Integer> seq1 = makeIntegerArraySequence(99);
        for (int i = 0; i < 99; i++) {
            assertTrue(Sequence.Static.containsEqual(seq1, new Integer(i)));
        }
    }
    
    public void test_add() {
        final AppendableSequence<Integer> seq1 = makeIntegerArraySequence(0);
        final AppendableSequence<Integer> seq2 = makeIntegerArraySequence(0);
        final AppendableSequence<Integer> seq3 = makeIntegerArraySequence(99);
        assertTrue(seq1.equals(seq2));
        for (int i = 0; i < 95; i++) {
            seq1.append(new Integer(i));
            seq2.append(new Integer(i));
            assertTrue(seq1.equals(seq2));
        }
        AppendableSequence.Static.appendAll(seq1, new Integer(95), new Integer(96), new Integer(97), new Integer(98));
        assertTrue(seq1.equals(seq3));
    }
    
    public void test_equals() {
        final AppendableSequence<Integer> seq1 = makeIntegerArraySequence(99);
        final AppendableSequence<Integer> seq2 = makeIntegerArraySequence(99);
        final AppendableSequence<Integer> seq3 = makeIntegerArraySequence(100);
        assertTrue(seq1.equals(seq2));
        assertTrue(!seq2.equals(seq3));
        seq2.get(34);
        final AppendableSequence<Integer> seq4 = new ArrayListSequence<Integer>();
        final AppendableSequence<Integer> seq5 = new ArrayListSequence<Integer>();
        assertTrue(seq4.equals(seq5));
        seq4.append(new Integer(123));
        seq5.append(new Integer(123));
        assertTrue(seq4.equals(seq5));
        seq4.append(new Integer(456));
        assertTrue(!seq4.equals(seq5));
        seq5.append(new Integer(789));
        assertTrue(!seq4.equals(seq5));
    }
    
    public void test_clone() {
        final Sequence<Integer> seq1 = makeIntegerArraySequence(128);
        final Sequence<Integer> seq2 = seq1.clone();
        assertTrue(seq1.equals(seq2));
        
    }
    
    public void test_iterator() {
        final AppendableSequence<Integer> seq1 = makeIntegerArraySequence(128);
        int sum = 0;
        for (final Iterator<Integer> it = seq1.iterator(); it.hasNext();) {
            final Integer elem = it.next();
            sum += elem;
        }
        assertTrue(sum == 127 * 128 / 2);
    }
}
