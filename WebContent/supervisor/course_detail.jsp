<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div id="content">
	<h2>
		<fmt:message key="msg.courseDetail" />
	</h2>
	<div id="externalUser">
		<h3>
			<fmt:message key="msg.traineeExternalCourse" />
		</h3>
		<s:form action="addTraineeToCourse" method="POST">
			<div id="listCheckboxs">
				<s:checkboxlist list="usersExternalCourse" name="choseUsers"
					listKey="id" listValue="username" />
			</div>
			<s:hidden value="%{course.id}"></s:hidden>
			<div id="btnSubmit">
				<s:submit type="button">
					<s:param name="value">
						<fmt:message key="msg.submit" />
					</s:param>
				</s:submit>
			</div>
		</s:form>
	</div>
	<h2>
		<s:property value="%{course.name}" />
	</h2>
	<div id="subject">
		<s:iterator value="%{subjects}" var="subject">
			<s:property value="#subject.name" />
			<br />
		</s:iterator>
	</div>
	<div id="supervisor">
		<h3>
			<fmt:message key="msg.supervisorsInCourse" />
		</h3>
		<s:iterator value="%{supervisorList}" var="supervisor">
			<s:property value="#supervisor.username" />
		</s:iterator>
	</div>
	<div id="trainee">
		<h3>
			<fmt:message key="msg.traineesInCourse" />
		</h3>
		<s:iterator value="%{userList}" var="trainee">
			<s:property value="#trainee.username" />
		</s:iterator>
	</div>
	<div id="instruction">
		<h3>
			<fmt:message key="msg.instruction" />
		</h3>
		<s:property value="%{course.instruction}" />
	</div>

</div>