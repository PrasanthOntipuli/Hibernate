
  function validation() 
     {
	// body...
	var name = document.getElementById("nameID").value;
    var salary = document.getElementById("Salary").value;
	
      
	       alert("am in dude")
	        if(name=="")
	        {
	        	alert("name cant be null")
                document.getElementById('errName').innerHTML="~Please enter a username~";
                document.getElementById("errName").style.color="Red";
	        } 		

			if(salary<10000 && salary>340000)
			{
				alert("Enter a valid salary")
			}	
			

		}
	