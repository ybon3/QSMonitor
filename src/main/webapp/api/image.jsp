<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Image Echo</title>
</head>
<body>
<h1>影像完成</h1>
<h3>Patient(00101000)</h3>
<%=request.getParameter("00101000")%>
<h3>Accession(00080050)</h3>
<%=request.getParameter("00080050")%>
</body>
</html>