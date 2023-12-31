package com.merari.springbootdemo.request;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class DepartmentRequest {
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;
}
