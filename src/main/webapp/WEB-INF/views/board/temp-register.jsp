<%@ page
        language="java"
        contentType="text/html; charset=utf-8"
        pageEncoding="utf-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ include file ="../includes/header.jsp" %>


<!-- Begin Page Content -->
<div class="container-fluid">

<!-- Page Heading -->
<h1 class="h3 mb-2 text-gray-800">Board Register </h1>

<div class="card shadow mb-4">
    <div class="card-header py-3">
        <div class="m-0 font-weight-bold text-primary">Board Register</div>
    </div>

    <div class="card-body">
        <form role="form" action="/board/register" method="post">
            <div class="form-group">
                <label>Title</label>
                <input class="form-control" name="title">
            </div>

            <div class="form-group">
                <label>Text area</label>
                <textarea class="form-control" row="3" name="content"></textarea>
            </div>

            <div class="form-group">
                <label>Writer</label>
                <input class="form-control" name="writer">
            </div>
            <button type="submit" class="btn btn-default">Submit Button</button>
            <button type="reset" class="btn btn-default">Reset Button</button>
        </form>
    </div>
    <!-- end card-body-->
</div>
<!--end panel-heading -->
</div>
<!-- end panel -->


<%@include file="../includes/footer.jsp" %>
