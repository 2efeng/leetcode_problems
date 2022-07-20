package com.hzf.leetcode._0731;

/**
 * 731. 我的日程安排表 II
 * 实现一个 MyCalendar 类来存放你的日程安排。如果要添加的时间内不会导致三重预订时，则可以存储这个新的日程安排。
 * MyCalendar 有一个 book(int start, int end)方法。它意味着在 start 到 end 时间内增加一个日程安排，
 * 注意，这里的时间是半开区间，即 [start, end), 实数 x 的范围为，  start <= x < end。
 * 当三个日程安排有一些时间上的交叉时（例如三个日程安排都在同一时间内），就会产生三重预订。
 * 每次调用 MyCalendar.book方法时，如果可以将日程安排成功添加到日历中而不会导致三重预订，返回 true。否则，返回 false 并且不要将该日程安排添加到日历中。
 * 请按照以下步骤调用MyCalendar 类: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)
 * <p>
 * https://leetcode.cn/problems/my-calendar-ii/
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
public class MyCalendarTwo {


    public static void main(String[] args) {
        //[[],]
        MyCalendarTwo calendar = new MyCalendarTwo();
        System.out.println(calendar.book(28, 46));//true
        System.out.println(calendar.book(9, 21));//true
        System.out.println(calendar.book(21, 39));//true
        System.out.println(!calendar.book(37, 48));//false
        System.out.println(!calendar.book(38, 50));//false
        System.out.println(!calendar.book(22, 39));//false
        System.out.println(calendar.book(45, 50));//true
        System.out.println(calendar.book(1, 12));//true
        System.out.println(!calendar.book(40, 50));//false
        System.out.println(!calendar.book(31, 44));//false

    }

    public List<List<Integer>> calendarList;
    public List<List<Integer>> repetitionList;

    public MyCalendarTwo() {
        calendarList = new ArrayList<>();
        repetitionList = new ArrayList<>();
    }

    public boolean book(int start, int end) {

        //查看有没有重复的
        for (List<Integer> repetition : repetitionList) {
            if (start >= repetition.get(0) && start < repetition.get(1)) {
                return false;
            } else if (end > repetition.get(0) && end <= repetition.get(1)) {
                return false;
            } else if (start < repetition.get(0) && end > repetition.get(1)) {
                return false;
            }
        }

        //添加重复区间
        for (List<Integer> calendar : calendarList) {
            if (start >= calendar.get(0) && start < calendar.get(1)) {
                List<Integer> repetition = new ArrayList<>();
                repetition.add(start);
                if (calendar.get(1) < end) repetition.add(calendar.get(1));
                else repetition.add(end);
                repetitionList.add(repetition);

            } else if (end > calendar.get(0) && end <= calendar.get(1)) {
                List<Integer> repetition = new ArrayList<>();
                if (calendar.get(0) > start) repetition.add(calendar.get(0));
                else repetition.add(start);
                repetition.add(end);
                repetitionList.add(repetition);
            } else if (start < calendar.get(0) && end > calendar.get(1)) {
                List<Integer> repetition = new ArrayList<>();
                repetition.add(calendar.get(0));
                repetition.add(calendar.get(1));
                repetitionList.add(repetition);
            }
        }
        calendarList.add(List.of(start, end));
        return true;
    }
}
