<%@page import="java.util.List"%>
<%@page import="domain.model.Author"%>
<%@page import="domain.model.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<%
    Author author = (Author) session.getAttribute("author") ;
    List<Book> bookList = (List<Book>) session.getAttribute("books");
%>
<h2><%=author.getName()%> <%=author.getSurname()%></h2>

<ol>s
    <%for(Book book: bookList){ %>
    <li><%=book.getTitle() %> <%=book.getAmount()%></li>
    <%}%>
</ol>
<a href="finalize">Save</a>
</body>
</html>