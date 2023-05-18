package com.dailycodebuffer.departmentservice.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@ToString
public class Department {

    public Department(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    private Long id;
    private String name;
    private List<Employee> employees = new ArrayList<Employee>();
}
