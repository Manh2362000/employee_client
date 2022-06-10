package t2008m.employee_client.service;

import retrofit2.Call;
import retrofit2.http.*;
import sun.plugin.util.PluginSysUtil;
import t2008m.employee_client.entity.Employee;

import java.util.List;

public interface EmployeeService {

    @GET("api/v1/employees")
    public Call<List<Employee>> getEmployee();

    @GET("api/v1/employees/{id}")
    public Call<Employee> getEmployeeDetails(@Path("id") Integer id);

    @POST("api/v1/employees")
    public Call<Employee> save(@Body Employee employee);

    @PUT("api/v1/employees/{id}")
    public Call<Employee> update(@Path("id") Integer id, @Body Employee product);
}
