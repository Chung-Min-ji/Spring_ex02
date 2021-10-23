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

<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header"> Board Read </h1>
    </div>
    <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">

            <div class="panel-heading">Board Read Page</div>
            <!-- /.pannel-heading -->
            <div class="panel-body">

                <div class="form-group">
                    <label>Bno</label>
                    <input class="form-control" name="bno" value="<c:out value="${board.bno}" />"
                           readonly="readonly">
                </div>

                <div class="form-group">
                    <label>Title</label>
                    <input class="form-control" name="title" value="<c:out value="${board.title}" />"
                           readonly="readonly">
                </div>

                <div class="form-group">
                    <label>Text area</label>
                    <textarea class="form-control" rows="3" name="content" readonly="readonly">
                        <c:out value="${board.content}" />
                    </textarea>
                </div>

                <div class="form-group">
                    <label>Writer</label>
                    <input class="form-control" name="writer" value="<c:out value="${board.writer}" />"
                           readonly="readonly">
                </div>

                <button data-oper="modify"
                        class="btn btn-default"
                        onclick="location.href='/board/modify?bno=<c:out value="${board.bno}" />'">
                    Modify
                </button>

                <button data-oper="list"
                        class="btn btn-info"
                        onclick="location.href='/board/list'">
                    List
                </button>

                <form id="operForm" action="/board/modify" method="get">
                    <input type="hidden" id="bno" name="bno" value='<c:out value="${board.bno}"/>'>
                </form>

            </div>
            <!-- end panel-body -->

        </div>
        <!-- end panel-heading -->
    </div>
    <!-- end panel -->
</div>
<!-- /.row -->

<%@include file="../includes/footer.jsp" %>

<script type="text/javascript">
    $(function(){
        var operForm = $("#operForm");

        $("button[data-oper='modify']").on("click", function(e){
            operForm.attr("action", "/board/modify").submit();

        }); //on click for modify

        $("button[data-oper='list']").on("click", function(e){
            operForm.find("#bno").remove();
            operForm.attr("action", "/board/list");
            operForm.submit();

        }); //on click for list
    }); //.jq
</script>