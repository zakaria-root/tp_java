<%@page import="javax.websocket.Session"%>
<%@page import="Entities.credentialsC"%>
<jsp:include page="Entete.jsp"></jsp:include>
<div id="content">

	<%
	if (session.getAttribute("cred") != null) {
		credentialsC cr = (credentialsC) session.getAttribute("cred");
	%>
	<h3>les informations d'utilisateur</h3>
	<ul>
		<li><%=cr.getIdcredential()%></li>
		<li><%=cr.getLogin()%></li>
		<li><%=cr.getPassword()%></li>
		<li><%=cr.getRole()%></li>
		<li><%=cr.getIdemp()%></li>
		<li><%=cr.getClass()%></li>

	</ul>
	<%
	}else{
		response.sendRedirect("login.jsp");
	}
	%>
	
</div>
<jsp:include page="Footer.jsp"></jsp:include>
