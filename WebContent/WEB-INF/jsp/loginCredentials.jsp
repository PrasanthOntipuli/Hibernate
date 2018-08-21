<%@taglib uri="http://www.springframework.org/tags/form" prefix = "form"%>
<html>
   <head>
      <title>Spring MVC Form Handling</title>
   </head>
   
   <body>
      <h2>Student Information</h2>
      <form:form  action="Json" method = "post" modelAttribute="addEmployee">
         <table>
            <tr>
            <td>Password</td>
            <td><input type="password" id="Password1" name="Password1" required="required" placeholder="Password"></td>
            </tr>
            <tr>
            <td>ReEnter Password</td>
            <td> <input type="password" name="Password2" required="required"  placeholder="Reenter Password"></td>
            </tr>
           <button type="submit">Add </button>
      </form:form>
   </body>
</html>