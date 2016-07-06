<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div>
	<h2>
		<fmt:message key="msg.accessDenied" />
	</h2>
	<h2>${pageContext.request.userPrincipal.name}!!!</h2>
	<a href="login">Back</a>
</div>