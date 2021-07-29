package util;

import entity.Teacher;

import java.util.Comparator;

public class TeacherComparator implements Comparator<Teacher> {

    @Override
    public int compare(Teacher teacher1, Teacher teacher2) {
        if (teacher1.getAmount() != teacher2.getAmount()) {
            return teacher2.getAmount() - teacher1.getAmount();
        } else {
            return teacher1.getDate().compareTo(teacher2.getDate());
        }
    }
}
