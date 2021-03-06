package t2008m.employee_client.entity;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {
    private Integer id;
    private String name;
    private BigDecimal salary;

    public Employee(String name, BigDecimal price) {
        this.name = name;
        this.salary = salary;
    }
}
