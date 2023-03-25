import company.RangeList;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
* @Description: test the company.RangeList class functions, including add and remove range.
* @ClassName: RangeListTest
* @Date: 2023-02-19
* @Author: Liguo Niu
*/
public class RangeListTest {

    private List<List<Integer>> resList = new ArrayList<>();

    /**
     * @name: testRangeList_whenAddNullRange_thenReturnOriginList
     * @param: null
     * @return: void
     */
    @Test
    public void testRangeList_whenAddNullRange_thenReturnOriginList() {
        RangeList rangeList = new RangeList();
        rangeList.add(null);
        Assert.assertEquals(resList.size(), 0);
    }

    /**
     * @name: testRangeList_whenAddEmptyRange_thenReturnOriginList
     * @param: null
     * @return: void
     */
    @Test
    public void testRangeList_whenAddEmptyRange_thenReturnOriginList() {
        RangeList rangeList = new RangeList();
        rangeList.add(Arrays.asList());
        Assert.assertEquals(resList.size(), 0);
    }

    /**
     * @name: testRangeList_whenInitRange_thenReturnEmptyString
     * @param: null
     * @return: void
     */
    @Test
    public void testRangeList_whenInitRange_thenReturnEmptyString() {
        RangeList rangeList = new RangeList();
        Assert.assertEquals(0, resList.size());
        Assert.assertEquals("", rangeList.toString());
    }

    /**
     * @name: testRangeList_whenAddRange_thenReturn
     * @param: null
     * @return: void
     */
    @Test
    public void testRangeList_whenAddRange_thenReturn() {
        RangeList rangeList = new RangeList();
        rangeList.add(Arrays.asList(1, 5));
        resList = rangeList.add(Arrays.asList(10, 20));
        Assert.assertEquals(2, resList.size());
        Assert.assertEquals("[1, 5) [10, 20)", rangeList.toString());
    }

    /**
     * @name: testRangeList_whenAddRange_thenReturn1
     * @param: null
     * @return: void
     */
    @Test
    public void testRangeList_whenAddRange_thenReturn1() {
        RangeList rangeList = new RangeList();
        rangeList.add(Arrays.asList(1, 5));
        rangeList.add(Arrays.asList(10, 20));
        resList = rangeList.add(Arrays.asList(20, 20));
        Assert.assertEquals(2, resList.size());
        Assert.assertEquals("[1, 5) [10, 20)", rangeList.toString());
    }

    /**
     * @name: testRangeList_whenAddRange_thenReturn2
     * @param: null
     * @return: void
     */
    @Test
    public void testRangeList_whenAddRange_thenReturn2() {
        RangeList rangeList = new RangeList();
        rangeList.add(Arrays.asList(1, 5));
        rangeList.add(Arrays.asList(10, 20));
        rangeList.add(Arrays.asList(20, 20));
        resList = rangeList.add(Arrays.asList(20, 21));
        Assert.assertEquals(2, resList.size());
        Assert.assertEquals("[1, 5) [10, 21)", rangeList.toString());
    }

    /**
     * @name: testRangeList_whenAddRange_thenReturn3
     * @param: null
     * @return: void
     */
    @Test
    public void testRangeList_whenAddRange_thenReturn3() {
        RangeList rangeList = new RangeList();
        rangeList.add(Arrays.asList(1, 5));
        rangeList.add(Arrays.asList(10, 20));
        rangeList.add(Arrays.asList(20, 20));
        rangeList.add(Arrays.asList(20, 21));
        resList = rangeList.add(Arrays.asList(2, 4));
        Assert.assertEquals(2, resList.size());
        Assert.assertEquals("[1, 5) [10, 21)", rangeList.toString());
    }

    /**
     * @name: testRangeList_whenAddRange_thenReturn4
     * @param: null
     * @return: void
     */
    @Test
    public void testRangeList_whenAddRange_thenReturn4() {
        RangeList rangeList = new RangeList();
        rangeList.add(Arrays.asList(1, 5));
        rangeList.add(Arrays.asList(10, 20));
        rangeList.add(Arrays.asList(20, 20));
        rangeList.add(Arrays.asList(20, 21));
        rangeList.add(Arrays.asList(2, 4));
        resList = rangeList.add(Arrays.asList(3, 8));
        Assert.assertEquals(2, resList.size());
        Assert.assertEquals("[1, 8) [10, 21)", rangeList.toString());
    }

