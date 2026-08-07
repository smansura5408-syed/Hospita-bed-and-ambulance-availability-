<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Search Hospital - MediBoard</title>

<link rel="stylesheet" href="css/style.css">


<style>

body{
    margin:0;
    font-family:Arial;
    background:#f4f7fb;
}


.topbar{

    background:#0b6efd;
    color:white;
    padding:15px 30px;
    display:flex;
    justify-content:space-between;

}


.topbar a{

    color:white;
    text-decoration:none;
    cursor:pointer;

}



.container{

    width:900px;
    margin:40px auto;

}



.card{

    background:white;
    padding:25px;
    border-radius:10px;
    box-shadow:0 2px 10px #ccc;
    margin-bottom:20px;

}



input{

    width:70%;
    padding:12px;
    border:1px solid #ccc;
    border-radius:5px;

}



button{

    padding:12px 20px;
    background:#0b6efd;
    color:white;
    border:none;
    border-radius:5px;
    cursor:pointer;
    margin-top:10px;

}


button:hover{

    background:#084fc7;

}



.hospital{

    background:#eaf3ff;
    padding:20px;
    border-radius:10px;
    margin-top:15px;

}


h2{

    color:#0b6efd;

}


.ambulance-btn{

    background:#198754;

}


.ambulance-btn:hover{

    background:#146c43;

}


</style>


</head>


<body>



<div class="topbar">


<h3>
🏥 MediBoard
</h3>


<a onclick="logout()">
Logout
</a>


</div>





<div class="container">


<div class="card">


<h2>
Search Hospital
</h2>


<input
id="location"
placeholder="Enter location">


<button onclick="searchHospital()">
Search
</button>



</div>




<div id="result"></div>



</div>






<script src="js/api.js"></script>


<script>


let user =
JSON.parse(localStorage.getItem("publicUser"));



if(!user){

    window.location.href="public-login.html";

}






async function searchHospital(){


let location =
document.getElementById("location").value;



if(location===""){

    alert("Enter city name");

    return;

}



try{


let hospitals =
await apiRequest(
"/hospitals/search?location=" + encodeURIComponent(location)
);



let output="";



if(hospitals.length===0){

    output="<div class='card'>No hospitals found</div>";

}

else{


hospitals.forEach(h=>{


output += `

<div class="hospital">


<h2>
${h.name}
</h2>




<p>
📍 Location : ${h.location}
</p>



<hr>



<p>
🛏 Available Beds :
<b>${h.availableBeds}</b> / ${h.totalBeds}
</p>



<p>
🚑 Available Ambulances :
<b>${h.availableAmbulances}</b> / ${h.totalAmbulances}
</p>




<button 
class="ambulance-btn"
onclick="requestAmbulance(${h.id})">

🚑 Request Ambulance

</button>



</div>


`;

});


}



document.getElementById("result").innerHTML=output;



}

catch(error){

alert(error.message);

}



}







function requestAmbulance(hospitalId){


localStorage.setItem(
"selectedHospitalId",
hospitalId
);



window.location.href="ambulance-request.html";

}







function logout(){


localStorage.removeItem("publicUser");


window.location.href="index.html";


}



</script>


</body>

</html>
