<%-- 
    Document   : meeting
    Created on : Jul 29, 2019, 10:09:04 AM
    Author     : Bella
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        
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

        
        
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.2/jquery-ui.min.js"></script>  
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
  font-size: 16px;
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
  background-color: #F8C471  ;
  color: white;
}

/* Dropdown container (hidden by default). Optional: add a lighter background color and some left padding to change the design of the dropdown content */
.dropdown-container {
  display: none;
  background-color: #F8C471;
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

    </head>
    <body>
        
        <div class="sidenav">
            <div align="center">
    <img src="https://www.metrodata.co.id/web/images/business/2014-08-20-112626.png" width="100" height="70"/>
    </div>
    <!--  <a href="admin_employee.jsp">Meeting</a>
  <a href="admin_customer.jsp">Customer</a>
  <a href="admin_role.jsp">Role</a>
  <a href="admin_status.jsp">Status</a>-->
    <br>
    
  <button class="dropdown-btn">Meeting 
    <i class="fa fa-caret-down"></i>
  </button>
  <div class="dropdown-container">
    <a href="meeting_form.jsp">Meeting Form</a>
    <a href="meeting_list.jsp">Meeting List</a>
  </div>
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
        <!-- Page Content -->
        <div class="main">

    <div id="page-content-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <br>
                       <h1>Meeting Form</h1>
                       <br>
                       <form action="MFormServlet" method="POST">
                       <label><b>ID</b></label>
                        <input class="form-control" type="text" name="id" style="width: 150px"/>
                        <br>
                        <label><b>Meeting</b></label>
                        <input class="form-control" type="text" name="name" style="width: 600px"/>
                        <br>
                        <label><b>Project</b></label>
                        <input class="form-control" type="text" name="name" style="width: 600px"/>
                        <br>
                        <label><b>Date</b></label>
                        <input class="form-control" type="date" name="name"style="width: 250px"/>
                        <br>
                        <label><b>Time</b></label>
                        <input class="form-control" type="time" name="name" style="width: 150px"/>
                        <br>
                        <label><b>Chaired By</b></label>
                        <input class="form-control" type="text" name="name" style="width: 600px"/>
                        <br>
                        <label><b>Attendees</b></label><br>
                        <div class="form-inline">
                          <select class="form-control" id="sel1" style="width: 200px">
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                          </select> &nbsp;
                        <input  type="submit" value="Add" class="btn btn-success" id="addAttend">
                        </div>
                        <br>
                        <label><b>Type</b></label><br>
                        <input type="radio" name="radioType" value="internal" onclick="toggleTextbox('Internal')"> Internal &nbsp &nbsp
                        <input type="radio" name="radioType"  value="external" onclick="toggleTextbox('External')"> External <br>
                        <br>
                        <label><b>Customer</b></label>
                        <input class="form-control" type="text" name="name" id="txtCustomer" style="width: 600px"/>
                        <br>
                        <input  type="submit" value="Save" class="btn btn-success" id="insert">
                        <br>
                        <br>
                        <br>
                       </form>
                    </div>
                </div>
            </div>
        </div>
   </div>

        
    

<script type="text/javascript">
function toggleTextbox(opt)
{
    if (opt == 'Internal')
        document.getElementById('txtCustomer').disabled = true;
    else
        document.getElementById('txtCustomer').disabled = false;
}
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
