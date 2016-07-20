<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<h3>
	<fmt:message key="msg.courseAdding" />
</h3>
<div>
	<div>
		<s:form action="addAndSaveCourseAction" method="POST">
			<s:textfield name="course.name">
				<s:param name="label">
					<fmt:message key="msg.courseName" />
				</s:param>
			</s:textfield>
			<s:textarea name="course.instruction">
				<s:param name="label">
					<fmt:message key="msg.instruction" />
				</s:param>
			</s:textarea>
			<s:textarea name="course.status">
				<s:param name="label">
					<fmt:message key="msg.status" />
				</s:param>
			</s:textarea>
			<s:textfield name="course.startDate">
				<s:param name="label">
					<fmt:message key="msg.startDate" />
				</s:param>
			</s:textfield>
			<s:textfield name="course.endDate">
				<s:param name="label">
					<fmt:message key="msg.endDate" />
				</s:param>
			</s:textfield>
			<s:submit type="button">
				<s:param name="value">
					<fmt:message key="msg.submit" />
				</s:param>
			</s:submit>
		</s:form>
	</div>
</div>
