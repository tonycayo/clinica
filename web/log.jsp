<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            out.println("getRemoteAddr(): "+request.getRemoteAddr());
            out.println("getRemoteHost(): "+request.getRemoteHost());
        %>
        You may not get the real client IP if a the client is behind a proxy, you will get the IP of the proxy and not the client. However, the proxy may include the requesting client IP in a special HTTP header.

        <%
            out.println("getHeader(\"x-forwarded-for\"): "+request.getHeader("x-forwarded-for"));
        %>
    </body>
</html>
