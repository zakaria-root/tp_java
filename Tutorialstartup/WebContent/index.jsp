<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="dao.CredentialsDAO"%>
<%@page import="javax.websocket.Session"%>
<%@page import="Entities.credentialsC"%>
<jsp:include page="Entete.jsp"></jsp:include>

<div id="content">
	
	<%
	if(request.getParameter("op") != null){
		if(request.getParameter("op").equals("delete")){
			int id =Integer.parseInt(request.getParameter("id"));
			CredentialsDAO.deleteCrdentials(id);
		}
	}
%>

	<%
	if (session.getAttribute("cred") != null) {
		credentialsC cr = (credentialsC) session.getAttribute("cred");
		List<credentialsC> ares = new ArrayList<credentialsC>();
		ares = CredentialsDAO.allCrdentials();
	%>
	<h3>bonjoure mr <%= cr.getLogin()%></h3>

	<h3>les informations d'utilisateur</h3>
	
	<table >
  <thead>
    <tr>
      <th >#</th>
      <th >login</th>
      <th >password</th>
      <th >role</th>
      <th >idem</th>
      <th >class</th>
      <th >action</th>
    </tr>
  </thead>
  <tbody>
	<%
	for (credentialsC cre : ares) {
		%>
    <tr>
      <th ><%=cre.getIdcredential()%></th>
      <td><%=cre.getLogin()%></td>
      <td><%=cre.getPassword()%></td>
      <td><%=cre.getRole()%></td>
      <td><%=cre.getIdemp()%></td>
      <td><%=cre.getClass()%></td>
      <td><a href="?op=delete&id=<%=cre.getIdcredential() %>">suppimer</a></td>
      
    </tr>
	<%
	}
	%>
  </tbody>
</table>
	<%
	} /* else {
	response.sendRedirect("login.jsp");
	} */
	%>




</div>
<jsp:include page="Footer.jsp"></jsp:include>
