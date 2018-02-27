package com.recklessMo.test;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by hpf on 12/1/17.
 */
public class Test {

    private List<SubClass> subClassList = new LinkedList<>();
    private List<Integer> timeValueList = new LinkedList<>();
    private List<Teacher> teacherList = new LinkedList<>();
    private List<Course> courseList = new LinkedList<>();
    private List<Room> roomList = new LinkedList<>();
    private List<Lecture> lectureList = new LinkedList<>();
    private List<Period> periodList = new LinkedList<>();

    private int[][][] timeTable;
    private long[][][] timeTableValue;

    private Map<Integer, Map<Long, Set<Long>>> classMap;
    private Map<Integer, Map<Long, Set<Long>>> teacherMap;

    Random random = new Random(0);

    private <T> T getRandom(List<T> data) {
        int len = data.size();
        return data.get(random.nextInt(len));
    }


    public Test() {
        timeValueList.add(1);
        timeValueList.add(2);
        timeValueList.add(3);
        timeValueList.add(4);
        //初始化subclassList
        for (int i = 0; i < 40; i++) {
            subClassList.add(new SubClass(i, "class_" + i, random.nextInt(100)));
        }
        //初始化room
        roomList.add(new Room(1, "101", 140));
        roomList.add(new Room(2, "102", 140));
        roomList.add(new Room(3, "103", 90));
        roomList.add(new Room(4, "104", 90));
        roomList.add(new Room(5, "105", 30));
        roomList.add(new Room(6, "106", 30));
        //初始化period
        periodList.add(new Period(1, "上午1-2", 2, 0));
        periodList.add(new Period(2, "上午3-4", 2, 0));
        periodList.add(new Period(3, "上午5", 1, 0));
        periodList.add(new Period(4, "下午1-2", 2, 1));
        periodList.add(new Period(5, "下午3", 1, 1));
        periodList.add(new Period(6, "晚上1-2", 2, 2));
        periodList.add(new Period(7, "晚上3-4", 2, 2));
        //初始化课程
        for (int i = 0; i < 50; i++) {
            courseList.add(new Course(i, "course_" + i));
        }
        //老师
        for (int i = 0; i < 20; i++) {
            teacherList.add(new Teacher(i, "teacher_" + i));
        }
        //初始化对应关系
        for (int i = 0; i < 90; i++) {
            Lecture temp = new Lecture(i, getRandom(teacherList), getRandom(courseList), getRandom(timeValueList));
            temp.addGroup(getRandom(subClassList));
            lectureList.add(temp);
        }
        //timeTable
        timeTable = new int[5][periodList.size()][roomList.size()];
        timeTableValue = new long[5][periodList.size()][roomList.size()];
        //map
        classMap = new HashMap<>();
        teacherMap = new HashMap<>();
    }

    private void printAnswer() {
        for (int i = 0; i < 5; i++) {
            for (int row = 0; row < periodList.size(); row++) {
                for (int col = 0; col < roomList.size(); col++) {
                    System.out.print(timeTableValue[i][row][col] + "    ");
                }
                System.out.println("");
            }
            System.out.println("");
            System.out.println("");
            System.out.println("-----------------------");
            System.out.println("");
            System.out.println("");
        }

    }

    public void start() throws Exception {
        //首先随机lectureList
        System.out.println("start to arrange !");
        long now = System.currentTimeMillis();
        Collections.sort(lectureList, Comparator.comparingInt(Lecture::getTotalCount));
        Collections.reverse(lectureList);

        for (int i = 0; i < lectureList.size(); i++) {
            Lecture lecture = lectureList.get(i);
            boolean res = findRoomForLecture(lecture);
            if (!res) {
                //说明找不到解决方案了
                System.out.println("找不到解决方案了，我退下了！");
                return;
            }
        }
        System.out.println("找到了解决方案！ cost: " + (System.currentTimeMillis() - now) + "ms");
        printAnswer();
    }

    private boolean findRoomForLecture(Lecture lecture) {
        int val = lecture.getTimeValue();
        for (int col = 0; col < roomList.size(); col++) {
            if (roomList.get(col).getTotalCount() < lecture.getTotalCount()) {
                continue;
            }
            for (int i = 0; i < 5; i++) {
                for (int row = 0; row < periodList.size(); row++) {
                    if (timeTable[i][row][col] == 0 && !isCollide(lecture, i, row)) {
                        //说明没有被访问过
                        Period startPeriod = periodList.get(row);
                        int sum = 0, end = row;
                        for (int pos = row; pos < periodList.size(); pos++) {
                            //不允许跨时间
                            if (sum < val && timeTable[i][pos][col] == 0 && periodList.get(pos).getFlag() == startPeriod.getFlag()) {
                                sum += periodList.get(pos).getVal();
                                end = pos;
                            } else {
                                break;
                            }
                        }
                        if (sum == val) {
                            List<Integer> res = new LinkedList<>();
                            for (int pos = row; pos <= end; pos++) {
                                timeTable[i][pos][col] = 1;
                                timeTableValue[i][pos][col] = lecture.getId();
                                res.add(pos);
                            }
                            putCollide(lecture, i, res);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean isCollide(Lecture lecture, int i, int row) {
        long teacherId = lecture.getTeacher().getId();
        Set<Long> classIdSet = lecture.getGroupList().stream().map(o -> o.getClassId()).collect(Collectors.toSet());

        Set<Long> flagClassIdSet = classMap.getOrDefault(i, new HashMap<>()).getOrDefault(row, new HashSet<>());
        Set<Long> flagTeacherIdSet = teacherMap.getOrDefault(i, new HashMap<>()).getOrDefault(row, new HashSet<>());
        for (Long id : classIdSet) {
            if (flagClassIdSet.contains(id)) {
                return true;
            }
        }
        if (flagTeacherIdSet.contains(teacherId)) {
            return true;
        }
        return false;
    }

    private void putCollide(Lecture lecture, int i, List<Integer> rowList) {
        long teacherId = lecture.getTeacher().getId();
        Set<Long> classIdSet = lecture.getGroupList().stream().map(o -> o.getClassId()).collect(Collectors.toSet());
        for (Integer row : rowList) {
            Set<Long> flagClassIdSet = classMap.getOrDefault(i, new HashMap<>()).getOrDefault(row, new HashSet<>());
            Set<Long> flagTeacherIdSet = teacherMap.getOrDefault(i, new HashMap<>()).getOrDefault(row, new HashSet<>());
            flagClassIdSet.addAll(classIdSet);
            flagTeacherIdSet.add(teacherId);
        }
    }


    public static void main(String[] args) throws Exception {
//        new Test().start();

        ThreadLocal<SimpleDateFormat> simpleDateFormatThreadLocal = ThreadLocal.withInitial(
                () -> new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
        );

        for (int i = 0; i < 2; i++) {
            final int pos = i;
            new Thread(
                    () -> {
                        if (pos == 0) {
                            simpleDateFormatThreadLocal.set(new SimpleDateFormat("yyyyMMdd HH:mm:ss"));
                        }
                        SimpleDateFormat sdf = simpleDateFormatThreadLocal.get();
                        String result = sdf.format(new Date());
                        System.out.println(Thread.currentThread().getName() + ": " + result);

                    }
            ).start();
        }
    }

}
