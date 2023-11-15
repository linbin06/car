<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html class="loginHtml">
<head>
    <meta charset="utf-8">
    <title>租车管理系统</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="icon" href="${pageContext.request.contextPath}/resources/favicon.ico">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/public.css" media="all"/>
</head>
<body class="loginBody">
<br><br>
<h1 align="center" style="color:LightSteelBlue ; font-size: 50px">租车管理系统</h1>
<br><br>
<form class="layui-form" id="loginFrm" method="post" action="${pageContext.request.contextPath}/login/login.action">
    <div class="login_face">
        <img src="${pageContext.request.contextPath}/resources/images/face.jpg" class="userAvatar" alt=""/>
    </div>
    <div class="layui-form-item input-item">
        <label for="loginName">用户名</label>
        <input type="text" placeholder="请输入用户名" autocomplete="off" name="loginName" id="loginName"
               class="layui-input" lay-verify="required">
    </div>
    <div class="layui-form-item input-item">
        <label for="pwd">密码</label>
        <input type="password" placeholder="请输入密码" autocomplete="off" name="pwd" id="pwd" class="layui-input"
               lay-verify="required">
    </div>
    <div class="layui-form-item input-item" id="imgCode">
        <label for="code">验证码</label>
        <input type="text" placeholder="请输入验证码" autocomplete="off" name="code" id="code" class="layui-input">
        <img src="${pageContext.request.contextPath}/login/getCode.action" onclick="this.src=this.src+'?'" alt="">
    </div>
    <div class="layui-form-item">
        <button class="layui-btn layui-block" lay-filter="login" lay-submit>登录</button>
    </div>
    <div class="layui-form-item layui-row" style="text-align: center;color: red;">
        ${error}
    </div>
</form>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/layui/layui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/cache.js"></script>
<script type="text/javascript">
    layui.use(['layer', 'form', 'jquery'], function () {
        var form = layui.form,
            layer = parent.layer === undefined ? layui.layer : top.layer,
            $ = layui.jquery;

        //登录按钮提交表单
        form.on("submit(login)", function (data) {
            $(this).text("登录中...").attr("disabled", "disabled").addClass("layui-disabled");
            //设置提交
            setTimeout(function () {
                $("#loginFrm").submit();
            }, 1000);
            //阻止默认的提交方式
            return false;
        })

        //表单输入效果
        $(".loginBody .input-item").click(function (e) {
            e.stopPropagation();
            $(this).addClass("layui-input-focus").find(".layui-input").focus();
        })
        $(".loginBody .layui-form-item .layui-input").focus(function () {
            $(this).parent().addClass("layui-input-focus");
        })
        $(".loginBody .layui-form-item .layui-input").blur(function () {
            $(this).parent().removeClass("layui-input-focus");
            if ($(this).val() != '') {
                $(this).parent().addClass("layui-input-active");
            } else {
                $(this).parent().removeClass("layui-input-active");
            }
        })
    })
</script>
</body>
</html>