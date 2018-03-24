package com.seregamorph.c;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SimpleTest {

    @Test
    public void testSmallAllImpls() {
        checkAll(1, 1);
        checkAll(2, 2);
        checkAll(3, 3);
        checkAll(4, 5);
        checkAll(5, 7);
        checkAll(6, 11);
        checkAll(7, 13);
        checkAll(8, 17);
        checkAll(9, 19);
        checkAll(10, 23);
        checkAll(11, 29);
        checkAll(12, 31);
        checkAll(13, 37);
        checkAll(14, 41);
        checkAll(15, 43);
        checkAll(16, 47);
        checkAll(17, 53);
        checkAll(18, 59);
        checkAll(19, 61);
        checkAll(20, 67);

        checkAll(500, 3559);
        checkAll(501, 3571);
    }

    @Test
    public void testBasicBig1() {
        // 16s
        assertEquals(27_644_437, Simple.basicSimpleInt(1_720_726, true));
    }

    @Test
    public void testArrayBig1() {
        // 4s
        assertEquals(27_644_437, Simple.arraySimpleInt(1_720_726, true));
    }

    @Test
    public void testBasicBig2() {
        // 32s
        assertEquals(45_561_077, Simple.basicSimpleInt(2_750_142, true));
    }

    @Test
    public void testArrayBig2() {
        // 8s
        assertEquals(45_561_077, Simple.arraySimpleInt(2_750_142, true));
    }

    @Test
    @Ignore // too long
    public void testBasicBig3() {
        //
        assertEquals(373_587_839, Simple.basicSimpleInt(20_000_000, true));
    }

    @Test
    public void testArrayBig3() {
        // 2m36s
        assertEquals(373_587_839, Simple.arraySimpleInt(20_000_000, true));
    }

    @Test
    public void testArrayBig4() {
        // 27m35s
        assertEquals(2_038_074_739, Simple.arraySimpleInt(100_000_000, true));
    }

    @Test
    public void testIntArrayBig5() {
        // maximum int
        // 30m
        assertEquals(2_147_483_647, Simple.arraySimpleInt(105_097_566, true));
    }

    @Test
    public void testLongArrayBig6() {
        // more than maximum int - long
        // 1h30m
        assertEquals(2_147_483_659L, Simple.arraySimpleLong(105_097_567, true));
    }

    private static void checkAll(int n, int expected) {
        assertEquals(expected, Simple.basicSimpleInt(n, true));
        assertEquals(expected, Simple.basicSimpleLong(n, true));
        assertEquals(expected, Simple.arraySimpleInt(n, true));
        assertEquals(expected, Simple.arraySimpleIntSqr(n, true));
        assertEquals(expected, Simple.arraySimpleLong(n, true));
    }
}
