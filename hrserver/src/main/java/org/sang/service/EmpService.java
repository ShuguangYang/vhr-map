package org.sang.service;

import org.sang.bean.Employee;
import org.sang.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by sang on 2018/1/12.
 */
@Service
@Transactional
public class EmpService {
    @Autowired
    EmpMapper empMapper;
//    SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
//    SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
//    SimpleDateFormat birthdayFormat = new SimpleDateFormat("yyyy-MM-dd");
//    DecimalFormat decimalFormat = new DecimalFormat("##.00");
    public int addEmp(Employee employee) {
        return empMapper.addEmp(employee);
    }

    public List<Employee> getEmployeeByPage(Integer page, Integer size, String keywords, String keywords_range, String keywords_products,
                                            Double propertyValueMin, Double propertyValueMax, Double registerCapitalMin, Double registerCapitalMax) {
        System.err.println("enter EmpService: getEmployeeByPage");

        int start = (page - 1) * size;
        return empMapper.getEmployeeByPage(start, size, keywords, keywords_range, keywords_products, propertyValueMin, propertyValueMax,
                registerCapitalMin, registerCapitalMax);
    }

    public Long getCountByKeywords(String keywords, String keywords_range, String keywords_products,
                                   Double propertyValueMin, Double propertyValueMax, Double registerCapitalMin, Double registerCapitalMax) {
        return empMapper.getCountByKeywords(keywords,  keywords_range, keywords_products, propertyValueMin, propertyValueMax, registerCapitalMin, registerCapitalMax);
    }

    public int updateEmp(Employee employee) {
        System.err.println("进入update");
        int r =empMapper.updateEmp(employee);
        System.err.println(r);
        return r;
    }

    public boolean deleteEmpById(String ids) {
        String[] split = ids.split(",");
        return empMapper.deleteEmpById(split) == split.length;
    }

    public List<Employee> getAllEmployees() {
        return empMapper.getEmployeeByPage(null, null, "","","",
                null, null, null, null);
    }

    public int addEmps(List<Employee> emps) {
        return empMapper.addEmps(emps);
    }

//    public List<Employee> getEmployeeByPageShort(Integer page, Integer size) {
//        int start = (page - 1) * size;
//        return empMapper.getEmployeeByPageShort(start,size);
//    }
}
