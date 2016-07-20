<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div>
	<div id="menu">
		<s:a action="addCourse"><fmt:message key="msg.addCourse" /> </s:a>
		<s:a action="deleteCourse?courseId=5"><fmt:message key="msg.deleteCourse" /> </s:a>
		<a href="showCourseDetail?courseId=1"><fmt:message key="msg.courseDetail" /> </a>
	</div>
	<div id="listCourses">
		
	</div>
	<div id="listSubjects">
	</div>
</div>