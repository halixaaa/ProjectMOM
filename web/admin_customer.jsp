<%-- 
    Document   : admin_customer
    Created on : Jul 29, 2019, 9:00:14 AM
    Author     : Bella
--%>

<%@page import="models.Customer"%>
<%@page import="java.util.List"%>
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
        
                <!--CSS and JS SweetAlert-->
        <script src="sweetalert2.min.js"></script>
        <link rel="stylesheet" href="sweetalert2.min.css">
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@8"></script>
        <script src="sweetalert2.all.min.js"></script>
        <!--End of CSS and JS SweetAlert-->
        
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    
    <style> 
    
    .sidenav {
  height: 100%;
  width: 200px;
  position: fixed;
  z-index: 1;
  top: 0;
  left: 0;
  background-color: #FBB117;
  overflow-x: hidden;
  padding-top: 20px;
}

/* Style the sidenav links and the dropdown button */
.sidenav a, .dropdown-btn {
  padding: 6px 8px 6px 16px;
  text-decoration: none;
  font-size: 20px;
  color: #111;
  display: block;
  border: none;
  background: none;
  width: 100%;
  text-align: left;
  cursor: pointer;
  outline: none;
}

/* On mouse-over */
.sidenav a:hover, .dropdown-btn:hover {
  color: #f1f1f1;
}

/* Main content */
.main {
  margin-left: 200px; /* Same as the width of the sidenav */
  /*font-size: 20px;  Increased text to enable scrolling */
  padding: 0px 10px;
}

/* Add an active class to the active dropdown button */
.active {
  background-color: green;
  color: white;
}

/* Dropdown container (hidden by default). Optional: add a lighter background color and some left padding to change the design of the dropdown content */
.dropdown-container {
  display: none;
  background-color: #262626;
  padding-left: 8px;
}

/* Optional: Style the caret down icon */
.fa-caret-down {
  float: right;
  padding-right: 8px;
}

/* Some media queries for responsiveness */
@media screen and (max-height: 450px) {
  .sidenav {padding-top: 15px;}
  .sidenav a {font-size: 18px;}
}
</style>
    <body>
               <div class="sidenav">
  <a href="admin_employee.jsp">Employee</a>
  <a href="admin_customer.jsp">Customer</a>
  <a href="admin_role.jsp">Role</a>
  <a href="admin_status.jsp">Status</a>
<!--  <button class="dropdown-btn">Dropdown 
    <i class="fa fa-caret-down"></i>
  </button>
  <div class="dropdown-container">
    <a href="#">Link 1</a>
    <a href="#">Link 2</a>
    <a href="#">Link 3</a>
  </div>
  <a href="#">Search</a>-->
</div>



<script>
/* Loop through all dropdown buttons to toggle between hiding and showing its dropdown content - This allows the user to have multiple dropdowns without any conflict */
var dropdown = document.getElementsByClassName("dropdown-btn");
var i;

for (i = 0; i < dropdown.length; i++) {
  dropdown[i].addEventListener("click", function() {
  this.classList.toggle("active");
  var dropdownContent = this.nextElementSibling;
  if (dropdownContent.style.display === "block") {
  dropdownContent.style.display = "none";
  } else {
  dropdownContent.style.display = "block";
  }
  });
}
</script>
        
        <div class="main">
            <div id="page-content-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                       <h1>Customer</h1>
                        <!--Table-->
                        <%
        List<Customer> listCustomer = (List<Customer>) session.getAttribute("listCustomer");
        Customer customer = (Customer) session.getAttribute("customer");
        if (session.getAttribute("listCustomer") == null) {
            response.sendRedirect("CustomerServlet");
        }
    %>
    <div align="right">
            <button type="button" class="btn btn-success btn-lg" data-toggle="modal" data-target="#modalInsert">Insert Data</button>
    </div>
            <br>
            <br>
            <div align="center" >
            <table  class="table table-striped table-bordered" style="width: 90%" id="customerTable">
                <thead>
                    <tr>
                        <th>No</th>
                        <th>ID</th>
                        <th>Name</th>
                        <th>PIC</th>
                        <th>Address</th>
                        <th>Phone</th>
                        <th>Email</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <% if (session.getAttribute("listCustomer") != null) {
                            for (Customer cus : listCustomer) {
                    %>
                    <tr>
                        <td></td>
                        <td><%=cus.getId()%></td>
                        <td><%=cus.getName()%></td>
                        <td><%=cus.getPic()%></td>
                        <td><%=cus.getAddress()%></td>
                        <td><%=cus.getPhone()%></td>
                        <td><%=cus.getEmail()%></td>
                        <td><a class="btn btn-danger"  href="CustomerServlet?action=delete&id=<%=cus.getId()%>">Delete</a>
                            <a class="btn btn-primary" href=# data-toggle="modal" data-target="#update<%=cus.getId()%>" >Update</a>
                        </td>
                    </tr>
                   <%}
                    }%>
                </tbody>
            </table>
            </div>
            </div>
            </div>
            </div>
            </div>
            </div>
        
                <div class="modal fade" id="modalInsert" role="dialog">
                <div class="modal-dialog modal-dialog-centered">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>
                        <div class="modal-body">
                            <form action="CustomerServlet" method="POST">
                                <label><b>ID</b></label>
                                <input class="form-control" type="text" name="id" value="<%=(customer != null) ? customer.getId() : ""%>"/>
                                <br>
                                <label><b>Name</b></label>
                                <input class="form-control" type="text" name="name" value="<%=(customer != null) ? customer.getName(): ""%>" />
                                <br>
                                <label><b>PIC</b></label>
                                <input class="form-control" type="text" name="pic" value="<%=(customer != null) ? customer.getPic(): ""%>" />
                                <br>
                                <label><b>Address</b></label>
                                <input class="form-control" type="text" name="address" value="<%=(customer != null) ? customer.getAddress() : ""%>" />
                                <br>
                                <label><b>Phone</b></label>
                                <input class="form-control" type="text" name="phone" value="<%=(customer != null) ? customer.getPhone(): ""%>" />
                                <br>
                                <label><b>Email</b></label>
                                <input class="form-control" type="text" name="email" value="<%=(customer != null) ? customer.getEmail(): ""%>" />
                                <br>
                                <input  type="submit" value="Save" class="btn btn-success" id="insert">
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            
                                
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
        $(document).ready( function () {
    $('#customerTable').DataTable();
} );
    </script>
        
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

    <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap4.min.js"></script>
    </body>
    <%
        session.removeAttribute("listCustomer");
        session.removeAttribute("customer");
    %>
</html>
