<%--
  Created by IntelliJ IDEA.
  User: Wangchuncheng
  Date: 2018/7/30
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工管理</title>
    <script src="static/js/jquery-3.3.1.min.js"></script>
    <script src="static/js/jquery.blockUI.js"></script>
    <script>
        $(function () {
            //使用blockUI
            $(document).ajaxStart(function () {
                $.blockUI({
                    message: $('#loading'),
                    css: {
                        top: ($(window).height - 400) / 2 + 'px',
                        width: '400px',
                        border: 'none',
                        // backgroundColor:'#fff'
                    },
                    overlayCss: {backgroundColor: '#fff'}
                })
            }).ajaxStop($.unblockUI);

            var queryForDepartments = '/queryForDepartments';
            var queryForEmployees = '/queryForEmployees';

            var allLocations;
            var availableDeparts;
            var availableEmps;
            $.post('/queryAll', {'type': 'location'}, function (response, status) {
                allLocations = response.data;
                for (var i = 0; i < allLocations.length; i++) {
                    $('#city').append("<option value='" + allLocations[i].id + "'>" + allLocations[i].city + "</option>")
                }
            });
            //城市选择事件
            $("#city").change(function () {
                $('#department option:not(:first)').remove();//清除原来的值
                $('#employee option:not(:first)').remove();//清除原来的值
                var thisId = $(this).val();
                if (thisId != '') {
                    var args = {
                        'loc_id': thisId
                    };
                    $.post(queryForDepartments, args, function (response) {
                        availableDeparts = response.data;
                        if (availableDeparts.length == 0) {
                            alert("当前城市没有部门！");
                        } else {
                            updateOptions($('#department'), availableDeparts);
                        }
                    });
                }
            });
            //部门选择事件
            $("#department").change(function () {
                $('#employee option:not(:first)').remove();//清除原来的值
                var thisId = $(this).val();
                if (thisId != '') {
                    var args = {
                        'depart_id': thisId
                    };
                    $.post(queryForEmployees, args, function (response) {
                        availableEmps = response.data;
                        if (availableEmps.length == 0) {
                            alert("当前部门没有员工！");
                        } else updateOptions($('#employee'), availableEmps);
                    });
                }
            });
            //员工选择事件
            $('#employee').change(function () {
                var thisId = $(this).val();
                $.post('/queryOne', {'type': 'employee', 'id': thisId}, function (response) {
                    var data = response.data;
                    $('#empId').empty().append(data.id);
                    $('#empName').empty().append(data.name);
                    $('#empEmail').empty().append(data.email);
                    $('#empSalary').empty().append(data.salary);
                    $('#empDetails').attr('style', '');
                });
            });
        });

        function updateOptions(targetElement, data) {
            for (var i = 0; i < data.length; i++) {
                targetElement.append("<option value='" + data[i].id + "'>" + data[i].name + "</option>");
            }
        }
    </script>
</head>
<body>
<center>
    <img id="loading" src="static/img/loading.gif" alt="" style="display: none">
    <br><br>
    City:
    <select id="city">
        <option value="">请选择...</option>
    </select>
    &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
    Department:
    <select id="department">
        <option value="">请选择...</option>
    </select>
    &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
    Employee:
    <select id="employee">
        <option value="">请选择...</option>
    </select>
    &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
    <br><br>
    <table id="empDetails" border="1" cellspacing="0" cellpadding="5" style="display:none">
        <tr id="tableHead">
            <th>Id</th>
            <th>Name</th>
            <th>Email</th>
            <th>Salary</th>
        </tr>
        <tr id="empContent">
            <td id="empId"></td>
            <td id="empName"></td>
            <td id="empEmail"></td>
            <td id="empSalary"></td>
        </tr>
    </table>
</center>
</body>
</html>
