import entity.Teacher;
import util.DateTimeUtil;
import util.TeacherComparator;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private final static String FILE_URL = "AptechFPT.txt";

    public static void main(String[] args) throws FileNotFoundException {
        Map<String, Teacher> teacherMap = new HashMap<>();
        String regex = "(^GV.+)\\|(.+)\\|(.+)\\|(.+)";
        Pattern pattern = Pattern.compile(regex);
        File file = new File(FILE_URL);
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()){
                Teacher teacher = new Teacher();
                teacher.setId(matcher.group(1).trim());
                teacher.setName(matcher.group(2).trim());
                teacher.setDate(DateTimeUtil.parseDateFromString(matcher.group(3).trim()));
                teacher.setAmount(Integer.parseInt(matcher.group(4).trim()));
                if (teacherMap.containsKey(teacher.getId())){
                    Teacher teacherUnique = teacherMap.get(teacher.getId());
                    teacherUnique.setAmount(teacherUnique.getAmount() + teacher.getAmount());
                }else {
                    teacherMap.put(teacher.getId(), teacher);
                }
            }
        }
        Main.printSortedTeacher(teacherMap);
    }

    private static void printSortedTeacher(Map map) {
        ArrayList<Teacher> teacherArrayList = new ArrayList<Teacher>(map.values());
        Collections.sort(teacherArrayList, new TeacherComparator());
        for (int i = 0; i < 3; i++) {
            System.out.println(teacherArrayList.get(i).toString());
        }
    }
}
