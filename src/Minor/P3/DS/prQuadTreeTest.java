package Minor.P3.DS;

import static org.junit.Assert.*;
import java.util.Vector;
import org.junit.Test;
import Minor.P3.Client.Point;

public class prQuadTreeTest
{

    @Test
    public void testFind()
    {
        prQuadTree<Point> testQuad = new prQuadTree<Point>(-10, 10, -10, 10);
        Point p = new Point();

// _________________________________________________________FIND_____________________________________________________________________
        // case 1: is current Node null?
        assertNull(testQuad.find(p));

        // case 2: is element null?
        assertNull(testQuad.find(null));

        // case 3: is element in world?
        assertNull(testQuad.find(new Point(-20, -20)));

        // case 4: check quadrants

        // 4a: setup
        testQuad.root = testQuad.new prQuadInternal();
        ((prQuadTree.prQuadInternal)testQuad.root).NE =
            testQuad.new prQuadLeaf(new Point(5, 5));
        ((prQuadTree.prQuadInternal)testQuad.root).NW =
            testQuad.new prQuadLeaf(new Point(-5, 5));
        ((prQuadTree.prQuadInternal)testQuad.root).SE =
            testQuad.new prQuadLeaf(new Point(5, -5));
        ((prQuadTree.prQuadInternal)testQuad.root).SW =
            testQuad.new prQuadLeaf(new Point(-5, -5));

        // 4b: test quadrant1: NE
        p = new Point(5, 5);
        assertEquals(testQuad.find(new Point(5, 5)), p);
        // 4c: test quadrant2: NW
        p = new Point(-5, 5);
        assertEquals(testQuad.find(new Point(-5, 5)), p);
        // 4d: test quadrant3: SW
        p = new Point(-5, -5);
        assertEquals(testQuad.find(new Point(-5, -5)), p);
        // 4e: test quadrant3: SE
        p = new Point(5, -5);
        assertEquals(testQuad.find(new Point(5, -5)), p);

        // case 5: elem not in tree
        p = new Point(0, 0);
        assertNull(testQuad.find(p));

// _________________________________________________________INSERT_____________________________________________________________________

        prQuadTree<Point> testQuad2 = new prQuadTree<Point>(-4, 4, -4, 4);
        Point k = new Point(0, 0);

        assertTrue(testQuad2.insert(k));
        assertTrue(testQuad2.find(k).equals(k));

        Point l = new Point(2, 2);
        Point m = new Point(2, 2);
        assertTrue(testQuad2.insert(l));
        assertFalse(testQuad2.insert(m));
// _________________________________________________________DELETE / VECTOR
// FIND________________________________________________________

        assertTrue(testQuad2.delete(l));
        assertFalse(testQuad2.delete(new Point(20, 20)));

        prQuadTree<Point> testQuad3 = new prQuadTree<Point>(-32, 32, -32, 32);

        Point aa = new Point(-24, 24);
        assertTrue(testQuad3.insert(aa));
        Point bb = new Point(-24, 8);
        assertTrue(testQuad3.insert(bb));
        Point cc = new Point(-24, -8);
        assertTrue(testQuad3.insert(cc));
        Point dd = new Point(-24, -24);
        assertTrue(testQuad3.insert(dd));
        Point ee = new Point(-8, 24);
        assertTrue(testQuad3.insert(ee));
        Point ff = new Point(-8, 8);
        assertTrue(testQuad3.insert(ff));
        Point gg = new Point(-8, -8);
        assertTrue(testQuad3.insert(gg));
        Point hh = new Point(-8, -24);
        assertTrue(testQuad3.insert(hh));
        Point ii = new Point(8, 24);
        assertTrue(testQuad3.insert(ii));
        Point jj = new Point(8, 8);
        assertTrue(testQuad3.insert(jj));
        Point kk = new Point(8, -8);
        assertTrue(testQuad3.insert(kk));
        Point ll = new Point(8, -24);
        assertTrue(testQuad3.insert(ll));
        Point mm = new Point(24, 24);
        assertTrue(testQuad3.insert(mm));
        Point nn = new Point(24, 8);
        assertTrue(testQuad3.insert(nn));
        Point oo = new Point(24, -8);
        assertTrue(testQuad3.insert(oo));
        Point pp = new Point(24, -24);
        assertTrue(testQuad3.insert(pp));

        System.out.println("6");
        Vector<Point> vector = testQuad3.find(-32, 0, 0, 32); // ----
        assertEquals(4, vector.size()); // |
        Vector<Point> vector2 = testQuad3.find(-2, 37, 0, 32);// Implement
        assertEquals(4, vector.size()); // ----

        System.out.println("7");

        assertTrue(testQuad3.delete(aa));
        assertTrue(testQuad3.delete(bb));
        System.out.println("7.5");
        assertTrue(testQuad3.delete(cc));
        assertTrue(testQuad3.delete(dd));
        assertTrue(testQuad3.delete(ee));
        assertTrue(testQuad3.delete(hh));
        assertTrue(testQuad3.delete(ii));
        assertTrue(testQuad3.delete(ll));
        assertTrue(testQuad3.delete(mm));
        assertTrue(testQuad3.delete(nn));
        assertTrue(testQuad3.delete(oo));
        assertTrue(testQuad3.delete(pp));
        assertTrue(testQuad3.delete(ff));
        assertTrue(testQuad3.delete(gg));
        assertTrue(testQuad3.delete(jj));

        System.out.println("8");
        assertFalse(testQuad3.delete(aa)); // ERROR HERE
        // not deleting the last element correctly
        System.out.println("9");



    }
    @Test
    public void testFind2() {
        prQuadTree<Point> testQuad = new prQuadTree<>(-10, 10, -10, 10);
        Point p = new Point();

        // case 1: is current Node null?
        assertNull(testQuad.find(p));

        // case 2: is element null?
        assertNull(testQuad.find(null));

        // case 3: is element in world?
        assertNull(testQuad.find(new Point(-20, -20)));

        // case 4: check quadrants

        // 4a: setup
        testQuad.root = testQuad.new prQuadInternal();
        ((prQuadTree.prQuadInternal) testQuad.root).NE = testQuad.new prQuadLeaf(
                new Point(5, 5));
        ((prQuadTree.prQuadInternal) testQuad.root).NW = testQuad.new prQuadLeaf(
                new Point(-5, 5));
        ((prQuadTree.prQuadInternal) testQuad.root).SE = testQuad.new prQuadLeaf(
                new Point(5, -5));
        ((prQuadTree.prQuadInternal) testQuad.root).SW = testQuad.new prQuadLeaf(
                new Point(-5, -5));

        // 4b: test quadrant1: NE
        p = new Point(5, 5);
        assertEquals(testQuad.find(new Point(5, 5)), p);
        // 4c: test quadrant2: NW
        p = new Point(-5, 5);
        assertEquals(testQuad.find(new Point(-5, 5)), p);
        // 4d: test quadrant3: SW
        p = new Point(-5, -5);
        assertEquals(testQuad.find(new Point(-5, -5)), p);
        // 4e: test quadrant3: SE
        p = new Point(5, -5);
        assertEquals(testQuad.find(new Point(5, -5)), p);

        // case 5: elem not in tree
        p = new Point(0, 0);
        assertNull(testQuad.find(p));
    }

