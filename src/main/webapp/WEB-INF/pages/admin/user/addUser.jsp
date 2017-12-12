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
    <title>云吞系统 添加用户</title>

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
    <h3>添加用户
        <a type="button" href="javascript:window.history.back();" class="btn btn-default btn-sm">返回</a>
    </h3>
    <form:form action="/admin/users/addPost" method="post" modelAttribute="user">
    <div class="form-group row">
        <label for="name" class="col-sm-1 col-form-label">姓名:</label>
        <div class="col-sm-2">
            <form:input class="form-control" path="name"/>
            <%--<input type="text" class="form-control" name="name" placeholder=""/>--%>
        </div>
        <div class="col-sm-3">
            <form:errors cssStyle="color:red" path="name"/>
        </div>
    </div>

    <div class="form-group row">
        <label class="col-sm-1 ">性别:</label>
        <div class="col-sm-2">
        <label class="custom-control custom-radio">
            <%--<form:radiobuttons id="radio1" class="custom-control-input" path="sex"/><form:radiobutton path="sex"/>--%>
            <form:radiobutton id="radio1" value="1" checked="checked" class="custom-control-input" path="sex"/>
            <span class="custom-control-indicator"></span>
            <span class="custom-control-description">男</span>
        </label>
        <label class="custom-control custom-radio">
            <form:radiobutton id="radio2" value="0" class="custom-control-input" path="sex"/>

            <span class="custom-control-indicator"></span>
            <span class="custom-control-description">女</span>
        </label>
        </div>
    </div>
        <div class="form-group row">
            <label class="col-sm-1 col-form-label">年龄:</label>
            <div class="col-sm-2">
                <form:input class="form-control" path="age"/>
                <%--<input type="number"  class="form-control" id="lastName" name="age" placeholder=""/>--%>
            </div>
            <div class="col-sm-3">
                <form:errors cssStyle="color:red" path="age"/>
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-1 col-form-label">电话:</label>
            <div class="col-sm-2">
                <form:input class="form-control" path="phone"/>
                <%--<input type="number" minlength="11" maxlength="11" class="form-control" id="password" name="phone" placeholder=""/>--%>
            </div>
            <div class="col-sm-3">
                <form:errors cssStyle="color:red" path="phone"/>
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