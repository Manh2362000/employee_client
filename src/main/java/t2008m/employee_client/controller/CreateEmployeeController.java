package t2008m.employee_client.controller;

import t2008m.employee_client.entity.Employee;
import t2008m.employee_client.retrofit.RetrofitGenerator;
import t2008m.employee_client.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

public class CreateEmployeeController extends HttpServlet {
    private static Employee obj;

    private final EmployeeService employeeService;

    public CreateEmployeeController() {
        employeeService = RetrofitGenerator.createService(EmployeeService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        obj = new Employee("Employee new", new BigDecimal(10));
        req.setAttribute("employee", obj);
        req.getRequestDispatcher("/employee/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        obj.setName(req.getParameter("name"));
        obj.setSalary(new BigDecimal (req.getParameter("price")));
        employeeService.save(obj).execute();
        resp.sendRedirect("/employee");
    }
}
