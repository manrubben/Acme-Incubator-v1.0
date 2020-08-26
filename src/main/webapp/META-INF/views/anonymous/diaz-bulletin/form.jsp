<%--
- form.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="anonymous.diazbulletin.form.label.surname" path="surname"/>
	<acme:form-textbox code="anonymous.diazbulletin.form.label.bulletin" path="bulletin"/>
	
	<acme:form-submit code="anonymous.diazbulletin.form.button.create" action="/anonymous/diaz-bulletin/create"/>
  	<acme:form-return code="anonymous.diazbulletin.form.button.return"/>
</acme:form>
