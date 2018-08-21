<%@taglib uri="http://www.springframework.org/tags/form" prefix = "form"%>
<html>
   <head>
      <title>Spring MVC Form Handling</title>
   </head>
   
   <body>
      <h2>Student Information</h2>
      <form:form  action="submit" method = "post" modelAttribute="addEmployee">
         <table>
            <tr>
            <td>Employee Name</td>
            <td><input type="text" name="name" required="required" placeholder="Name"></td>
            </tr>
            <tr>
            <td>Employee Salary</td>
            <td> <input type="number" name="salary" required="required"  placeholder="salary"></td>
            </tr>
            <a>Enter Employee address details</a>
            <tr>
            <td>Door number</td>
            <td><input type="number" name="doorNumber" placeholder="dNum" required="required"> </td>
            </tr>
            <tr>
            <td>Street</td>
            <td> <input type="text" name="street" placeholder="street" required="required"> </td>
            </tr>
           </table>
           <button type="submit">Add </button>
      </form:form>
   </body>
</html>