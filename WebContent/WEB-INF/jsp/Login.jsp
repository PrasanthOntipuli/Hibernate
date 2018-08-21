<%@taglib uri="http://www.springframework.org/tags/form" prefix = "form"%>
<html>
   <head>
      <title>Login Page</title>
   </head>
   
   <body>
      <h2>Login Info</h2>
      <form:form  action="demo" method = "post">
         <table>
            <tr>
            <td>Employee Id</td>
            <td><input type="number" name="employeeId" required="required" placeholder="enter ID"></td>
            </tr>
            <tr>
            <td>Password</td>
            <td> <input type="password" name="password" required="required"  placeholder="password"></td>
            </tr>
            <tr>
            <td>Type</td>
            <td><select>
 				 <option value="User">User</option>
  				 <option value="Admin">admin</option>
  			</td>
            </tr>
   
           </table>
           <button type="submit">Submit </button>
      </form:form>
   </body>
</html>