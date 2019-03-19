<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Details</title>
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
	margin-left:300px;
	margin-top:-100px;
			
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
		   	Welcome,${thought.adminName}
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
<table>
<tr>
<th></th><th>Product List</th><th>VendorId</th><th>Product Category</th><th>Brand</th><th>Quantity</th>
</tr>
<c:forEach items="${productList}" var="product">
 <c:url var = "removeLink" value="removeitem.htm">
  <c:param name="vendorProduct" value="${}"></c:param>
  </c:url>
   <c:url var = "viewLink" value="addtolist.htm">
  <c:param name="" value="${}">
</c:param> 
  </c:url>
<tr>
<td>
<form method="get" action="${vendorProduct}">
<input type="radio" name="add"></input>
</form>
<td><c:out value="${product.productName}"/></td>
<td><c:out value="${vendor.vendorId}"/></td>
<td><c:out value="${product.productCategory}"/></td>
<td><c:out value="${product.brand}"/></td>
<td>
<input type="text" name="quanrity"></input>
</td>
<td>
<form method="get" action="${removeLink}">
<input type="submit" value="remove">
</form>
</td>
</tr>
</c:forEach>
</table>
</td>

<td>
<div align="right" style="margin-left:300px; margin-top:-200px;">
<springform:form modelAttribute="product"  method="get" action="productform.htm">
<input type="submit" value="Add Product">
</div>
</springform:form>
</div>	
</td>

</tr>			
</table>
</div>
<DIV>
</body>
</html>