    @Test
    public void testInsert() {

        prQuadTree<Point> testQuad2 = new prQuadTree<>(-4, 4, -4, 4);
        Point k = new Point(0, 0);

        assertTrue(testQuad2.insert(k));
        assertTrue(testQuad2.find(k).equals(k));

        Point l = new Point(2, 2);
        Point m = new Point(2, 2);
        assertTrue(testQuad2.insert(l));
        assertFalse(testQuad2.insert(m));

        assertTrue(testQuad2.delete(l));
        assertFalse(testQuad2.delete(new Point(20, 20)));
    }

    @Test
    public void testDelete() {
        prQuadTree<Point> testQuad3 = new prQuadTree<>(-32, 32, -32, 32);

        Point aa = new Point(-24, 24);
        assertTrue(testQuad3.insert(aa));
        Point bb = new Point(-24, 8);
        assertTrue(testQuad3.insert(bb));
        Point cc = new Point(-24, -8);
        assertTrue(testQuad3.insert(cc));
        Point dd = new Point(-24, -24);
        assertTrue(testQuad3.insert(dd));
        Point ee = new Point(-8, 24);
        assertTrue(testQuad3.insert(ee));
        Point ff = new Point(-8, 8);
        assertTrue(testQuad3.insert(ff));
        Point gg = new Point(-8, -8);
        assertTrue(testQuad3.insert(gg));
        Point hh = new Point(-8, -24);
        assertTrue(testQuad3.insert(hh));
        Point ii = new Point(8, 24);
        assertTrue(testQuad3.insert(ii));
        Point jj = new Point(8, 8);
        assertTrue(testQuad3.insert(jj));
        Point kk = new Point(8, -8);
        assertTrue(testQuad3.insert(kk));
        Point ll = new Point(8, -24);
        assertTrue(testQuad3.insert(ll));
        Point mm = new Point(24, 24);
        assertTrue(testQuad3.insert(mm));
        Point nn = new Point(24, 8);
        assertTrue(testQuad3.insert(nn));
        Point oo= new Point(24, -8);
        assertTrue(testQuad3.insert(oo));
        Point pp = new Point(24, -24);
        assertTrue(testQuad3.insert(pp));

        Vector<Point> vector = testQuad3.find(-32, 0, 0, 32);
        assertEquals(4, vector.size());
        assertEquals(4, vector.size());

        assertTrue(testQuad3.delete(aa));
        assertTrue(testQuad3.delete(bb));
        assertTrue(testQuad3.delete(cc));
        assertTrue(testQuad3.delete(dd));
        assertTrue(testQuad3.delete(ee));
        assertTrue(testQuad3.delete(hh));
        assertTrue(testQuad3.delete(ii));
        assertTrue(testQuad3.delete(ll));
        assertTrue(testQuad3.delete(mm));
        assertTrue(testQuad3.delete(nn));
        assertTrue(testQuad3.delete(oo));
        assertTrue(testQuad3.delete(pp));
        assertTrue(testQuad3.delete(ff));
        assertTrue(testQuad3.delete(gg));
        assertTrue(testQuad3.delete(jj));

        assertFalse(testQuad3.delete(aa));
    }
}
