
   function test123()
   {
	   var id = document.getElementById("employeeID").value;
	   data=id 
          //encodeURIComponent(employeeID);
	   alert(" ▬▬▬▬▬▬▬▬▬ஜ۩۞۩ஜ▬▬▬▬▬▬▬▬\n\n                               "+data );
	   $.ajax({
		   type: 'POST',
		   url: "restcnt/getEmployeeById",
		   data: data,
		   dataType: "json",
		   contentType: "application/json",
		   success: function( resp ) {
		       
		     // alert("success"+JSON.stringify(resp));
		      // setting the table row id as table id and getying that row by id and deleteing the row
		      // 
		      var etable=document.getElementById("empTable")
		      var row = etable.insertRow(-1)
		      
		      row.contentEditable = false
		     
		      row.id= resp.employeeId
		      var cell1 = row.insertCell(0)
		      var cell2 = row.insertCell(1)
		      var cell3 = row.insertCell(2)
		      var cell4 = row.insertCell(3)
		      var cell5 = row.insertCell(4)
		      var cell6 = row.insertCell(5)
		      var cell7 = row.insertCell(6)
		      //var cell8 = row.insertCell(7)
		      
		      var id=resp.employeeId;
		      //alert(id);
 		      cell1.innerHTML = resp.employeeId
		      cell2.innerHTML = resp.name
		      cell3.innerHTML = resp.salary	
		      cell4.innerHTML = resp.address.id
		      cell5.innerHTML = resp.address.doorNumber
		      cell6.innerHTML = resp.address.street
		     // alert(this+"This is row id");
		      cell7.innerHTML = "<button onclick='deleteFunction("+id+")' style='display:block'>Delete</button>";
		      //cell8.innerHTML = "<button onclick=  'editFunction("+id+")' style='display:block'>Edit  </button>"; 
		     
		      row.ondblclick = function() {editFunction(id)};
		      row.ondrag = function(event)  {deleteFunction(id)};
		      
		    },
		   error: function(e) {
		    document.getElementById("error").innerHTML = "Data Dosent Exists"; 
		    document.getElementById("error").style.color="Red";
		    setTimeout(refreash,5000)	
		     function refreash()
			     {
				 document.getElementById('error').innerHTML="";
                
			     }
		     
		   },
		 
		 });
	   
   }
   
   
    function myFunction()
    {
    	alert("Reached this dbClick function");
    }
   function editFunction(id)
   {
	   alert("Reached function"+id);
	   
	   var row = document.getElementById(id);
	   
	   if(row.contentEditable=="false")
		   {
		   // alert("reached To convertable to false from : "+row.contentEditable)
		   // row.cells[7].style.display=blur();
		    //alert(row.cells[2].innerHTML+"  trying  to chainge Style  :"+row.cells[8].style.display)
		    row.contentEditable=true;
		    var cell7 = row.insertCell(6)
			   //row.cells[8].style.display="block";
			   cell7.innerHTML = "<button onclick='updateFunction("+id+")' style='display:block'> Save </button>";
		    row.deleteCell(7);
		   }
	   
	   
	   else
		   {
		   //alert("reached to convertable to true from :"+row.contentEditable)
		   row.contentEditable=false;
		   row.deleteCell(6);
	       var cell7 = row.insertCell(6)
		   //row.cells[8].style.display="block";
		   cell7.innerHTML = "<button onclick='deleteFunction("+id+")' style='display:block'>Delete</button>";
		   }
      
   }
   
   function deleteFunction(id) {
	$.ajax({
	    url: "restcnt/deleteEmployeeById/"+id,
	    type: 'DELETE',
	    success: function(result) 
	      {
	       
	       alert(result);  
	       var row = document.getElementById(id);
	        row.parentNode.removeChild(row);
	    },
	error: function(e) {
	     alert(url+"    error"+JSON.stringify(e));
	   },
	});
}
   
   
   //update Function
   function  updateFunction(id) {
	   alert("Reached  :"+id)
	   var row = document.getElementById(id);
	   
	   var id=row.cells[0].innerHTML;
	   var name=row.cells[1].innerHTML;
	   var salary=row.cells[2].innerHTML;
	   var addID=row.cells[3].innerHTML;
	   var drNum=row.cells[4].innerHTML;
	   var street=row.cells[5].innerHTML;
	   id = id.replace(" ","");
	   id = id.replace("<br>","");
	   addID=addID.replace(" ","");
	   addID=addID.replace("<br>","");
	   drNum=drNum.replace(" ","");
	   drNum=drNum.replace("<br>","");
       name = name.replace("<br>","");
       salary=salary.replace(" ","");
       salary=salary.replace("<br>","");
       street=street.replace("<br>","");
	   //alert(id+"ID   :"+name+"Name  "+salary+" Salary  "+addID+"Address ID   "+drNum+" DrNum  "+street +"Street  ");
       data ={"employeeId":id,"name":name,"salary":salary,"address":{"id":addID,"doorNumber":drNum,"street":street}}
	  // alert("json Object View :"+data)
	   
	     row.contentEditable=false;
       row.deleteCell(6);
       var cell7 = row.insertCell(6)
	   //row.cells[8].style.display="block";
	   cell7.innerHTML ="<button onclick='deleteFunction("+id+")' style='display:block'>Delete</button>";
	   $.ajax({
		   type: 'POST',
		   url: "restcnt/updateEmployee",
		   data: JSON.stringify(data),
		   dataType: "json",
		   contentType: "application/json",
		   success: function( resp ) 
		   {
			  // alert("reached"+resp)
		   },
		   error: function(e) {
			   //alert(url+"    error"+JSON.stringify(e));
			     
			   },
	      
		   });
}