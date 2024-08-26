<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%

String name = "john doe";

out.println("Welcome " + name); 
out.println(returnI()); 


%>

<%!

static int i = 0;

static int returnI(){
	return i;
}

%>
</body>
</html>