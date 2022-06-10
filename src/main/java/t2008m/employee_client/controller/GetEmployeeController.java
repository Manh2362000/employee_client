package t2008m.employee_client.controller;

import t2008m.employee_client.entity.Employee;
import t2008m.employee_client.retrofit.RetrofitGenerator;
import t2008m.employee_client.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetEmployeeController extends HttpServlet {

    private final EmployeeService employeeService;

    public GetEmployeeController() {
        employeeService = RetrofitGenerator.createService(EmployeeService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Employee>  employees = employeeService.getEmployee().execute().body();
        req.setAttribute("listEmployee", employees);
        req.getRequestDispatcher("/employee/employee-list.jsp").forward(req, resp);
    }
}
