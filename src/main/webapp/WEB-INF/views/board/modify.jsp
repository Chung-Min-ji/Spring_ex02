<%@ page
        language="java"
        contentType="text/html; charset=utf-8"
        pageEncoding="utf-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ include file="../includes/header.jsp" %>

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

                <form role="form" action="/board/modify" method="post">
                    <div class="form-group">
                        <label>Bno</label>
                        <input class="form-control" name="bno" value="<c:out value="${board.bno}" />"
                               readonly="readonly">
                    </div>

                    <div class="form-group">
                        <label>Title</label>
                        <input class="form-control" name="title" value="<c:out value="${board.title}" />">
                    </div>

                    <div class="form-group">
                        <label>Text area</label>
                        <textarea class="form-control" rows="3" name="content">
                        <c:out value="${board.content}"/></textarea>
                    </div>

                    <div class="form-group">
                        <label>Writer</label>
                        <input class="form-control" name="writer" value="<c:out value="${board.writer}" />"
                               readonly="readonly">
                    </div>

                    <div class="form-group">
                        <label>RegDate</label>
                        <input class="form-control" name="regDate"
                               value='<fmt:formatDate pattern="yyyy/MM/dd" value="${board.regdate}" />'
                               readonly="readonly">
                    </div>

                    <div class="form-group">
                        <label>Update Date</label>
                        <input class="form-control" name="updateDate"
                               value='<fmt:formatDate pattern="yyyy/MM/dd" value="${board.updateDate}" />'
                               readonly="readonly">
                    </div>

                    <button type="submit" data-oper="modify" clas="btn btn-default">Modify</button>
                    <button type="submit" data-oper="remove" clas="btn btn-default">Remove</button>
                    <button type="submit" data-oper="list" clas="btn btn-default">List</button>
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

        var formObj = $("form");

        $("button").on("click", function(e){
            e.preventDefault();

            var operation = $(this).data("oper");

            console.log(operation);

            if(operation === 'remove'){
                formObj.attr("action", "/board/remove");

            } else if (operation === 'list'){
                //move to list
                formObj.attr("action", "/board/list").attr("method", "get");
                formObj.empty();

            } //if-else if

            formObj.submit();

        }); //on click for button
    }) //.jq
</script>