<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="springcore" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>
#top{
	background-color:#F2F2F2;
	width:100%;
	height:70px;
	}
#logo{
 	  float:left;
          
 	  
     }
 #search{
         background-color:#F2F2F2;
	border-radius:6px;
         float:left;
 	 
         PADDING-LEFT:85PX;
	margin-top:25PX;
         
         }
 #logout{
          background-color:#F2F2F2;
          float:right;
 	  border-radius:8px;
	margin-top:25PX;
	padding-left:75px;
	margin-right:10px;
  	}
#bell{
	background-color:#F2F2F2;
          float:left;
	margin-top:25PX;
	padding-left:400px;
	}
#admin{
	background-color:#F2F2F2;
          float:right;
	margin-top:25PX;
	padding-left:85px;
	}
#blank{
	background-color:#F2F2F2;
          float:left;
	margin-top:25PX;
	padding-left:85px;
}
#side{
	background-color:#F2F2F2;
	width:250%;
	height:450px;
	margin-left:30px;
	padding-top:5px;
     }
#profile{
	background-color:#C0C0C0;
	COLOR:WHITE;	
	width:95%;
	height:45px;
	margin-left:5px;
	margin-right:7px;
	
	padding-left:5px;
	
	}
	#main{
	margin-left:400px;
	margin-top:-200px;
			
	}

</style>
</head>
<body>


<DIV>
	<div id="conatiner">
 		<div id="top">
			<div id="logo">
 		 	<img src="C:\Users\768849\Desktop\addproduct.jpg" alt="add" height="70px">
 			</div>
 			<div id="search">
 			<input type="search" name="search" placeholder="search" class="round">
 			</div>
			<div id="bell">
			<img src="C:\Users\768849\Desktop\bell.jpg" alt="bell" heigth="20px" width="20px">
			</div>
			<div id="blank">
			
			
			</div>
		
         	       <div id="logout">
 				<springform:form modelAttribute="admin" method="get" action="logout.htm">

 				<input type="submit" name="logout" value="logout" class="round">
 				</springform:form>
 			</div>
			<div id="admin">
		   	Welcome,Admin...
			</div>
		</div>
		<br>
		<br>
	<table><tr>
	<td>	
		<div id="side">
			<div id="profile" >
			<B>PROFILE</B>
		 </div>
		 </td>
		 <td>
<div id="main">

<b>PRODUCT NAME:</b><br>${productinfo.productName}<br><br>
<b>PRODUCT CATEGORY:</b><br>${productinfo.productCategory}<br><br>
<b>PRODUCT DESCRIPTION:</b><br>${productinfo.productDescription}<br><br>
<b>PRODUCT BRAND:</b><br>${productinfo.brand}<br><br>
<b>PRODUCT PRICE:</b><br>${productinfo.productPrice}<br><br>
</div>	
</td>
</tr>			
</table>
</div>
		

<DIV>
</body>
</html>