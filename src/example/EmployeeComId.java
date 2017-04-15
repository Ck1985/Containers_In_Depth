package example;

import java.util.*;
import net.mindview.util.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */

public class EmployeeComId implements Comparator<Employee> {
    public int compare(Employee emp1, Employee emp2) {
        return (emp1.getId() - emp2.getId() > 0) ? -1 : (emp1.getId() - emp2.getId() == 0 ? 0 : 11);
    }
}
