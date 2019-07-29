<%-- 
    Document   : adminEmployee
    Created on : Jul 28, 2019, 10:12:28 PM
    Author     : Bella
--%>

<%@page import="java.util.List"%>
<%@page import="models.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <!-- CSS Data tables -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap4.min.css">
        <!--End of CSS Data tables-->
                <!--CSS and JS Modal-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <!--End of CSS and JS Modal-->
    </head>
    <body>
        <h1>Employee</h1>
                        <!--Table-->
                        <%
        List<Employee> listEmployee = (List<Employee>) session.getAttribute("listEmployee");
        Employee employee = (Employee) session.getAttribute("employee");
        if (session.getAttribute("listEmployee") == null) {
            response.sendRedirect("EmployeeServlet");
        }
    %>
    <div align="right">
            <button type="button" class="btn btn-success btn-lg" data-toggle="modal" data-target="#modalInsert">Insert Data</button>
    </div>
            <br>
            <br>
            <div align="center" >
            <table  class="table table-striped table-bordered" style="width: 80%" id="employeeTable">
                <thead>
                    <tr>
                        <th>No</th>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Role</th>
                        <th>Phone</th>
                        <th>Email</th>
                        <th>Password</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <% if (session.getAttribute("listEmployee") != null) {
                            for (Employee emp : listEmployee) {
                    %>
                    <tr>
                        <td></td>
                        <td><%=emp.getId()%></td>
                        <td><%=emp.getName()%></td>
                        <td><%=emp.getRole()%></td>
                        <td><%=emp.getPhone()%></td>
                        <td><%=emp.getEmail()%></td>
                        <td><%=emp.getPassword()%></td>
                        <td><a class="btn btn-danger"  href="EmployeeServlet?action=delete&id=<%=emp.getId()%>">Delete</a>
                            <a class="btn btn-primary" href=# data-toggle="modal" data-target="#update<%=emp.getId()%>" >Update</a>
                        </td>
                    </tr>
                    <%}
                    }%>
                </tbody>
            </table>
            </div>
                
                
             
                

                   <!-- Modal Insert-->
            <div class="modal fade" id="modalInsert" role="dialog">
                <div class="modal-dialog modal-dialog-centered">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>
                        <div class="modal-body">
                            <form action="EmployeeServlet" method="POST">
                                <label><b>ID</b></label>
                                <input class="form-control" type="text" name="id" value="<%=(employee != null) ? employee.getId() : ""%>"/>
                                <br>
                                <label><b>Name</b></label>
                                <input class="form-control" type="text" name="name" value="<%=(employee != null) ? employee.getName(): ""%>" />
                                <br>
                                <label><b>Role</b></label>
                                <input class="form-control" type="text" name="role" value="<%=(employee != null) ? employee.getRole(): ""%>" />
                                <br>
                                <label><b>Phone</b></label>
                                <input class="form-control" type="text" name="phone" value="<%=(employee != null) ? employee.getPhone() : ""%>" />
                                <br>
                                <label><b>Email</b></label>
                                <input class="form-control" type="text" name="email" value="<%=(employee != null) ? employee.getEmail(): ""%>" />
                                <br>
                                <label><b>Password</b></label>
                                <input class="form-control" type="text" name="password" value="<%=(employee != null) ? employee.getPassword(): ""%>" />
                                <br>
                                <input  type="submit" value="Save" class="btn btn-success" id="insert">
                            </form>
                        </div>
                    </div>
                </div>
            </div>
                                
            <!--End of Modal Insert-->
                
     
                <style type="text/css">
            table {
                counter-reset: rowNumber+1;
            }

            table tr:not(:first-child) {
                counter-increment: rowNumber+1;
            }

            table tr td:first-child::before {
                content: counter(rowNumber);
                min-width: 1em;
                margin-right: 0.5em;
            }
        </style>
<script>
            $('#employeeTable').DataTable();
        </script>
        
             <!--JavaScript Bootstrap-->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

        <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap4.min.js"></script>
        <!--End of JavaScript Bootstrap-->
    </body>
</html>
