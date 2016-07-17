<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div>
	<div id="menu">
		<s:a action="addCourse">
			<fmt:message key="msg.addCourse" />
		</s:a>
		<s:a action="deleteCourse?courseId=5">
			<fmt:message key="msg.deleteCourse" />
		</s:a>
		<a href="showCourseDetail?courseId=1"><fmt:message
				key="msg.courseDetail" /> </a>
		<s:a href="showSubjectDetail?courseId=1&subjectId=1">
			<fmt:message key="msg.subjecPage" />
		</s:a>
	</div>
	<div id="listCourses"></div>
	<div id="listSubjects"></div>
</div>