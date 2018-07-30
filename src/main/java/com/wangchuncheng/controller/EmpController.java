package com.wangchuncheng.controller;

import com.wangchuncheng.beans.Department;
import com.wangchuncheng.beans.Employee;
import com.wangchuncheng.beans.Location;
import com.wangchuncheng.beans.ResponseData;
import com.wangchuncheng.dao.DepartmentDao;
import com.wangchuncheng.dao.EmployeeDao;
import com.wangchuncheng.dao.LocationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Wangchuncheng on 2018/7/30 11:04
 */
@RestController
public class EmpController {
    @Autowired
    private LocationDao locationDao;
    @Autowired
    private DepartmentDao departmentDao;
    @Autowired
    private EmployeeDao employeeDao;

    @PostMapping("/queryAll")
    public ResponseData queryAll(String type) {
        ResponseData data = new ResponseData();
        data.setStatus(ResponseData.STATUS_SUCCESS);
        try {
            if ("location".equals(type)) {
                data.setData(locationDao.getAll());
            } else if ("department".equals(type)) {
                data.setData(departmentDao.getAll());
            } else if ("employee".equals(type)) {
                data.setData(employeeDao.getAll());
            }else {
                data.setStatus(ResponseData.STATUS_ERROR);
                data.setMessage("未知查询类型！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            data.setStatus(ResponseData.STATUS_ERROR);
            data.setMessage(e.getMessage());
        }
        return data;
    }
    @PostMapping("/queryOne")
    public ResponseData queryOne(String type,Integer id) {
        ResponseData data = new ResponseData();
        data.setStatus(ResponseData.STATUS_SUCCESS);
        try {
            if ("location".equals(type)) {
                data.setData(locationDao.getOne(id));
            } else if ("department".equals(type)) {
                data.setData(departmentDao.getOne(id));
            } else if ("employee".equals(type)) {
                data.setData(employeeDao.getOne(id));
            }else {
                data.setStatus(ResponseData.STATUS_ERROR);
                data.setMessage("未知查询类型！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            data.setStatus(ResponseData.STATUS_ERROR);
            data.setMessage(e.getMessage());
        }
        return data;
    }

    @PostMapping("/queryForEmployees")
    public ResponseData queryForEmployees(Employee entity) {
        ResponseData data = new ResponseData();

        data.setStatus(ResponseData.STATUS_SUCCESS);
        try {
            data.setData(employeeDao.getList(entity));
        } catch (Exception e) {
            data.setStatus(ResponseData.STATUS_ERROR);
            data.setMessage(e.getMessage());
            e.printStackTrace();
        }
        return data;
    }

    @PostMapping("/queryForLocations")
    public ResponseData queryForLocations(Location entity) {
        ResponseData data = new ResponseData();
        data.setStatus(ResponseData.STATUS_SUCCESS);
        try {
            data.setData(locationDao.getList(entity));
        } catch (Exception e) {
            data.setStatus(ResponseData.STATUS_ERROR);
            data.setMessage(e.getMessage());
            e.printStackTrace();
        }
        return data;
    }

    @PostMapping("/queryForDepartments")
    public ResponseData queryForDepartments(Department entity) {
        ResponseData data = new ResponseData();
        data.setStatus(ResponseData.STATUS_SUCCESS);
        try {
            data.setData(departmentDao.getList(entity));
        } catch (Exception e) {
            data.setStatus(ResponseData.STATUS_ERROR);
            data.setMessage(e.getMessage());
            e.printStackTrace();
        }
        return data;
    }
}