    /**
     * @name: testRangeList_whenRemoveRange_thenReturn
     * @param: null
     * @return: void
     */
    @Test
    public void testRangeList_whenRemoveRange_thenReturn() {
        RangeList rangeList = new RangeList();
        rangeList.add(Arrays.asList(1, 5));
        rangeList.add(Arrays.asList(10, 20));
        rangeList.add(Arrays.asList(20, 20));
        rangeList.add(Arrays.asList(20, 21));
        rangeList.add(Arrays.asList(2, 4));
        rangeList.add(Arrays.asList(3, 8));
        resList = rangeList.remove(Arrays.asList(10, 10));
        Assert.assertEquals(2, resList.size());
        Assert.assertEquals("[1, 8) [10, 21)", rangeList.toString());
    }

    /**
     * @name: testRangeList_whenRemoveRange_thenReturn1
     * @param: null
     * @return: void
     */
    @Test
    public void testRangeList_whenRemoveRange_thenReturn1() {
        RangeList rangeList = new RangeList();
        rangeList.add(Arrays.asList(1, 5));
        rangeList.add(Arrays.asList(10, 20));
        rangeList.add(Arrays.asList(20, 20));
        rangeList.add(Arrays.asList(20, 21));
        rangeList.add(Arrays.asList(2, 4));
        rangeList.add(Arrays.asList(3, 8));
        rangeList.remove(Arrays.asList(10, 10));
        resList = rangeList.remove(Arrays.asList(10, 11));
        Assert.assertEquals(2, resList.size());
        Assert.assertEquals("[1, 8) [11, 21)", rangeList.toString());
    }

    /**
     * @name: testRangeList_whenRemoveRange_thenReturn2
     * @param: null
     * @return: void
     */
    @Test
    public void testRangeList_whenRemoveRange_thenReturn2() {
        RangeList rangeList = new RangeList();
        rangeList.add(Arrays.asList(1, 5));
        rangeList.add(Arrays.asList(10, 20));
        rangeList.add(Arrays.asList(20, 20));
        rangeList.add(Arrays.asList(20, 21));
        rangeList.add(Arrays.asList(2, 4));
        rangeList.add(Arrays.asList(3, 8));
        rangeList.remove(Arrays.asList(10, 10));
        rangeList.remove(Arrays.asList(10, 11));
        resList = rangeList.remove(Arrays.asList(15, 17));
        Assert.assertEquals(3, resList.size());
        Assert.assertEquals("[1, 8) [11, 15) [17, 21)", rangeList.toString());
    }

    /**
     * @name: testRangeList_whenRemoveRange_thenReturn3
     * @param: null
     * @return: void
     */
    @Test
    public void testRangeList_whenRemoveRange_thenReturn3() {
        RangeList rangeList = new RangeList();
        rangeList.add(Arrays.asList(1, 5));
        rangeList.add(Arrays.asList(10, 20));
        rangeList.add(Arrays.asList(20, 20));
        rangeList.add(Arrays.asList(20, 21));
        rangeList.add(Arrays.asList(2, 4));
        rangeList.add(Arrays.asList(3, 8));
        rangeList.remove(Arrays.asList(10, 10));
        rangeList.remove(Arrays.asList(10, 11));
        rangeList.remove(Arrays.asList(15, 17));
        resList = rangeList.remove(Arrays.asList(3, 19));
        Assert.assertEquals(2, resList.size());
        Assert.assertEquals("[1, 3) [19, 21)", rangeList.toString());
    }

    /**
     * @name: testRangeList_whenParallelProcess_thenReturn
     * @param: null
     * @return: void
     * @throws InterruptedException
     */
    @Test
    public void testRangeList_whenParallelProcess_thenReturn() throws InterruptedException {

        ExecutorService threadPoolExecutor = Executors.newFixedThreadPool(10);

        RangeList rangeList = new RangeList();
        threadPoolExecutor.submit(new Runnable() {
            @Override
            public void run() {
                rangeList.add(Arrays.asList(1, 5));
                rangeList.add(Arrays.asList(10, 20));
                rangeList.add(Arrays.asList(20, 20));
            }
        });
        threadPoolExecutor.submit(new Runnable() {
            @Override
            public void run() {
                rangeList.remove(Arrays.asList(10, 10));
                rangeList.remove(Arrays.asList(10, 11));
                rangeList.remove(Arrays.asList(15, 17));
                rangeList.remove(Arrays.asList(3, 19));
                rangeList.add(Arrays.asList(20, 21));
                rangeList.add(Arrays.asList(2, 4));
                rangeList.add(Arrays.asList(3, 8));

            }
        });

        threadPoolExecutor.awaitTermination(3, TimeUnit.SECONDS);
        System.out.println(rangeList.toString());
    }
}
