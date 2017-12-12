<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>云吞系统 添加账户</title>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css" >
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="container">
    <jsp:include page="../navigation.jsp"/>
    <hr/>
    <h3>添加账户
        <a type="button" href="/admin/accounts/${userid}" class="btn btn-default btn-sm">返回</a>
    </h3>
    <form:form action="/admin/accounts/addpost" method="post" modelAttribute="account">
        <div class="form-group row">
            <label for="name" class="col-sm-1 col-form-label">账户名:</label>
            <div class="col-sm-2">
                <form:input class="form-control" path="name"/>
                    <%--<input type="text" class="form-control" name="name" placeholder=""/>--%>
            </div>
            <div class="col-sm-3">
                <form:errors cssStyle="color:red" path="name"/>
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-1 col-form-label">密码:</label>
            <div class="col-sm-2">
                <form:input class="form-control" path="password"/><form:hidden path="userid"/>
                    <%--<input type="number"  class="form-control" id="lastName" name="age" placeholder=""/>--%>
            </div>
            <div class="col-sm-3">
                <form:errors cssStyle="color:red" path="password"/>
            </div>
        </div>

        <div class="form-group">
            <button type="submit" class="btn btn-sm btn-success">提交</button>
        </div>
    </form:form>
</div>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>