<%@ page
        language="java"
        contentType="text/html; charset=utf-8"
        pageEncoding="utf-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@include file="../includes/header.jsp"%>

<%--<div class="row">--%>
<%--    <div class="col-lg-12">--%>
<%--        <h1 class="page-header"> Tables </h1>--%>
<%--    </div>--%>
<%--    <!-- /.col-lg-12 -->--%>
<%--</div>--%>
<%--<!-- /.row -->--%>

<%--<div class="row">--%>
<%--    <div class="col-lg-12">--%>
<%--        <div class="panel panel-default">--%>
<%--            <div class="panel-heading">Board List Page</div>--%>
<%--            <!-- /.panel-heading -->--%>
<%--            <div class="panel-body">--%>
<%--                <table class="table table-striped table-bordered table-hover">--%>
<%--                    <thead>--%>
<%--                        <tr>--%>
<%--                            <th>#번호</th>--%>
<%--                            <th>제목</th>--%>
<%--                            <th>작성자</th>--%>
<%--                            <th>작성일</th>--%>
<%--                            <th>수정일</th>--%>
<%--                        </tr>--%>
<%--                    </thead>--%>
<%--                </table>--%>
<%--            </div>--%>
<%--            <!-- end panel-body -->--%>
<%--        </div>--%>
<%--        <!-- end panel -->--%>
<%--</div>--%>
<%--<!-- /.row -->--%>


<!-- Begin Page Content -->
<div class="container-fluid">

<!-- Page Heading -->
<h1 class="h3 mb-2 text-gray-800">Tables</h1>

<!-- DataTales Example -->
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">Board List Page</h6>
    </div>
    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead>
                    <tr>
                        <th>#번호</th>
                        <th>제목</th>
                        <th>작성자</th>
                        <th>작성일</th>
                        <th>수정일</th>
                    </tr>
                </thead>

                <c:forEach items="${list}" var="board">
                    <tr>
                        <td><c:out value="${board.bno}" /></td>
                        <td><c:out value="${board.title}" /></td>
                        <td><c:out value="${board.writer}" /></td>
                        <td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.regdate}"/></td>
                        <td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.updateDate}"/></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>

</div>


<%@include file="../includes/footer.jsp"%>