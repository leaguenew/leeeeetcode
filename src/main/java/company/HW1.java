package company;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @description: task finished total time
 * @className: Main
 * @author: Liguo Niu
 * @Date: 2023-02-23
 */
public class HW1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cpus = sc.nextInt();
        int tasks = sc.nextInt();
        PriorityQueue<Integer> leftTasks = new PriorityQueue<>(); //left tasks to be processed
        int[] processingTasks = new int[cpus];

        for(int i = 0 ; i < tasks; i++) {
            int time = sc.nextInt();
            leftTasks.add(time);
        }
        if (cpus >= tasks) {
            System.out.println(findLargest(leftTasks));
            return;
        }

        int totalTime = 0;
        //init tasks
        for (int i = 0 ; i < cpus; i++) {
            int task = leftTasks.poll();
            processingTasks[i] = task;
        }
        int minTaskIdx = findMinTaskIdx(processingTasks);
        totalTime += processingTasks[minTaskIdx];
        updateCurrentTask(processingTasks, processingTasks[minTaskIdx]);

        //processing left task
        while (!leftTasks.isEmpty()) {
            int task = leftTasks.poll();
            processingTasks[minTaskIdx] = task;
            minTaskIdx = findMinTaskIdx(processingTasks);
            totalTime += processingTasks[minTaskIdx];
            updateCurrentTask(processingTasks, processingTasks[minTaskIdx]);
        }//while

        //sum the result when there is no task left in the queue
        totalTime += findLargestFromArr(processingTasks);

        //print the result
        System.out.println(totalTime);
    }

    /**
     * @description: find the largest value of all left tasks
     * @param arr
     * @return current largest task
     */
    public static int findLargestFromArr(int[] arr) {

        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < arr.length; i++) {
            max = Math.max(arr[i], max);
        }

        return max;
    }

    /**
     * @description: find the current largest task
     * @param tasks
     * @return current largest task
     */
    public static int findLargest( PriorityQueue<Integer> tasks) {
        int max = Integer.MIN_VALUE;
        for(Integer task :tasks) {
            max = Math.max(task, max);
        }

        return max;
    }

    /**
     * @description: find min task index
     * @param arr
     * @return min task index
     */
    public static int findMinTaskIdx(int[] arr) {

        int minVal = Integer.MAX_VALUE;
        int idx = 0;
        for(int i = 0 ; i < arr.length; i++) {
            if (arr[i] < minVal) {
                minVal = arr[i];
                idx = i;
            }
        }

        return idx;
    }

    /**
     * @description: update current tasks time
     * @param processingTasks
     * @param diff
     * @return void
     */
    public static void updateCurrentTask(int[] processingTasks, int diff) {
        for(int i = 0 ; i < processingTasks.length; i++) {
            processingTasks[i] -= diff;
        }
    }
}
