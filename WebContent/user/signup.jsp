<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<s:form action="signUp" method="post" enctype="multipart/form-data">
	<s:textfield name="user.email">
		<s:param name="label">
			<fmt:message key="msg.email" />
		</s:param>
	</s:textfield>
	<s:textfield name="user.username">
		<s:param name="label">
			<fmt:message key="msg.username" />
		</s:param>
	</s:textfield>
	<s:password name="user.password">
		<s:param name="label">
			<fmt:message key="msg.password" />
		</s:param>
	</s:password>
	<s:password name="passwordConfirm">
		<s:param name="label">
			<fmt:message key="msg.confirmpassword" />
		</s:param>
	</s:password>
	<s:submit>
		<s:param name="value">
			<fmt:message key="msg.signup" />
		</s:param>
	</s:submit>
</s:form>

<s:hidden name="accessToken" />
<a
	href="https://www.facebook.com/dialog/oauth?client_id=112266659207634&
			redirect_uri=&scope=email">
	<fb:login-button autologoutlink="true" onlogin="getAccessToken();">
		Signup with facebook
	</fb:login-button>
</a>
<div id="status"></div>
